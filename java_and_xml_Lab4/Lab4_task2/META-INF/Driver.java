import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;
/**
 * Created by MATI on 15.11.2017.
 */
public class Driver {
    public static void main(String argv[]) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile=new File("resources/books.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        document.getDocumentElement().normalize();
        Book_handler.Book_channel(document);
    }
}
