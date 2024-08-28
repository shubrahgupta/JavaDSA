package MachineCoding.ParkingLot.Service;

import MachineCoding.ParkingLot.Model.ParkingSpot;

import java.util.List;

public class twoWheelerParkingSpotManager extends ParkingSpotManager {

    public twoWheelerParkingSpotManager(List<ParkingSpot> parkingSpots) {
        super(parkingSpots);
    }

    public twoWheelerParkingSpotManager(ParkingStrategy ps) {
        super(ps);
    }
}
