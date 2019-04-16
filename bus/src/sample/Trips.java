package sample;

public class Trips {                    //if trip is round two trips with diff dates and inverted destination and source are entered
    private String source="";
    private String destination="";
    private boolean round;
    private boolean internal;
    private float price;
    private short stops;
    private int reserved=0;
    private Vehicles vehicle;
    private Driver driver;
    private Time deptdate;
    static private int i=0;        //number of available trips




    public Trips(String destination, boolean round, boolean internal, float price, short stops) {
        this.destination = destination;
        this.round = round;
        this.internal = internal;
        this.price = price;
        this.stops = stops;

    }

    public Trips(String destination, boolean round, boolean internal, float price, short stops, int reserved, Vehicles vehicle, Time deptdate,Time rounddeptdate) {
        if(!(destination.equalsIgnoreCase("Salah's Station")))
        {
            this.source="Salah's Station";
            this.destination = destination;
        }
        else
        {
            this.destination="Salah's Station";
            this.source=destination;
        }

        this.round = round;
        this.internal = internal;
        this.price = price;
        this.stops = stops;
        this.reserved = reserved;
        this.vehicle = vehicle;
        this.deptdate = deptdate;
    }

    public Trips() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getReserved() {
        return reserved;
    }
    public String getReservedd() {
        return reserved+"/"+vehicle.getCapacity();
    }

    public void tesReserved() {
        this.reserved--;
    }

    public void setReserved() {
        this.reserved++;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public void setDeptdate(Time deptdate) {
        this.deptdate = deptdate;

    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isRound() {
        return round;
    }

    public void setRound(boolean round) {
        this.round = round;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    public short getStops() {
        return stops;
    }

    public void setStops(short stops) {
        this.stops = stops;
    }

    public String getVehicle() {
        return vehicle.getVehicle();
    }

    public String getDeptdate() {
        return deptdate.getDeptdate();
    }
    public Time getDeptdatetypedate() {
        return deptdate;
    }

    public Vehicles getVehicletypevehicle()
    {
        return vehicle;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public String getDriver() {
        if(driver==null)
            return "No Driver";
        return driver.getName();
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    static public int getI() {
        return i;
    }

    static public void setI() {
        i++;
    }

    static public void tesI() {
        i--;
    }
}
