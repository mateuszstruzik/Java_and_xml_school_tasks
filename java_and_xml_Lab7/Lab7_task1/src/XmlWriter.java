import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by MATI on 10.12.2017.
 */
public class XmlWriter {

    public void Writer(Map<String,Double> map1, Map<String,Integer>map2, double a) {
        String fileName = "outpu.xml";
        String rootElement = "Measures";
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.writeX(fileName,rootElement,map1,map2,a);
    }

    private void writeX(String filename, String rootElement, Map<String,Double>map1,Map<String,Integer>map2,double a){
        XMLOutputFactory xmlOutputFactory=XMLOutputFactory.newInstance();

        try{
            XMLEventWriter xmlEventWriter = xmlOutputFactory.createXMLEventWriter(new FileOutputStream(filename),"UTF-8");

            XMLEventFactory eventFactory=XMLEventFactory.newInstance();
            XMLEvent end = eventFactory.createDTD("\n");
            StartDocument startDocument=eventFactory.createStartDocument();
            xmlEventWriter.add(startDocument);
            xmlEventWriter.add(end);
            StartElement startElement=eventFactory.createStartElement("","",rootElement);
            xmlEventWriter.add(startElement);
            xmlEventWriter.add(end);
            Set<String> elementNodes=map1.keySet();
            for(String key:elementNodes){
                    createNode(xmlEventWriter,key,map1.get(key).toString());
            }

            Set<String> elementNodes2=map2.keySet();
            for(String key:elementNodes2){
                createNode(xmlEventWriter,key,map2.get(key).toString());
            }
            Map<String,Double> val_map=new HashMap<String,Double>();
            val_map.put("value",a);
            Set<String> elementNodes3=val_map.keySet();
            for(String key:elementNodes3){
                createNode(xmlEventWriter,key,val_map.get(key).toString());
            }

            xmlEventWriter.add(eventFactory.createEndElement("", "", rootElement));
            xmlEventWriter.add(end);
            xmlEventWriter.add(eventFactory.createEndDocument());
            xmlEventWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private void createNode(XMLEventWriter eventWriter, String element, String value) throws XMLStreamException {
        XMLEventFactory xmlEventFactory = XMLEventFactory.newInstance();
        XMLEvent end = xmlEventFactory.createDTD("\n");
        XMLEvent tab = xmlEventFactory.createDTD("\t");

        StartElement sElement = xmlEventFactory.createStartElement("", "", element);
        eventWriter.add(tab);
        eventWriter.add(sElement);

        Characters characters = xmlEventFactory.createCharacters(value);
        eventWriter.add(characters);

        EndElement eElement = xmlEventFactory.createEndElement("", "", element);
        eventWriter.add(eElement);
        eventWriter.add(end);

    }

}


