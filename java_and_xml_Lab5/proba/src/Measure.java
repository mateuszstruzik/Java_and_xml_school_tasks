import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by MATI on 29.11.2017.
 */
public class Measure {
    public void DomMeasure( String nam) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile=new File(nam);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
        Document document=documentBuilder.parse(xmlFile);
        document.getDocumentElement().normalize();

        NodeList nodeList=document.getElementsByTagName("values");
        NodeList nodevalueList=document.getElementsByTagName("value");
        int count=0;
        int sum=0;

        for(int i=0;i<nodeList.getLength();i++){
            Node nNode=nodeList.item(i);


            if(nNode.getNodeType()==Node.ELEMENT_NODE){
                Element element = (Element)nNode;
                for(int j=0;j<nodevalueList.getLength();j++) {
                    Node nnNode = nodevalueList.item(j);
                    if (nnNode.getNodeType() == Node.ELEMENT_NODE){
                        Element e=(Element)nnNode;

                        if (e.hasAttribute("colour") && e.getAttribute("colour").equals("red")) {
                            count++;
                            sum=sum+Integer.parseInt(element.getElementsByTagName("value").item(j).getTextContent());
                        }
                }
                }
            }
        }
        int result=sum/count;
        System.out.println("Result from DOM : "+result);

    }

    public void MeasureSAX(String nam) throws ParserConfigurationException, SAXException, IOException {
        File inputfile = new File(nam);
        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser saxParser=factory.newSAXParser();
        UserHandler userHandler=new UserHandler();
        saxParser.parse(inputfile,userHandler);

    }
}

class UserHandler extends DefaultHandler{
    boolean bvalue=false;
    String getvalue;
    String attt;
    int count=0;
    int sum=0;
    int p;

    @Override
    public void startElement(String uri, String localName, String qname, Attributes attr) throws SAXException {
        if(qname.equalsIgnoreCase("values") ){

        }else if(qname.equalsIgnoreCase("value") && attr.getValue("colour").equals("red")) {
            bvalue = true;
            count++;
        }

    }

    @Override
    public void endElement(String uri, String localname, String qname) throws SAXException {
        if (qname.equalsIgnoreCase("value")){

        }else if (qname.equalsIgnoreCase("values")){
           // System.out.println(count);
            System.out.println("Result from SAX :"+sum/count);
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if(bvalue){
            getvalue=new String(ch,start,length);

                sum = sum + Integer.parseInt(getvalue.toString());

           bvalue=false;
        }
    }

}
