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
 * Created by MATI on 23.11.2017.
 */
public class Lab5_task4 {
    public static void main(String[] args) {


        ArrayList<String> colory=new ArrayList<String>();
        colory.add("red");
        colory.add("green");
        colory.add("blue");
        Random random = new SecureRandom();

        int r;
        int j;
        String jk;

        try{
            FileWriter fileWriter = new FileWriter("colors.xml");
            StringWriter stringWriter=new StringWriter();
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter=xmlOutputFactory.createXMLStreamWriter(stringWriter);

            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeCharacters(System.getProperty("line.separator"));
            xmlStreamWriter.writeStartElement("values");
            xmlStreamWriter.writeCharacters(System.getProperty("line.separator"));

            for(int i=0;i<51;i++) {
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

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
