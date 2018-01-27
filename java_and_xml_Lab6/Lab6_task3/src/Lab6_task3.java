import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by MATI on 30.11.2017.
 */
public class Lab6_task3 {
    public static void main(String[] args) throws JAXBException {


        File file = new File("book.xml");
        JAXBContext jaxbContext=JAXBContext.newInstance(Catalog.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Catalog catalog=(Catalog) unmarshaller.unmarshal(file);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        //int i=


        marshaller.marshal(catalog,System.out);

        catalog.Mostexpensive();
        catalog.Avarageprice();
        catalog.Oldestbook();

    }
}

@XmlRootElement(name="catalog")
@XmlAccessorType(XmlAccessType.FIELD)
class Catalog{


    @XmlElement(name="book")
    public ArrayList<Book> catalog=new ArrayList<Book>();

    public void Mostexpensive(){

        String title=new String();
        double price=0;

        for(Book b : catalog){
            if(b.Price>price){
                price=b.Price;
                title=b.Title;
            }
        }

        System.out.println("Most expensive book is :" + title);
    }
    public void Avarageprice(){
        double suma=0;
        int count=0;

        for(Book b : catalog){
            suma = suma +b.Price;
            count++;
        }

        System.out.println("Avarage price of book is : "+(suma/count));
    }

    public void Oldestbook(){

        char c;
        String title=new String();

        String com_year=new String();
        String  com_month=new String();
        String  com_day=new String();
        com_year="3000";
        com_month="20";
        com_day="32";
        for(Book b : catalog){
            String year=new String();
            String month=new String();
            String day=new String();
               for(int i=0; i<4;i++){
                    c=b.Publish_date.charAt(i);
                    year=year+c;
               }
            if(Integer.parseInt(com_year)>Integer.parseInt(year)){
                com_year=year;
                title=b.Title;
            }
            else if(Integer.parseInt(com_year)==Integer.parseInt(year)){
                for(int i=5; i<7 ; i++){
                    c=b.Publish_date.charAt(i);
                    month=month+c;
                }
                if(Integer.parseInt(com_month)>Integer.parseInt(month)){
                    com_month=month;
                    title=b.Title;
                }
                else if (Integer.parseInt(com_month)==Integer.parseInt(month)){
                    for(int i=8;i<10;i++){
                        c=b.Publish_date.charAt(i);
                        day=day+c;
                    }
                    if(Integer.parseInt(com_day)>Integer.parseInt(day)){
                        com_day=day;
                        title=b.Title;
                    }
                }

            }



        }

        System.out.println("The oldest book is : "+title );
    }
}

class Book{

    String name;

    @XmlAttribute(name="id")
    public String id;

    @XmlElement(name="author")
    public String Author;

    @XmlElement(name="title")
    public String Title;

    @XmlElement(name="genre")
    public String Genre;

    @XmlElement(name="price")
    public double Price ;

    @XmlElement(name="publish_date")
    public String Publish_date;

    @XmlElement(name="description")
    public String Description;

}


//<book id="bk101">
//<author>Gambardella, Matthew</author>
//<title>XML Developer's Guide</title>
//<genre>Computer</genre>
//<price>44.95</price>
//<publish_date>2000-10-01</publish_date>
//<description>
//            An in-depth look at creating applications with XML.
//</description>
//</book>