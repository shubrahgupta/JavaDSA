package MachineCoding.ParkingLot;

import MachineCoding.ParkingLot.Model.*;
import MachineCoding.ParkingLot.Service.*;


public class DriverClass {
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle(1, VT.twoWheeler);
        Vehicle v2 = new Vehicle(2, VT.fourWheeler);
        long entryTimeV1 = (long) 12.3;
        long entryTimeV2 = (long) 2;
        ParkingStrategy parkingStrategyV1 = new defaultParkingStrategy();
        ParkingStrategy parkingStrategyV2 = new defaultParkingStrategy();
        EntryGate entryGate = new EntryGate();
        Ticket tV1 = entryGate.generateTicket(v1, entryTimeV1, parkingStrategyV1);
        Ticket tV2 = entryGate.generateTicket(v2, entryTimeV2, parkingStrategyV2);
        System.out.println(tV1.getP().getId());
        System.out.println(tV2.getP().getId());
        long exitTimeV1 = (long) 3;
        long exitTimeV2 = (long) 9;
        ExitGate exitGate = new ExitGate(new HourlyPricingStrategy());
        System.out.println(exitGate.costCalculation(tV1, exitTimeV1));
        System.out.println(exitGate.costCalculation(tV2, exitTimeV2));



    }




}
