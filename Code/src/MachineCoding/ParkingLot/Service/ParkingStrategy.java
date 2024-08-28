package MachineCoding.ParkingLot.Service;

import MachineCoding.ParkingLot.Model.ParkingSpot;
import MachineCoding.ParkingLot.Model.Vehicle;

import java.util.List;

public interface ParkingStrategy {
    public ParkingSpot find(List<ParkingSpot> ps);
}
