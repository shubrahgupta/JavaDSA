package MachineCoding.ParkingLot.Service;

import MachineCoding.ParkingLot.Model.Ticket;

public interface PricingStrategy {
    public int cost(Ticket t, long exitTime);
}
