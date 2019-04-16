package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class reservedcontroller implements Initializable{
    public TableView<Tripscustomer> tableView;
    public TableColumn<Tripscustomer, String> dest;
    public TableColumn<Tripscustomer, String> source;
    public TableColumn<Tripscustomer, Boolean> internal;
    public TableColumn<Tripscustomer, Boolean> round;
    public TableColumn<Tripscustomer, Short> stops;
    public TableColumn<Tripscustomer, String> vehicle;
    public TableColumn<Tripscustomer, Time> date;
    public TableColumn<Tripscustomer, Float> price;
    public TableColumn<Tripscustomer, Integer> seatnum;
    public Button back;
    public Button delete;
    public Button refresh;
    private Main main=new Main();

    public void setMain(Main main) {
        this.main = main;
    }

    public void back1 (javafx.event.ActionEvent hi) throws Exception {
        Parent adminScreen = FXMLLoader.load(getClass().getResource("customerview.fxml"));
        Scene scene = new Scene(adminScreen);
        Stage window = (Stage) ((Node) hi.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void show()
    {
        dest.setCellValueFactory(new PropertyValueFactory<Tripscustomer, String>("destination"));
        source.setCellValueFactory(new PropertyValueFactory<Tripscustomer, String>("source"));
        internal.setCellValueFactory(new PropertyValueFactory<Tripscustomer, Boolean>("internal"));
        round.setCellValueFactory(new PropertyValueFactory<Tripscustomer, Boolean>("round"));
        stops.setCellValueFactory(new PropertyValueFactory<Tripscustomer, Short>("stops"));
        vehicle.setCellValueFactory(new PropertyValueFactory<Tripscustomer, String>("vehicle"));
        date.setCellValueFactory(new PropertyValueFactory<Tripscustomer, Time>("deptdate"));
        price.setCellValueFactory(new PropertyValueFactory<Tripscustomer, Float>("price"));
        seatnum.setCellValueFactory(new PropertyValueFactory<Tripscustomer, Integer>("seatnum"));
        tableView.setItems(main.processreserved());
    }


    public void delete()
    {
        int index = tableView.getSelectionModel().getSelectedIndex();
        Tripscustomer trip=new Tripscustomer();
        trip=tableView.getItems().get(index);
        Yes_No.yesno("Cancel Ticket","Are you sure you want to cancel this ticket?",main,trip);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        delete.setDisable(true);
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Trips>() {
            @Override
            public void changed(ObservableValue<? extends Trips> observableValue, Trips trips, Trips t1) {
                if(t1!=null)
                {
                    delete.setDisable(false);
                }
                if(t1==null)
                {delete.setDisable(true);}
            }




        }

        );
    }


}
