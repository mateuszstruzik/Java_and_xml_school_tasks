import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.CharArrayWriter;
import java.io.File;

/**
 * Created by MATI on 16.11.2017.
 */
public class Lab5_task1 {

    public static void main(String[] argv){

        try{
            File inputFile = new File("Lab5_task1.xml");
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

         String black_king = "Black_king";
         String black_kights = "Black_kights";
         String black_queen = "Black_queen";
         String white_king = "White_king";
         String white_queen = "White_queen";
         String white_roks = "White_rooks";
        boolean isblack_king = false, isblack_kights = false, isblack_queen = false,
                iswhite_king = false, iswhite_queen = false, iswhite_roks = false;

        @Override
        public void startElement(String uri, String localName, String qname, Attributes attr)throws SAXException{
          if(qname.equalsIgnoreCase("chess")){
              System.out.println("board");
          } else if (qname.equalsIgnoreCase("White_king")){
              iswhite_king=true;
          }else if (qname.equalsIgnoreCase("White_queen")){
              iswhite_queen=true;
          }else if (qname.equalsIgnoreCase("White_roks")){
              iswhite_roks=true;
          }else if (qname.equalsIgnoreCase("Black_king")){
              isblack_king=true;
          }else if (qname.equalsIgnoreCase("Black_kights")){
              isblack_kights=true;
          }else if (qname.equalsIgnoreCase("Black_queen")){
              isblack_queen=true;
          }
        }

        @Override
        public void endElement(String uri, String localname, String qname) throws SAXException{
            if(qname.equalsIgnoreCase("chess")){
                System.out.println("chess end");
            }
        }

        public void characters(char ch[], int start, int length) throws SAXException{
            if(iswhite_king){
                System.out.println("White_king :"+new String(ch,start,length));
                iswhite_king=false;
            }else if(iswhite_queen) {
                System.out.println("White_queen :"  + new String(ch, start, length));
                iswhite_queen = false;
            }else if(iswhite_roks) {
                System.out.println("White_roks  :"  + new String(ch, start, length));
                iswhite_roks = false;
            }else if(isblack_king) {
                System.out.println("Black_king :"  + new String(ch, start, length));
                isblack_king = false;
            }else if(isblack_kights) {
                System.out.println("Black_kights :" + new String(ch, start, length));
                isblack_kights = false;
            }else if(isblack_queen) {
                System.out.println("Black_queen :"  + new String(ch, start, length));
                isblack_queen = false;
            }
        }


    }





    /*class chess {
        public String black_king = "Black_king";
        public String black_kights = "Black_kights";
        public String black_queen = "Black_queen";
        public String white_king = "White_king";
        public String white_queen = "White_queen";
        public String white_rroks = "White_rooks";

                boolean isblack_king = false, isblack_kights = false, isblack_queen = false,
                iswhite_king = false, iswhite_queen = false, iswhite_rroks = false;
    }*/