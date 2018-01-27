import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by MATI on 06.12.2017.
 */
public class Lab5_task3b {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        boolean bName = false, bSurname=false, bHomeaddr=false, bPhone=false, bJob=false;

        Personaldate person = null;
        ArrayList<Personaldate> obj = new ArrayList<Personaldate>();

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("Lab5_task3.xml"));

        while(eventReader.hasNext()){
            XMLEvent event=eventReader.nextEvent();

            switch(event.getEventType()){

                case XMLStreamConstants.START_ELEMENT:
                    StartElement startElement=event.asStartElement();
                    String qname=startElement.getName().getLocalPart();

                    if(qname.equalsIgnoreCase("PERSON")){
                        person=new Personaldate();
                    }
                    else if (qname.equalsIgnoreCase("NAME")){
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
                    break;

                case XMLStreamConstants.CHARACTERS:
                    Characters characters=event.asCharacters();
                    if (bName) {
                        person.setImie(new String (characters.getData()));
                        //System.out.println(new String(ch,start,length));
                        bName=false;
                    }else if(bSurname){
                        person.setNazwisko(new String(characters.getData()));
                        bSurname=false;
                    }else if(bHomeaddr){
                        person.setAdres(new String(characters.getData()));
                        bHomeaddr=false;
                    }else if(bPhone){
                        person.setTele(new String(characters.getData()));
                        bPhone=false;
                    }else if(bJob){
                        person.setZawod(new String(characters.getData()));
                        bJob=false;
                    }
                    break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement=event.asEndElement();

                        if(endElement.getName().getLocalPart().equalsIgnoreCase("PERSON")){
                            obj.add(person);
                        }else if(endElement.getName().getLocalPart().equalsIgnoreCase("note")){
                            for (int i=0; i<obj.size();i++){
                                obj.get(i).printDate();
                            }
                        }
            }
            }
        }

    }

