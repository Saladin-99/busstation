package sample;

public class Tripscustomer extends Trips {
    private int seatnum;

    public Tripscustomer(String destination, boolean round, boolean internal, float price, short stops,int seatnum) {
        super(destination, round, internal, price, stops);
        this.seatnum=seatnum;
    }

    public Tripscustomer() {
    }



    public void setTrip(Trips trip,int h) {
        this.setSource(trip.getSource());
        this.setVehicle(trip.getVehicletypevehicle());
        this.setDestination(trip.getDestination());
        this.setRound(trip.isRound());
        this.setInternal(trip.isInternal());
        this.setPrice(trip.getPrice());
        this.setStops(trip.getStops());
        this.setDeptdate(trip.getDeptdatetypedate());
        this.setSeatnum(h);

    }


    public int getSeatnum() {
        return seatnum;
    }

    public void setSeatnum(int seatnum) {
        this.seatnum = seatnum;

    }

    public boolean isEqualtrip(Trips trip) {

        if (this.getVehicle().equalsIgnoreCase(trip.getVehicle())) {
            if (this.getDestination().equals(trip.getDestination())) {
                if (this.getSource().equals(trip.getSource())) {
                if (this.getSource().equals(trip.getSource())) {
                    if (this.isRound() == trip.isRound()) {
                        if (this.isInternal() == trip.isInternal()) {
                            if (this.getPrice() == trip.getPrice()) {
                                if (this.getStops() == trip.getStops()) {
                                    if (this.getDeptdate().equals(trip.getDeptdate())) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
          }
        }
        return false;

    }
}
