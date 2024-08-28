package MachineCoding.ParkingLot.Model;

public class Ticket {
    Vehicle v;
    ParkingSpot p;
    long entryTime;

    public Ticket(Vehicle v, ParkingSpot p, long entryTime) {
        this.v = v;
        this.p = p;
        this.entryTime = entryTime;
    }

    public Vehicle getV() {
        return v;
    }

    public void setV(Vehicle v) {
        this.v = v;
    }

    public ParkingSpot getP() {
        return p;
    }

    public void setP(ParkingSpot p) {
        this.p = p;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }
}
