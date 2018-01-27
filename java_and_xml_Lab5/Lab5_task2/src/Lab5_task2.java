import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.StringTokenizer;

/**
 * Created by MATI on 23.11.2017.
 */
public class Lab5_task2 {
    public static void main(String[] args) {

        try{
            File inputFile = new File("Lab5_task2.xml");
            SAXParserFactory factory=SAXParserFactory.newInstance();
            SAXParser saxParser=factory.newSAXParser();
            UserHandler userHandler = new UserHandler();
            saxParser.parse(inputFile,userHandler);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class UserHandler extends DefaultHandler {

    boolean bCount=false;

    @Override
    public void startElement(String uri, String localName, String qname, Attributes attr)throws SAXException {
        if(qname.equalsIgnoreCase("orders")){
            System.out.println("Start tag: "+ qname);
        } else if (qname.equalsIgnoreCase("order")){
            System.out.println("Start tag: "+ qname);
        }else if (qname.equalsIgnoreCase("count")) {
            System.out.println("Start tag: " + qname);
            bCount=true;
        }
    }

    @Override
    public void endElement(String uri, String localname, String qname) throws SAXException{
        if(qname.equalsIgnoreCase("orders")){
            System.out.println("End tag: "+qname);
        }if(qname.equalsIgnoreCase("order")) {
            System.out.println("End tag: " + qname);
        }if(qname.equalsIgnoreCase("count")) {
            System.out.println("End tag: " + qname);
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException{
        if(bCount){
            String data=new String(ch,start,length);
            //System.out.println(new String(ch,start,length));
            StringTokenizer tok = new StringTokenizer(data);
            if(tok.hasMoreTokens()){
                System.out.println(tok.nextToken());
            }
            bCount=false;
        }
    }


}

