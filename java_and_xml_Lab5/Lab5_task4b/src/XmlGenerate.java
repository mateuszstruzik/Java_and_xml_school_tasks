import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by MATI on 30.11.2017.
 */
public class XmlGenerate {

    private ArrayList<String> colory=new ArrayList<String>();

    Random random = new SecureRandom();
    int r;
    int j;
    String jk;



    private void SetArray(){
        colory.add("red");
        colory.add("green");
        colory.add("blue");
    }

    public void XmlCreate(int n, String name) throws IOException, XMLStreamException {
        FileWriter fileWriter=new FileWriter(name);
        StringWriter stringWriter=new StringWriter();
        XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();
        XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);

        xmlStreamWriter.writeStartDocument();
        xmlStreamWriter.writeCharacters(System.getProperty("line.separator"));
        xmlStreamWriter.writeStartElement("values");
        xmlStreamWriter.writeCharacters(System.getProperty("line.separator"));

        SetArray();
        for(int i=0;i<n;i++) {
            r = random.nextInt(3);
            j=random.nextInt(255);
            jk=Integer.toString(j);

            xmlStreamWriter.writeStartElement("value");
            xmlStreamWriter.writeAttribute("colour", colory.get(r));
            xmlStreamWriter.writeCharacters(jk);


            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeCharacters(System.getProperty("line.separator"));
        }
        xmlStreamWriter.writeEndElement();
        xmlStreamWriter.writeEndDocument();
        xmlStreamWriter.flush();
        xmlStreamWriter.close();

        fileWriter.write(stringWriter.getBuffer().toString());
        fileWriter.close();

        String xmlString=stringWriter.getBuffer().toString();

        stringWriter.close();
        System.out.println(xmlString);

    }
}
