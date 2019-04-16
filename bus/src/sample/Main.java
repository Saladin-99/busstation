package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    public Customer[] customers=new Customer[50];
    public Manager[] managers=new Manager[5];
    public Driver[] drivers=new Driver[10];
    public Trips[] trips=new Trips[50];
    public Vehicles[] vehicles=new Vehicles[50];
    public Time triptime=new Time("12","09","2019","19:00");
    public int custcounter=2;
    public Tripscustomer[] test= new Tripscustomer[20];
    public int[] resseatnum=new int[50];
    public int seatnumcount;
    public int currentc=0;
    public int currentd=0;
    public int currentm=0;
    public int currenttind=0;



    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
        Login();




        customers[0]= new Customer("Salah Abdou", "salahabdou", "01203025003", "sal@gmail.com", "sal1999");
        managers[0]= new Manager("Ahmed hamdi","ahmedhamdi","012","ahmham@gmail.com","ssp");
        drivers[0]= new Driver("عم احمد","amahmed","012","ahmam@gmail.com","yaboy");
        trips[0]= new Trips("ElGouna",false,false,(float)250.0, (short)0);
        trips[0].setDeptdate(triptime);
        vehicles[0]= new Vehicles("Big Bus",49);
        trips[0].setVehicle(vehicles[0]);
        test[0]=new Tripscustomer();
        trips[1]=new Trips("sahel",true,true,150,(short)2,1,vehicles[0],triptime,null);
        trips[1].setDeptdate(triptime);
        System.out.println(trips);
        test[0].setTrip(trips[1],5);

        customers[1]=new Customer("Abdo","abdokhalil","0120","abdo5alil!gmail.com","abdoishabby",test,1);
        Manager.setI();
        Trips.setI();
        Customer.setI();
        Driver.setI();





    }
    public void Login()
    {

        System.out.println(custcounter);
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml"));
            GridPane login = loader.load();
            Controller logincontroller= loader.getController();
            logincontroller.setMain(this);

            Scene scene= new Scene(login);
            primaryStage.setTitle("Log-In");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void validate(String username, String password, int c) {

        int i;
        switch (c) {
            case 1:
                for (i = 0; i < custcounter; i++) {
                    if (customers[i].getUsername().equals(username)) {
                        if (customers[i].getPassword().equals(password)) {
                            currentc=i;
                            System.out.println("cust found");
                            primaryStage.close();
                            customer();
                            break;
                        }
                    }
                }
                if (i == custcounter)
                    Error.error("Incorrect Login Credentials!", "Please re-enter a correct Username and Password!");
            break;

            case 2:
                for (i = 0; i < Manager.getI(); i++) {
                    if (managers[i].getUsername().equals(username)) {
                        if (managers[i].getPassword().equals(password)) {
                            System.out.println("manager found");
                            currentm=i;
                            primaryStage.close();
                            manager();
                            break;
                        }
                    }
                }
                if (i == Manager.getI())
                    Error.error("Incorrect Login Credentials!", "Please re-enter a correct Username and Password!");
                break;
            case 3:
                for (i = 0; i < Driver.getI(); i++) {
                    if (drivers[i].getUsername().equals(username)) {
                        if (drivers[i].getPassword().equals(password)) {
                            System.out.println("driver found");
                            currentd=i;
                            primaryStage.close();
                            driver();
                            break;
                        }
                    }
                }
                if (i == Driver.getI())
                    Error.error("Incorrect Login Credentials!", "Please re-enter a correct Username and Password!");
                break;
        }
    }

    public void customer()
    {

        try {




            FXMLLoader loader = new FXMLLoader(getClass().getResource("customerview.fxml"));
            Parent customerScreen = loader.load();
            customerController  controller = loader.getController();
            controller.setMain(this);
            revisetrips();


            Scene scene= new Scene(customerScreen);
            primaryStage.setTitle("Tripsy");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
    public void driver()
    {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("driverview.fxml"));
            Parent driverview1 = loader.load();
            driverController controller= loader.getController();
            controller.setMain(this);
            controller.ShowAllTrips();

            Scene scene= new Scene(driverview1);
            primaryStage.setTitle("Log-In");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void manager() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("managerview.fxml"));
            Parent managerview1 = loader.load();
            managerController controller = loader.getController();
            controller.setMain(this);
            controller.Showtrips();

            Scene scene = new Scene(managerview1);
            primaryStage.setTitle("Log-In");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public ObservableList<Tripscustomer> processreserved()
        {
            int i;

            ObservableList<Tripscustomer> tripss = FXCollections.observableArrayList();

            for(i=0;i<customers[currentc].getT();i++)
            {

                    tripss.add(customers[currentc].getTrips()[i]);
            }

            return tripss;
        }

        public void revisetrips()
        {   boolean check=false;

            for (int i=0;i<Trips.getI();i++)
            {
                for (int j = 0; j < customers[currentc].getT(); j++) {

                    if (!(customers[currentc].getOneTrips(j).isEqualtrip(trips[i]))) {
                    check=true;
                    customers[currentc].deletetrip(j);




                    }
                }
            }
            if (check==true)
            Error.error("Trip Cancelled","One or more of your trip have been cancelled, please contact us");
        }


    public void logout()
    {
        primaryStage.close();
        Login();
    }

    public void seating(Trips trip)
    {
        int i;
        for(i=Trips.getI();i>=0;i--) {
            if (trips[i].getPrice() == trip.getPrice()){
                if (trips[i].getDestination().equals(trip.getDestination())){
                    if (trips[i].getSource().equals(trip.getSource())){
                    if (trips[i].getVehicle().equals(trip.getVehicle())){
                        if (trips[i].getDeptdate().equals(trip.getDeptdate())){
                            if (trips[i].getStops() == trip.getStops()){
                                if (trips[i].isInternal() == trip.isInternal()){
                                    if (trips[i].isRound() == trip.isRound()){
                                    {   currenttind=i;
                                        break;}}}}}}}}}
        }

            collectSeats(trips[i]);


    }


    public void showReserved()

    {
        try {




            FXMLLoader loader = new FXMLLoader(getClass().getResource("Yourtrips.fxml"));
            Parent reservedScreen = loader.load();
            reservedcontroller  controller = loader.getController();
            controller.setMain(this);
            controller.show();


            Scene scene= new Scene(reservedScreen);
            primaryStage.setTitle("Review your tickets!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




    public void save()
    {

        Tripscustomer[] tripaya=new Tripscustomer[20];


        for (int i = 0; i<seatnumcount;i++) {
            tripaya[i]=new Tripscustomer();
            tripaya[i].setTrip(trips[currenttind],resseatnum[i]);
            trips[currenttind].setReserved();
            customers[currentc].setTrips(tripaya[i]);
        }
    }



    public void collectSeats(Trips trip)

    {


        int[] seats=new int[50];
        int count=0;
        for(int i=0;i<custcounter;i++)
        {
            for(int j=0;j<customers[i].getT();j++)
            {       System.out.println("are thay equal??"+customers[i].getOneTrips(j).isEqualtrip(trip));
                if(customers[i].getOneTrips(j).isEqualtrip(trip));
                {   System.out.println("hey1"+ customers[i].getOneTrips(j).getSeatnum());
                    seats[count]=customers[i].getOneTrips(j).getSeatnum();
                    System.out.println("hey2"+ seats[count]);
                    count++;
                }
            }
        }
        for(int i=0; i<count;i++)
            System.out.println("hi:"+seats[i]);
        startseatingscreen(seats, count,trip);
    }
    public void startseatingscreen(int []seats, int count, Trips trip)

    {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("seatingview.fxml"));
        try {
            Parent seatingScreen = loader.load();
            Seating  controllerseating = loader.getController();
            controllerseating.setMain(this);
            Scene scene= new Scene(seatingScreen);
            primaryStage.setTitle("Choose your seat(s)");
            primaryStage.setScene(scene);
            primaryStage.show();
            controllerseating.renderbuttons(seats,count,trip.getVehicletypevehicle().getCapacity(),trip);
        } catch (IOException e) {
            e.printStackTrace();
        }}


    public void confirmseating(int[] confirmedseats, int ind)
    {

        resseatnum=confirmedseats;
        seatnumcount=ind;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("customerview.fxml"));
        Parent customerScreen = null;
        try {
            customerScreen = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        customerController  controller = loader.getController();
        controller.setMain(this);

        controller.readyforcheckout(trips[currenttind].getPrice()*ind);
        Scene scene= new Scene(customerScreen);
        primaryStage.setTitle("Tripsy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public ObservableList<Trips> drivergettrips()
    {
        Trips[] holder= new Trips[40];
        ObservableList<Trips> objectholder=FXCollections.observableArrayList();

        for(int i=0;i<drivers[currentd].getT();i++)
        {
            holder[i]=new Trips();
            holder[i]=drivers[currentd].getTrips(i);

        }
        objectholder=getTrips(holder);
        return objectholder;
    }

    public ObservableList<Trips> getTrips(Trips[]trips)
    {
        int i;
        System.out.println("himan");
        ObservableList<Trips> tripss = FXCollections.observableArrayList();

        for(i=Trips.getI();i>=0;i--)
        {
            if(trips[i].getReserved()!=trips[i].getVehicletypevehicle().getCapacity())
            tripss.add(trips[i]);
        }

        return tripss;
    }

    public void customertripdelete(Tripscustomer trip)
    {

            for(int j=0;j<customers[currentc].getT();j++)
            {

                if(customers[currentc].getOneTrips(j)==trip)
                {

                    customers[currentc].deletetrip(j);


                }
            }
            for (int i=0;i<Trips.getI();i++)
            {
                if(trip.isEqualtrip(trips[i]))
                    trips[i].tesReserved();
            }

    }

    public void tripdelete(Trips trip)
    {
        for (int i=0;i<Trips.getI()-1;i++)
        {
            if(trip==trips[i])
                trips[i+1]=trips[i];

        }
        Trips.tesI();
    }


    public void newtrip(String destination, boolean round, boolean internal, float price, short stops, Vehicles vehicles, Time deptdate, Time rounddeptdate)
    {

            trips[Trips.getI()] = new Trips(destination, round, internal, price, stops,0, vehicles, deptdate,rounddeptdate);
            Trips.setI();
        if(round) {
            trips[Trips.getI()] = new Trips("Salah's Station", round, internal, price, stops,0, vehicles, rounddeptdate,deptdate);
            Trips.setI();

        }
        }

    /*public void tripcustomer(Trips trips, int i)
    {
        customers[i];
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}
