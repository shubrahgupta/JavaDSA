package MachineCoding.ParkingLot.Service;

import MachineCoding.ParkingLot.Model.ParkingSpot;
import MachineCoding.ParkingLot.Model.Vehicle;

import java.util.List;

public class defaultParkingStrategy implements ParkingStrategy{

    @Override
    public ParkingSpot find(List<ParkingSpot> ps) {
        for (ParkingSpot p : ps) {
            if (p.isEmpty()) {
                return p;
            }
        }
        return null;
    }
}
