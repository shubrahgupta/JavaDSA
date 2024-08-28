package MachineCoding.ParkingLot.Model;

import MachineCoding.ParkingLot.Service.ParkingSpotManager;
import MachineCoding.ParkingLot.Service.ParkingSpotManagerFactory;
import MachineCoding.ParkingLot.Service.ParkingStrategy;
import MachineCoding.ParkingLot.Service.twoWheelerParkingSpotManager;

import java.util.ArrayList;
import java.util.List;

public class EntryGate {
    ParkingSpotManager psm;

    ParkingSpotManagerFactory psmf;


    public EntryGate() {
        this.psmf = new ParkingSpotManagerFactory();
    }

    public ParkingSpot findParkingSpot(Vehicle v, ParkingStrategy parkingStrategy) {
        this.psm = psmf.findPSM(v.getVehicleType(), parkingStrategy);
        return psmf.findPSM(v.getVehicleType(), parkingStrategy).findParkingSpot();

    }
    public void bookParkingSpot(Vehicle v, ParkingStrategy parkingStrategy) {
        ParkingSpot parkingSpot = findParkingSpot(v, parkingStrategy);
        parkingSpot.setEmpty(false);

    }

    public Ticket generateTicket(Vehicle v, long entryTime, ParkingStrategy parkingStrategy) {
        ParkingSpot parkingSpot = findParkingSpot(v, parkingStrategy);
        bookParkingSpot(v, parkingStrategy);
        return new Ticket(v, parkingSpot, entryTime);
    }

}
