package MachineCoding.VehicleRentalSystem.Model;

public class Payment {
    private Bill bill;

    public Payment() {
    }

    public Payment(Bill bill) {
        this.bill = bill;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
    public void payBill(Bill bill) {
        bill.setPaid(true);

    }
    public Bill generateBill(Reservation reservation){
        return new Bill(reservation.getVehicle().getDailyCost(), reservation, false);
    }
}
