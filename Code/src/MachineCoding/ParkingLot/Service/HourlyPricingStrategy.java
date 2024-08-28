package MachineCoding.ParkingLot.Service;

import MachineCoding.ParkingLot.Model.Ticket;

public class HourlyPricingStrategy implements PricingStrategy{
    @Override
    public int cost(Ticket t, long exitTime) {
        return (int)Math.abs(exitTime - t.getEntryTime()) * t.getP().getPrice();
    }
}
