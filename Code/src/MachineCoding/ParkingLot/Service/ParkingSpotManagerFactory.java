package MachineCoding.ParkingLot.Service;

import MachineCoding.ParkingLot.Model.ParkingSpot;
import MachineCoding.ParkingLot.Model.VT;
import MachineCoding.ParkingLot.Model.fourWheelerParkingSpot;
import MachineCoding.ParkingLot.Model.twoWheelerParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManagerFactory {
    ParkingSpotManager twoWheelerPSM;
    ParkingSpotManager fourWheelerPSM;

    ParkingStrategy parkingStrategy;

    public ParkingSpotManagerFactory() {
        List<ParkingSpot> twoWheelerParkingSpots = new ArrayList<>();
        for(int i = 0; i < 100; i++) {

            twoWheelerParkingSpots.add(new twoWheelerParkingSpot(i+1, true));
        }

        List<ParkingSpot> fourWheelerParkingSpots = new ArrayList<>();
        for(int i = 200; i < 300; i++) {

            fourWheelerParkingSpots.add(new fourWheelerParkingSpot(i+1, true));
        }

        this.twoWheelerPSM =  new twoWheelerParkingSpotManager(twoWheelerParkingSpots);
        this.fourWheelerPSM = new twoWheelerParkingSpotManager(fourWheelerParkingSpots);
    }

    public ParkingSpotManager findPSM(VT vehicleType, ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
        if (vehicleType == VT.twoWheeler) {
            this.twoWheelerPSM.setStrategy(parkingStrategy);
            return this.twoWheelerPSM;
        }
        else {
            this.fourWheelerPSM.setStrategy(parkingStrategy);
            return this.fourWheelerPSM;
        }
    }

}
