import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by MATI on 23.11.2017.
 */
public class Lab5_task3 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("Lab5_task3.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userHandler = new UserHandler();
            saxParser.parse(inputFile, userHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class UserHandler extends DefaultHandler {

    Personaldate person;
    ArrayList<Personaldate> obj = new ArrayList<Personaldate>();

    boolean bName = false, bSurname=false, bHomeaddr=false, bPhone=false, bJob=false;

        @Override
        public void startElement(String uri, String localName, String qname, Attributes attr) throws SAXException {
            if(qname.equalsIgnoreCase("PERSON")) {
                person = new Personaldate();
            }else if (qname.equalsIgnoreCase("NAME")) {
                bName=true;
                //System.out.println("Start tag: " + qname);
            } else if (qname.equalsIgnoreCase("SURNAME")) {
                //System.out.println("Start tag: " + qname);
                bSurname=true;
            } else if (qname.equalsIgnoreCase("HOMEADDR")) {
                //System.out.println("Start tag: " + qname);
                bHomeaddr = true;
            } else if (qname.equalsIgnoreCase("PHONE")) {
                //System.out.println("Start tag: " + qname);
                bPhone = true;
            } else if (qname.equalsIgnoreCase("JOB")) {
                //System.out.println("Start tag: " + qname);
                bJob = true;
            }
        }

        @Override
        public void endElement(String uri, String localname, String qname) throws SAXException {
            if(qname.equalsIgnoreCase("PERSON")){
                obj.add(person);
            }else if(qname.equalsIgnoreCase("note")){
                for(int i=0;i<obj.size();i++){
                    obj.get(i).printDate();
                }
            }
//            if (qname.equalsIgnoreCase("orders")) {
//                //System.out.println("End tag: " + qname);
//            }

        }

        public void characters(char ch[], int start, int length) throws SAXException {
                if (bName) {
                person.setImie(new String(ch, start, length));
                //System.out.println(new String(ch,start,length));
                bName=false;
                }else if(bSurname){
                    person.setNazwisko(new String(ch,start,length));
                    bSurname=false;
                }else if(bHomeaddr){
                    person.setAdres(new String(ch,start,length));
                    bHomeaddr=false;
                }else if(bPhone){
                    person.setTele(new String(ch,start,length));
                    bPhone=false;
                }else if(bJob){
                    person.setZawod(new String(ch,start,length));
                    bJob=false;
                }
        }


    }
