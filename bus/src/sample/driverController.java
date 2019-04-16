package sample;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;

public class driverController implements controllershared{
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    public TableView<Trips> tableView;
    public TableColumn<Trips, String> dest;
    public TableColumn<Trips, String> source;


    public TableColumn<Trips, Short> stops;
    public TableColumn<Trips, String> vehicle;
    public TableColumn<Trips, Time> date;

    public void ShowAllTrips()
    {
        dest.setCellValueFactory(new PropertyValueFactory<Trips, String>("destination"));
        source.setCellValueFactory(new PropertyValueFactory<Trips, String>("source"));
        stops.setCellValueFactory(new PropertyValueFactory<Trips, Short>("stops"));
        vehicle.setCellValueFactory(new PropertyValueFactory<Trips, String>("vehicle"));
        date.setCellValueFactory(new PropertyValueFactory<Trips, Time>("deptdate"));
        tableView.setItems(main.drivergettrips());

    }




    @Override
    public void logout() {
        main.logout();
    }
}
