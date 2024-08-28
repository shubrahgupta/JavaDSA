package MachineCoding.ParkingLot.Service;

import MachineCoding.ParkingLot.Model.ParkingSpot;

import java.util.List;

public class fourWheelerParkingSpotManager extends ParkingSpotManager{
    List<ParkingSpot> parkingSpots;
    ParkingStrategy strategy;
    public fourWheelerParkingSpotManager(List<ParkingSpot> parkingSpots) {
        super(parkingSpots);
    }

    public fourWheelerParkingSpotManager(ParkingStrategy ps) {
        super(ps);
    }
}
