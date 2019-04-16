package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class customerController  implements Initializable{
    public TableView<Trips> tableView;
    public TableColumn<Trips, String> dest;
    public TableColumn<Trips, String> source;
    public TableColumn<Trips, Boolean> internal;
    public TableColumn<Trips, Boolean> round;
    public TableColumn<Trips, Short> stops;
    public TableColumn<Trips, String> vehicle;
    public TableColumn<Trips, Time> date;
    public TableColumn<Trips, Float> price;
    private Main main = new Main();
    public Button logout;
    public Button ShowAll;
    public Trips trip;

    public RadioButton allwayrb;
    public RadioButton onewayrb;
    public RadioButton roundwayrb;

    public RadioButton allternalrb;
    public RadioButton internalrb;
    public RadioButton externalrb;

    public Button seating= new Button();
    public Button checkout;
    public Button reservedtrips;

    public Label priceseats;

    public void setMain(Main main) {
        this.main = main;
    }



    public void wayrbg() //not working yet
        {
            int index = tableView.getSelectionModel().getSelectedIndex();
            Trips filteredtrips=tableView.getItems().get(index);
            System.out.println(filteredtrips.getDeptdate());
        }

        public void readyforcheckout( float price)
        {
            priceseats.setText("Price: "+String.valueOf(price));
            seating.setVisible(false);
            checkout.setVisible(true);

        }
        public void checkout()
        {
            seating.setVisible(true);
            checkout.setVisible(false);
            main.save();


        }

        public void seeReserved()
        {
            main.showReserved();

        }


    public void logout(ActionEvent hi) throws Exception
    {

        //main.logout();
        Parent adminScreen = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(adminScreen);
        Stage window = (Stage) ((Node) hi.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    public void ShowAllTrips()
    {
        dest.setCellValueFactory(new PropertyValueFactory<Trips, String>("destination"));
        source.setCellValueFactory(new PropertyValueFactory<Trips, String>("source"));
        internal.setCellValueFactory(new PropertyValueFactory<Trips, Boolean>("internal"));
        round.setCellValueFactory(new PropertyValueFactory<Trips, Boolean>("round"));
        stops.setCellValueFactory(new PropertyValueFactory<Trips, Short>("stops"));
        vehicle.setCellValueFactory(new PropertyValueFactory<Trips, String>("vehicle"));
        date.setCellValueFactory(new PropertyValueFactory<Trips, Time>("deptdate"));
        price.setCellValueFactory(new PropertyValueFactory<Trips, Float>("price"));
        tableView.setItems(main.getTrips(main.trips));

    }

    public void selectseats()
    {

        int index = tableView.getSelectionModel().getSelectedIndex();
        trip=tableView.getItems().get(index);

        main.seating(trip);
    }

    public void button()
    {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkout.setVisible(false);
        seating.setDisable(true);
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Trips>() {
            @Override
            public void changed(ObservableValue<? extends Trips> observableValue, Trips trips, Trips t1) {
                if(t1!=null)
                {
                    seating.setDisable(false);

                }
                if(t1==null)
                {seating.setDisable(true);}

            }





                }

        );
    }
}
