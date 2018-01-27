/**
 * Created by MATI on 06.12.2017.
 */
public class Personaldate {
    private String imie;
    private String nazwisko;
    private String adres;
    private String tele;
    private String zawod;

    public void setImie(String a){
        imie=a;
    }
    public void setNazwisko(String a){
        nazwisko=a;
    }
    public void setAdres(String a){
        adres=a;
    }
    public void setTele(String a){
        tele=a;
    }
    public void setZawod(String a){
        zawod=a;
    }
    public void printDate(){
        System.out.println("Imie :"+imie);
        System.out.println("Nazwisko :"+nazwisko);
        System.out.println("Adres :"+adres);
        System.out.println("Tele :"+tele);
        System.out.println("Zawod :"+zawod);
    }

}
