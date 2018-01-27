import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by MATI on 06.12.2017.
 */
public class Lab7_task1  {
    public static void main(String[] args) {
        try {
            File inputFile = new File("sim.xml");
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

    GetVaules getVaules=new GetVaules();
    Measures measures;
    XmlWriter xmlWriter=new XmlWriter();
    ArrayList<Measures> obj = new ArrayList<Measures>();
    ArrayList<Measures> obj2=new ArrayList<Measures>();
    ArrayList<String> comp=new ArrayList<String>();

    public void addcomp(){
        for(int i=0; i<obj.size();i++){
            if(!comp.contains(obj.get(i).service_component_name)){
                comp.add(obj.get(i).service_component_name);
            }
        }
    }

    public void licz(){
        addcomp();
        double suma=0;
        int count=0;
        for(int i=0;i<comp.size();i++){
            for(int j=0;j<obj.size();j++){
                String a=new String(comp.get(i));
                String b=new String(obj.get(j).service_component_name);
                if(comp.get(i).equals(obj.get(j).service_component_name)){
                    double c =Double.parseDouble(obj.get(j).responseperiod);
                    suma=suma + c;
                    count++;
                }
            }
            System.out.println("Sredni response period dla copmponentu " +comp.get(i)+" wynosi :"+(suma/count) );
            getVaules.first_data.put(comp.get(i),(suma/count));
        }
    }

    public void act_licz(){
        comp = new ArrayList<String>();
        for(int i=0 ; i<obj2.size();i++){
            if(!comp.contains(obj2.get(i).activityname)){
                comp.add(obj2.get(i).activityname);
            }
        }
        double suma=0;
        int ccc, cco;
        for(int i=0;i<comp.size();i++){
            ccc=0;
            cco=0;
            for(int j=0;j<obj2.size();j++){
                String a=new String(comp.get(i));
                String b=new String(obj2.get(j).activityname);
                if(comp.get(i).equals(obj2.get(j).activityname)) {
                    ccc++;
                    if (comp.get(i).equals(obj2.get(j).activityname) && obj2.get(j).act_status.equals("ok")) {
                        suma = suma + Double.parseDouble(obj2.get(j).act_responseperiod);
                        cco++;
                    }
                }
            }

            System.out.println("percentage of activities  for each \"activityname\" answered not-correctly for :"+comp.get(i)+"wynosi " +(100-(cco*100)/ccc));
            getVaules.second_data.put(comp.get(i),(100-(cco*100)/ccc));
        }
        System.out.println();
        System.out.println("Sredni response period dla activity z statsuem 'OK' wynosi :" +suma/obj2.size());
        getVaules.val = suma/obj2.size();
    }

    boolean breponseperiod = false;
    boolean bservice_component_name =false;
    boolean act_responseperiod=false;

    String res;
    String com;
    String act_res;
    String act_stat;
    String act_name;
    int act_res_cc=0;

    int check=0;

    @Override
    public void startElement(String uri, String localName, String qname, Attributes attr) throws SAXException {

        if(qname.equalsIgnoreCase("measurement")) {
           measures = new Measures();
           if (qname.equalsIgnoreCase("measurement") && attr.getValue("status").equals("ok") && attr.getValue("id").equals("req")) {
               breponseperiod = true;
               bservice_component_name = true;
               res = attr.getValue("responseperiod");
               com = attr.getValue("servicecomponent_name");
               check=1;
               //System.out.println("Start tag: " + qname);
           } else if (qname.equalsIgnoreCase("measurement") && attr.getValue("id").equals("act")) {
                   act_responseperiod = true;
                   act_res = attr.getValue("responseperiod");
                   act_stat= attr.getValue("status");
                   act_name = attr.getValue("activityname");

                   check = 2;
               }

           }
       }

    @Override
    public void endElement(String uri, String localname, String qname) throws SAXException {
        if(qname.equalsIgnoreCase("measurement")&& check==1){
            obj.add(measures);
            check=0;
        }
        else if(qname.equalsIgnoreCase("measurement")&& check==2){
            obj2.add(measures);
            check=0;
        }
        else if(qname.equalsIgnoreCase("result"))
        {
            System.out.println("koncze xml");
            licz();
            act_licz();

            xmlWriter.Writer(getVaules.first_data,getVaules.second_data,getVaules.val);
        }

//            if (qname.equalsIgnoreCase("orders")) {
//                //System.out.println("End tag: " + qname);
//            }

    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (breponseperiod && bservice_component_name) {
            measures.setResponseperiod(res);
            //System.out.println(new String(ch,start,length));
            measures.setService_component_name(com);


            bservice_component_name =false;
            breponseperiod =false;
        }else if(act_responseperiod){
            measures.setAct_responseperiod(act_res);
            measures.setAct_status(act_stat);
            measures.setActivityname(act_name);
            act_responseperiod=false;
        }


}
}
