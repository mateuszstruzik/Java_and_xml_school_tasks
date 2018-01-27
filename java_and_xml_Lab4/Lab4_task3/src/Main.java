import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by MATI on 16.11.2017.
 */
public class Main {
public static void main(String argv[]) throws ParserConfigurationException, TransformerException {
    DocumentBuilderFactory builder=DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder=builder.newDocumentBuilder();
    Document doc = docBuilder.newDocument();

    Element root = doc.createElement("employees");
    doc.appendChild(root);

    int i=txtlinecount();
    String [] names = txtnameread(i);
    String [] birth = txtdateofbirth(i);
    String [] dept=txtdept(i);
    String [] j_title=txttitle(i);
    for(int j =0 ; j<i;j++){
        Element child=doc.createElement("employee");
        root.appendChild(child);

        Element name= doc.createElement("name");
        child.appendChild(name);
        Text t_name=doc.createTextNode(names[j]);
        name.appendChild(t_name);

        Element dayOfBirth= doc.createElement("dayOfBirth");
        child.appendChild(dayOfBirth);
        Text t_birth=doc.createTextNode(birth[j]);
        dayOfBirth.appendChild(t_birth);

        Element deptjob= doc.createElement("dept");
        child.appendChild(deptjob);
        Text t_dept=doc.createTextNode(dept[j]);
        deptjob.appendChild(t_dept);

        Element jobTitle= doc.createElement("jobTitle");
        child.appendChild(jobTitle);
        Text t_title=doc.createTextNode(j_title[j]);
        jobTitle.appendChild(t_title);

    }

    TransformerFactory transfac=TransformerFactory.newInstance();
    Transformer trans=transfac.newTransformer();
    trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    trans.setOutputProperty(OutputKeys.INDENT, "yes");

    StringWriter sw = new StringWriter();
    StreamResult result = new StreamResult(sw);
    StreamResult result_to_file=new StreamResult(new File("Lab4_task3_output.xml"));
    DOMSource source = new DOMSource(doc);
    trans.transform(source, result);
    trans.transform(source, result_to_file);
    String xmlString=sw.toString();

    System.out.println("Here's the xml:\n\n" + xmlString);
}

private static int txtlinecount() {
    int i=0;
    try (BufferedReader br = new BufferedReader(new FileReader("F:\\java and xml\\java_and_xml_Lab4\\Lab4_task3\\src\\base.txt"))) {
        for(String line;(line=br.readLine())!=null;)
            i++;

        } catch (IOException e1) {
        e1.printStackTrace();
    }
    return i;
}

private static String[] txtnameread(int lines){
   String[] name = new String[lines];
   int j=0;
   // ArrayList<String> name=new ArrayList<String>();
    try{
        BufferedReader bbbreader =new BufferedReader(new FileReader("F:\\java and xml\\java_and_xml_Lab4\\Lab4_task3\\src\\base.txt"));
        for(String line;(line=bbbreader.readLine())!=null;){
            String[]help=line.split(",");
            name[j]=help[0];
            j++;
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


    return name;
}
    private static String[] txtdateofbirth(int lines){
        String[] date = new String[lines];
        int j=0;
        // ArrayList<String> name=new ArrayList<String>();
        try{
            BufferedReader bbbreader =new BufferedReader(new FileReader("F:\\java and xml\\java_and_xml_Lab4\\Lab4_task3\\src\\base.txt"));
            for(String line;(line=bbbreader.readLine())!=null;){
                String[]help=line.split(",");
                date[j]=help[1];
                j++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return date;
    }

    private static String[] txtdept(int lines){
        String[] dept = new String[lines];
        int j=0;
        // ArrayList<String> name=new ArrayList<String>();
        try{
            BufferedReader bbbreader =new BufferedReader(new FileReader("F:\\java and xml\\java_and_xml_Lab4\\Lab4_task3\\src\\base.txt"));
            for(String line;(line=bbbreader.readLine())!=null;){
                String[]help=line.split(",");
                dept[j]=help[2];
                j++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return dept;
    }

    private static String[] txttitle(int lines){
        String[] title = new String[lines];
        int j=0;
        // ArrayList<String> name=new ArrayList<String>();
        try{
            BufferedReader bbbreader =new BufferedReader(new FileReader("F:\\java and xml\\java_and_xml_Lab4\\Lab4_task3\\src\\base.txt"));
            for(String line;(line=bbbreader.readLine())!=null;){
                String[]help=line.split(",");
                title[j]=help[3];
                j++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return title;
    }
}


