import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by MATI on 10.12.2017.
 */
public class TICtacToe extends JPanel{

    JButton[] jButtons=new JButton[12];
    int ccc=0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TICtacToe());
        frame.setBounds(300,300,300,400);
        frame.setVisible(true);

    }



        public TICtacToe()
        {
            setLayout(new GridLayout(4,3));
            buttons_for_game();
        }

        public void buttons_for_game(){
            for(int i=0;i<9;i++){
            jButtons[i]=new JButton();
            jButtons[i].setText("");
            jButtons[i].addActionListener(new Action());

            add(jButtons[i]);
            }

            jButtons[9]=new JButton();
            jButtons[9].setText("SAVE");
            jButtons[9].addActionListener(new save());
            add(jButtons[9]);

            jButtons[10]=new JButton();
            jButtons[10].setText("LOAD");
            jButtons[10].addActionListener(new load());
            add(jButtons[10]);

            //jButtons[11]=new JButton();
            //jButtons[11].setText("");
            //jButtons[9].addActionListener();
            //add(jButtons[11]);

        }

        private class Action implements ActionListener{



            public void actionPerformed(ActionEvent e){
                JButton button=(JButton) e.getSource();
                if(button.getText().length()==0)
                    if(ccc % 2 ==0 ){
                        button.setText("O");
                        ccc++;
                    }else{
                        button.setText("X");
                        ccc++;
                    }

                    if(fullControll()==1){
                        JOptionPane.showMessageDialog(null,"All possible mark set ");
                        reset();
                    }else if(Win()==1){
                        if(!(ccc%2==0)) {
                            JOptionPane.showMessageDialog(null, "Winner is O ");
                            reset();
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"Winner is X ");
                            reset();
                        }
                    }


                    //ccc++;


            }
        }

        private int fullControll(){
            for(int i=0;i<9;i++){
                if(jButtons[i].getText().length()==0)
                    return 0;
            }
            return 1;
        }

    public void reset()
    {
        for(int i = 0; i < 9; i++)
        {
            jButtons[i].setText("");
        }
    }

    public int Win(){
            if(jButtons[0].getText().equals(jButtons[1].getText()) && jButtons[1].getText().equals(jButtons[2].getText()) && !jButtons[0].getText().equals(""))
                return 1;
            else if (jButtons[3].getText().equals(jButtons[4].getText()) && jButtons[4].getText().equals(jButtons[5].getText()) && !jButtons[3].getText().equals(""))
                return 1;
            else if (jButtons[6].getText().equals(jButtons[7].getText()) && jButtons[7].getText().equals(jButtons[8].getText()) && !jButtons[6].getText().equals(""))
                return 1;
            else if (jButtons[0].getText().equals(jButtons[3].getText()) && jButtons[3].getText().equals(jButtons[6].getText()) && !jButtons[0].getText().equals(""))
                return 1;
            else if (jButtons[1].getText().equals(jButtons[4].getText()) && jButtons[4].getText().equals(jButtons[7].getText()) && !jButtons[1].getText().equals(""))
                return 1;
            else if (jButtons[2].getText().equals(jButtons[5].getText()) && jButtons[5].getText().equals(jButtons[8].getText()) && !jButtons[2].getText().equals(""))
                return 1;
            else if (jButtons[0].getText().equals(jButtons[4].getText()) && jButtons[4].getText().equals(jButtons[8].getText()) && !jButtons[0].getText().equals(""))
                return 1;
            else if (jButtons[2].getText().equals(jButtons[4].getText()) && jButtons[4].getText().equals(jButtons[6].getText()) && !jButtons[2].getText().equals(""))
                return 1;
            else
                return 0;
    }

            private void saveXml() throws JAXBException {

                SaveLoad saveLoad=new SaveLoad();
                saveLoad.count=ccc;

                for(int i=0;i<9;i++){
                    saveLoad.b.add(new Buttondata(jButtons[i].getText()));
                }

                JAXBContext jaxbContext=JAXBContext.newInstance(SaveLoad.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                marshaller.marshal(saveLoad,new File("saved.xml"));
            }

            private void loadXml() throws JAXBException, FileNotFoundException {

                JAXBContext jaxbContext=JAXBContext.newInstance(SaveLoad.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                SaveLoad saveLoad=(SaveLoad) unmarshaller.unmarshal(new BufferedInputStream(new FileInputStream("saved.xml")));

                reset();

                ccc=saveLoad.count;

                if (ccc%2==0){
                    JOptionPane.showMessageDialog(null,"O Start");
                }else{
                    JOptionPane.showMessageDialog(null,"X Start");
                }

                for(int i=0;i<9;i++){
                    jButtons[i].setText(saveLoad.b.get(i).data);
                }
            }

            private class load implements  ActionListener{
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        loadXml();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (JAXBException e1) {
                        e1.printStackTrace();
                    }

                }
            }

            private class save implements ActionListener{


                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        saveXml();
                    } catch (JAXBException e1) {
                        e1.printStackTrace();
                    }
                }
            }
    }

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class SaveLoad{
    @XmlElement(name="button_mark")
    public ArrayList<Buttondata> b;
    @XmlAttribute(name="move_count")
    public int count;

    public SaveLoad(){b=new ArrayList<Buttondata>();}
}

class Buttondata{
    public String data;

    Buttondata(){

    }
    Buttondata(String data){this.data=data;}

}

   // public TicGame(){
     //   setL
    //}




