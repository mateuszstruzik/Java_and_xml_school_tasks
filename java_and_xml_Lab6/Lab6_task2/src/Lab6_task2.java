import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by MATI on 30.11.2017.
 */
public class Lab6_task2 {
    public static String randname(){
        char[]chars="abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random rm=new Random();
        String st;

        for(int i=0;i<20;i++){
            char c=chars[rm.nextInt(chars.length)];
            sb.append(c);
        }
        st=sb.toString();
        return st;
    }

    public static double randprice(){
        double  rmin=10.0;
        double rmax=100.0;
        Random rm =new Random();
        double rvalue=rmin+(rmax-rmin)* rm.nextDouble();

        return rvalue;
    }

    public static int randcal(){
        int  rmin=10;
        int rmax=2500;
        Random rm =new Random();
        int rvalue=rmin+(rmax-rmin)* rm.nextInt();

        return rvalue;
    }

    public static void main(String[] args) throws JAXBException {

        Menu gen_menu=new Menu();

        for(int i=0;i<10;i++) {
            String gen_name;
            String gen_cate;
            double gen_price = randprice();
            String gen_desc = randname();
            int gen_calo = randcal();

            gen_name = randname();
            gen_cate = randname();

            Food food = new Food();

            food.setFood(gen_name, gen_cate, gen_price, gen_desc, gen_calo);

            gen_menu.menu.add(food);
        }
        File file = new File("Lab6_task2.xml");
        JAXBContext jaxbContext =JAXBContext.newInstance(Menu.class);
        Marshaller marshaller=jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        marshaller.marshal(gen_menu,file);
        marshaller.marshal(gen_menu,System.out);
    }

}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Menu{
    @XmlElement(name="food")
    public ArrayList<Food> menu=new ArrayList<Food>();

//    Menu(){
//        this.menu=new ArrayList<Food>();
//    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Food{

    @XmlElement
    public String name;

    @XmlAttribute
    public String category;

    @XmlElement
    public double price;

    @XmlElement
    public String description;

    @XmlElement
    public int calories;

    public void setFood(String name,String category, double price, String description, int calories){
        this.name=name;
        this.category=category;
        this.price=price;
        this.description=description;
        this.calories=calories;
    }


}
