package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Seating implements Initializable {
    int[] seatspicked=new int[49];
    int ind=0;
    Button[] seats = new Button[49];
    public Button b1;
    public Button b2;
    public Button b3;
    public Button b4;
    public Button b5;
    public Button b6;
    public Button b7;
    public Button b8;
    public Button b9;
    public Button b10;
    public Button b11;
    public Button b12;
    public Button b13;
    public Button b14;
    public Button b15;
    public Button b16;
    public Button b17;
    public Button b18;
    public Button b19;
    public Button b20;
    public Button b21;
    public Button b22;
    public Button b23;
    public Button b24;
    public Button b25;
    public Button b26;
    public Button b27;
    public Button b28;
    public Button b29;
    public Button b30;
    public Button b31;
    public Button b32;
    public Button b33;
    public Button b34;
    public Button b35;
    public Button b36;
    public Button b37;
    public Button b38;
    public Button b39;
    public Button b40;
    public Button b41;
    public Button b42;
    public Button b43;
    public Button b44;
    public Button b45;
    public Button b46;
    public Button b47;
    public Button b48;
    public Button b49;

    public Button confirm;
    public Button cancel;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    public void renderbuttons(int []resseats,int resseatcounter, int capacity,Trips tripy)
    {
        for(int i=0;i<49-capacity;i++)
        {
            seats[i].setVisible(false);
        }

        for(int i=0;i<resseatcounter;i++)
        {   if (resseats[i]!=0)
        {System.out.println(resseats[i]);
            seats[resseats[i]-1].setDisable(true);}
        }

    }

    public void seatpicked(ActionEvent event)
    {
        Button button = (Button)event.getSource();
        seatspicked[ind]=Integer.parseInt(button.getText());
        ind++;
        button.setDisable(true);
        confirm.setVisible(true);

    }

    public void cancel()
    {
        main.customer();
    }
    public void confirm() {

        main.confirmseating(seatspicked,ind);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirm.setVisible(false);
        seats[0]=b1;
        seats[1]= b2;
        seats[2]= b3;
        seats[3]= b4;
        seats[4]= b5;
        seats[5]= b6;
        seats[6]= b7;
        seats[7]= b8;
        seats[8]= b9;
        seats[9]= b10;
        seats[10]= b11;
        seats[11]= b12;
        seats[12]= b13;
        seats[13]= b14;
        seats[14]= b15;
        seats[15]= b16;
        seats[16]= b17;
        seats[17]= b18;
        seats[18]= b19;
        seats[19]= b20;
        seats[20]= b21;
        seats[21]= b22;
        seats[22]= b23;
        seats[23]= b24;
        seats[24]= b25;
        seats[25]= b26;
        seats[26]= b27;
        seats[27]= b28;
        seats[28]= b29;
        seats[29]= b30;
        seats[30]= b31;
        seats[31]= b32;
        seats[32]= b33;
        seats[33]= b34;
        seats[34]= b35;
        seats[35]= b36;
        seats[36]= b37;
        seats[37]= b38;
        seats[38]= b39;
        seats[39]= b40;
        seats[40]= b41;
        seats[41]= b42;
        seats[42]= b43;
        seats[43]= b44;
        seats[44]= b45;
        seats[45]= b46;
        seats[46]= b47;
        seats[47]= b48;
        seats[48]= b49;

    }
}
