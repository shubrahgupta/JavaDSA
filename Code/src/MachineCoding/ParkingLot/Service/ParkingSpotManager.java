package MachineCoding.ParkingLot.Service;

import MachineCoding.ParkingLot.Model.ParkingSpot;
import MachineCoding.ParkingLot.Model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManager {
    List<ParkingSpot> parkingSpots;
    ParkingStrategy strategy;

    public void setStrategy(ParkingStrategy strategy) {
        this.strategy = strategy;
    }

    public ParkingSpotManager(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
    public ParkingSpotManager(ParkingStrategy ps) {
        this.parkingSpots = new ArrayList<>();
        this.strategy = ps;
    }

    public void addParkingSpot(int id) {
        this.parkingSpots.add(new ParkingSpot(id, true));
    }
    public void removeParkingSpot(ParkingSpot ps) {
        this.parkingSpots.remove(ps);
    }
    public void parkVehicle(Vehicle v, ParkingSpot p) {
        p.setV(v);
        p.setEmpty(false);
    }
    public ParkingSpot findParkingSpot() {
        return this.strategy.find(parkingSpots);
    }
}
