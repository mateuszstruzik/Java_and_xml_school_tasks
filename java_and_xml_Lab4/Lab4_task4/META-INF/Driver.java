import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by MATI on 16.11.2017.
 */
    public class Driver {
        public static void main(String argv[]) throws ParserConfigurationException, IOException, SAXException {
            File xmlFile=new File("F:\\java and xml\\java_and_xml_Lab4\\Lab4_task4\\src\\Lab4_task4.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            emp_handler.emp_channel(document);
        }
    }

