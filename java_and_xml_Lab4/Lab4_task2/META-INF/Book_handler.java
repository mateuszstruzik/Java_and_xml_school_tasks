import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by MATI on 15.11.2017.
 */
public class Book_handler {
     public static void Book_channel(Document document){
         System.out.println("Root element :"+document.getDocumentElement().getNodeName());
         NodeList nodeList = document.getElementsByTagName("book");
         book_index_element(nodeList);

         //System.out.println("</"+document.getDocumentElement().getNodeName()+">");
     }
     private static void book_index_element(NodeList nodeList){
         for(int i=0;i<nodeList.getLength();i++){
             Node nNode=nodeList.item(i);
             System.out.println("\nCurrent book name :" +nNode.getNodeName());

             if(nNode.getNodeType()==Node.ELEMENT_NODE){
                 Element eElement = (Element)nNode;
                 System.out.println("book id :"+ eElement.getAttribute("id"));
                 System.out.println("author : "+eElement.getElementsByTagName("author").item(0).getTextContent());
                 System.out.println("title : "+eElement.getElementsByTagName("title").item(0).getTextContent());
                 System.out.println("genre : "+eElement.getElementsByTagName("genre").item(0).getTextContent());
                 System.out.println("price : "+eElement.getElementsByTagName("price").item(0).getTextContent());
                 System.out.println("publish date : "+eElement.getElementsByTagName("publish_date").item(0).getTextContent());
                 System.out.println("description : "+eElement.getElementsByTagName("description").item(0).getTextContent());
             }
         }
     }
}
