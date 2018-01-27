import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by MATI on 22.11.2017.
 */
public class Xml_parse {
    public static void Xml_channel(Document document){
        System.out.println("Root element :"+document.getDocumentElement().getNodeName());
        NodeList nodeList=document.getElementsByTagName("POSITION");
        xml_channel(nodeList);

    }
    private static void xml_channel(NodeList nodeList){
        for(int i=0;i<nodeList.getLength();i++) {
            Node nNode = nodeList.item(i);
            //System.out.println("\ntag :"+nNode.getNodeName());

            if(nNode.getNodeType()==Node.ELEMENT_NODE){
                Element element=(Element)nNode;
                System.out.println("position:"+element.getAttribute("NAME"));

                NodeList secondList = element.getElementsByTagName("index");

                for(int j=0;j<secondList.getLength();j++){
                    Node secondnode=secondList.item(j);

                    if(secondnode.getNodeType()==Node.ELEMENT_NODE){
                        Element secondelement=(Element)secondnode;
                        System.out.println("id :"+secondelement.getAttribute("id"));
                        System.out.println("name :"+secondelement.getElementsByTagName("NAME").item(0).getTextContent());

                        if(secondelement.getElementsByTagName("SECONDNAME").getLength()!=0) {
                            System.out.println("second name :" + secondelement.getElementsByTagName("SECONDNAME").item(0).getTextContent());
                        }
                        if(secondelement.getElementsByTagName("FAMILYNAME").getLength()!=0) {
                            System.out.println("familyname :" + secondelement.getElementsByTagName("FAMILYNAME").item(0).getTextContent());
                        }
                        System.out.println("phone :"+secondelement.getElementsByTagName("PHONE").item(0).getTextContent());
                        System.out.println("home addres :"+secondelement.getElementsByTagName("HOMEADDR").item(0).getTextContent());


                        }

                    }

                }


            }
        }
    }

