import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by MATI on 22.11.2017.
 */
public class Lab4_task5 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile=new File("Lab4_task5.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(true);
        DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
        ErrorHandler errorHandler=new DefaultHandler();
        documentBuilder.setErrorHandler(errorHandler);
        Document document = documentBuilder.parse(xmlFile);
        document.getDocumentElement().normalize();
        Xml_parse.Xml_channel(document);

    }
}
