package sample;

public class Driver extends Human {
    private static int i=0;             //number of drivers
    private int t=0;       //number of trips
    private Trips []trips=new Trips[40];

    public Driver(String name, String username, String phonenum, String email, String password) {
        super(name, username, phonenum, email, password);

    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t++;
    }

    public Trips getTrips(int i) {
        return trips[i];
    }

    public void setTrips(Trips[] trips) {
        this.trips = trips;
    }

    public static int getI() {
        return i;
    }

    public static void setI() {
        i++;
    }
}
