package sample;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public Button logincustomer;
    public Button logindriver;
    public Button loginmanager;
    public Button clearm;
    public Button clearc;
    public Button cleard;



    public PasswordField passwordmanager;
    public PasswordField passwordcustomer;
    public PasswordField passworddriver;

    public TextField usernamemanager;
    public TextField usernamecustomer;
    public TextField usernamedriver;

    public void clear()
    {
        passwordmanager.setText("");
        passwordcustomer.setText("");
        passworddriver.setText("");
    }

    public void managerlogin()
    {
        String username = usernamemanager.getText();
        String pass= passwordmanager.getText();
        main.validate(username,pass,2);
    }

    public void driverlogin()
    {
        String username = usernamedriver.getText();
        String pass= passworddriver.getText();
        main.validate(username,pass,3);

    }


    public void customerlogin()
    {
        String username = usernamecustomer.getText();
        String pass= passwordcustomer.getText();
        main.validate(username,pass,1);
    }

}
