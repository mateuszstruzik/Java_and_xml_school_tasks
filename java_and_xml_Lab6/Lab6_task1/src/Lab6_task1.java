import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

/**
 * Created by MATI on 30.11.2017.
 */
public class Lab6_task1 {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Chess.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Chess chess=(Chess) unmarshaller.unmarshal(new File("Lab6_task1.xml"));
        Marshaller marshaller=jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        System.out.println("White king :" +chess.White_king );
        System.out.println("White queen :" +chess.White_queen );
        System.out.println("White rooks :" +chess.White_rooks );
        System.out.println("Black kights :" +chess.Black_kights);
        System.out.println("Black king :" +chess.Black_king );
        System.out.println("Black king :" +chess.Black_queen );



    }
}

@XmlRootElement(name="chess")
@XmlAccessorType(XmlAccessType.FIELD)
class Chess
{
    String name;

    @XmlElement(name="White_king")
    public String White_king;


    @XmlElement(name="White_queen")
    public String White_queen;

    @XmlElement(name="White_rooks")
    public String White_rooks;

    @XmlElement(name="Black_kights")
    public String Black_kights;

    @XmlElement(name="Black_king")
    public String Black_king;

    @XmlElement(name="Black_queen")
    public String Black_queen;

}