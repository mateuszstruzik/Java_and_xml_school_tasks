import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
/**
 * Created by MATI on 30.11.2017.
 */
public class Lab5_task4b {
    public static void main(String[] args) throws IOException, XMLStreamException, ParserConfigurationException, SAXException {
        XmlGenerate xmlGenerate=new XmlGenerate();
        Measure measure=new Measure();

        xmlGenerate.XmlCreate(100,"colors50.xml");
        xmlGenerate.XmlCreate(1000,"colors100.xml");
        xmlGenerate.XmlCreate(10000,"colors200.xml");
        xmlGenerate.XmlCreate(100000,"colors300.xml");

        long start =System.nanoTime();
        measure.DomMeasure("colors50.xml");
        long stop = System.nanoTime();
        System.out.println("time for 50n DOM :"+((stop-start)/1000000));

        start=System.nanoTime();
        measure.MeasureSAX("colors50.xml");

        stop=System.nanoTime();
        System.out.println("time for 50n SAX :"+((stop-start)/1000000));

        start =System.nanoTime();
        measure.DomMeasure("colors100.xml");
        stop = System.nanoTime();
        System.out.println("time for 100n DOM :"+((stop-start)/1000000));

        start =System.nanoTime();
        measure.MeasureSAX("colors100.xml");
        stop = System.nanoTime();
        System.out.println("time for 100n SAX :"+((stop-start)/1000000));

        start =System.nanoTime();
        measure.DomMeasure("colors200.xml");
        stop = System.nanoTime();
        System.out.println("time for 200n DOM :"+((stop-start)/1000000));

        start=System.nanoTime();
        measure.MeasureSAX("colors200.xml");

        stop=System.nanoTime();
        System.out.println("time for 200n SAX :"+((stop-start)/1000000));

        start =System.nanoTime();
        measure.DomMeasure("colors300.xml");
        stop = System.nanoTime();
        System.out.println("time for 300n DOM :"+((stop-start)/1000000));

        start=System.nanoTime();
        measure.MeasureSAX("colors300.xml");

        stop=System.nanoTime();
        System.out.println("time for 300n SAX :"+((stop-start)/1000000));
    }
}
