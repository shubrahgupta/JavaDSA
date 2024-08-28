package MachineCoding.ParkingLot.Model;

import MachineCoding.ParkingLot.Service.PricingStrategy;

public class ExitGate {

    PricingStrategy pricingStrategy;
    CostCalculation costObject;

    public void updateParkingSpot(Ticket t) {
        t.getP().setEmpty(true);
    }

    public ExitGate(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
        this.costObject = new CostCalculation(pricingStrategy);
    }

    public int costCalculation(Ticket t, long exitTime) {
        updateParkingSpot(t);
        return this.costObject.costToBePaid(exitTime, t);
    }



}
