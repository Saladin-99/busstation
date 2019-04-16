package sample;

public class Customer extends Human {
    private Tripscustomer[] trips=new Tripscustomer[20];
    private int t=0;        //number of trips for each cust
    private static int i=0;             //number of customers

    public Customer(String name, String username, String phonenum, String email, String password) {
        super(name, username, phonenum, email, password);

    }

    public Customer(String name, String username, String phonenum, String email, String password, Tripscustomer[] trips, int t) {
        super(name, username, phonenum, email, password);
        this.trips = trips;
        this.t = t;
    }

    public Tripscustomer[] getTrips() {
        return trips;
    }
    public Tripscustomer getOneTrips(int k) {
        return trips[k];

    }

    public void deletetrip(int j)
    {
        System.out.println("whaat's up:"+t);
        for(int i=j;i<this.getT()-1;i++)
        {

            trips[i]=trips[i+1];
        }
        t--;
    }

    public Tripscustomer getOneTrip() {
        return trips[t];
    }
    public void addSeatnum(int seat)
    {
        this.trips[this.t].setSeatnum(seat);

    }

    public void setTrips(Tripscustomer trip) {
        this.trips[this.t] = trip;
        this.t++;

    }

    public void setT(int t) {
        this.t++;
    }

    public int getT() {
        return t;
    }

    public static int getI() {
        return i;
    }

    public static void setI() {
        i++;
    }
}
