package xml;

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class Lab4_task1 {
	
	public static void main(String args[] ){
		new Lab4_task1();
	}


public Lab4_task1(){
	
	try{
		DocumentBuilderFactory builder=DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder=builder.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		
		Element root=doc.createElement("ComputerEngineerig");
		doc.appendChild(root);
		
		/*Comment comment = doc.createComment("A comment in a root element");
		root.appendChild(comment);*/
		
		Element child=doc.createElement("Course");
		child.setAttribute("Author", "Mateusz");
		child.setAttribute("Name", "Application programming - Java and XML technologies");
		root.appendChild(child);
		
		Element topic1=doc.createElement("Topics");
		topic1.setNodeValue("1");
		child.appendChild(topic1);
		
		Element topic2=doc.createElement("Topics");
		topic2.setNodeValue("2");
		child.appendChild(topic2);
		
		Text text1=doc.createTextNode("Sample topic here");
		Text text2=doc.createTextNode("Another topic here");
		topic1.appendChild(text1);
		topic2.appendChild(text2);
		
		TransformerFactory transfac=TransformerFactory.newInstance();
		Transformer trans=transfac.newTransformer();
		trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		
		StringWriter sw = new StringWriter();
		StreamResult result = new StreamResult(sw);
		StreamResult result_to_file=new StreamResult(new File("Lab4_task1_output.xml"));
		DOMSource source = new DOMSource(doc);
		trans.transform(source, result);
		trans.transform(source, result_to_file);
		String xmlString=sw.toString();
		
		System.out.println("Here's the xml:\n\n" + xmlString);
	}catch(Exception e){
		System.out.println(e);
	}


	
	}	
	
}