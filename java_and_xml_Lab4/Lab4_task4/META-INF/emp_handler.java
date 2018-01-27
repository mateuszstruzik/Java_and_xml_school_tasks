import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by MATI on 16.11.2017.
 */
public class emp_handler {
    public static void emp_channel(Document document) throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("Root element :"+document.getDocumentElement().getNodeName());
        NodeList nodeList = document.getElementsByTagName("employee");
        emp_index_element(nodeList);

        //System.out.println("</"+document.getDocumentElement().getNodeName()+">");
    }
    private static void emp_index_element(NodeList nodeList) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer=new PrintWriter("Lab4_task4_output.txt","UTF-8");

        for(int i=0;i<nodeList.getLength();i++){
            Node nNode=nodeList.item(i);
            System.out.println("\n"+nNode.getNodeName());

            if(nNode.getNodeType()==Node.ELEMENT_NODE){
                Element eElement = (Element)nNode;
                String [] kk=new String[4];

                kk[0]=eElement.getElementsByTagName("name").item(0).getTextContent();
                System.out.println(eElement.getElementsByTagName("name").item(0).getTextContent());

                kk[1]=eElement.getElementsByTagName("dayOfBirth").item(0).getTextContent();
                System.out.println(eElement.getElementsByTagName("dayOfBirth").item(0).getTextContent());

                kk[2]=eElement.getElementsByTagName("dept").item(0).getTextContent();
                System.out.println(eElement.getElementsByTagName("dept").item(0).getTextContent());

                kk[3]=eElement.getElementsByTagName("jobTitle").item(0).getTextContent();
                System.out.println(eElement.getElementsByTagName("jobTitle").item(0).getTextContent());

                writer.println(kk[0]+","+kk[1]+","+kk[2]+","+kk[3]);
            }
        }
        writer.close();
    }
}
