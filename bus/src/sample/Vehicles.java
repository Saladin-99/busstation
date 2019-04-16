package sample;

public class Vehicles {
    private String vehicle;
    private int capacity;

    private Trips trip;
    int i=0; //number of available vehicles


    public Vehicles(String vehicle, int capacity) {
        this.vehicle = vehicle;
        this.capacity = capacity;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }



    public Trips getTrip() {
        return trip;
    }

    public void setTrip(Trips trip) {
        this.trip = trip;
    }

}
