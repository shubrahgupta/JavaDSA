package MachineCoding.VehicleRentalSystem.Model;

public class Bill {
    private double amount;
    private Reservation reservation;
    private boolean isPaid;

    public Bill(double amount, Reservation reservation, boolean isPaid) {
        this.amount = amount;
        this.reservation = reservation;
        this.isPaid = isPaid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
        this.getReservation().setReservationStatus(ReservationStatus.COMPLETE);
    }
}
