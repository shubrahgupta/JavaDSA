package MachineCoding.ParkingLot.Model;

import MachineCoding.ParkingLot.Service.PricingStrategy;

public class CostCalculation {
    PricingStrategy pricingStrategy;

    public CostCalculation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public int costToBePaid(long exitTime, Ticket t) {
        return this.pricingStrategy.cost(t,exitTime);
    }
}
