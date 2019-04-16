package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class managerController implements controllershared, Initializable {
    private Main main;
    public TableView<Trips> tableView;
    public TableColumn<Trips, String> dest;
    public TableColumn<Trips, String> source;
    public TableColumn<Trips, Boolean> internal;
    public TableColumn<Trips, Boolean> round;
    public TableColumn<Trips, Short> stops;
    public TableColumn<Trips, String> vehicle;
    public TableColumn<Trips, String> driver;
    public TableColumn<Trips, Time> date;
    public TableColumn<Trips, Float> price;
    public TableColumn<Trips, String> reserved;

    public Button delete;
    public Button refresh;

    public void setMain(Main main) {
        this.main = main;
    }

    public void Showtrips()
    {
        dest.setCellValueFactory(new PropertyValueFactory<Trips, String>("destination"));
        source.setCellValueFactory(new PropertyValueFactory<Trips, String>("source"));
        internal.setCellValueFactory(new PropertyValueFactory<Trips, Boolean>("internal"));
        round.setCellValueFactory(new PropertyValueFactory<Trips, Boolean>("round"));
        stops.setCellValueFactory(new PropertyValueFactory<Trips, Short>("stops"));
        vehicle.setCellValueFactory(new PropertyValueFactory<Trips, String>("vehicle"));
        date.setCellValueFactory(new PropertyValueFactory<Trips, Time>("deptdate"));
        price.setCellValueFactory(new PropertyValueFactory<Trips, Float>("price"));
        reserved.setCellValueFactory(new PropertyValueFactory<Trips, String>("reservedd"));
        driver.setCellValueFactory(new PropertyValueFactory<Trips, String>("driver"));
        tableView.setItems(main.getTrips(main.trips));
    }
    public void deletetrip()
    {
        Trips trip = new Trips();
        int index = tableView.getSelectionModel().getSelectedIndex();
        trip=tableView.getItems().get(index);
        main.tripdelete(trip);

    }

    @Override
    public void logout() {
        main.logout();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {delete.setDisable(true);
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Trips>() {
            @Override
            public void changed(ObservableValue<? extends Trips> observableValue, Trips trips, Trips t1) {
                if (t1 != null) {
                    delete.setDisable(false);
                }
                if (t1 == null) {
                    delete.setDisable(true);
                }


            }

        } );

}}
