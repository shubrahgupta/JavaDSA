package MachineCoding.VehicleRentalSystem.Model;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private Vehicle vehicle;
    private Date issuedDate;
    private Date returnDate;
    private User user;
    private ReservationStatus reservationStatus;
    private Location location;

    public Reservation(int reservationId, Vehicle vehicle, Date issuedDate, Date returnDate, User user, ReservationStatus reservationStatus, Location location) {
        this.reservationId = reservationId;
        this.vehicle = vehicle;
        this.issuedDate = issuedDate;
        this.returnDate = returnDate;
        this.user = user;
        this.reservationStatus = reservationStatus;
        this.location = location;

    }
    public Reservation(int reservationId, Vehicle vehicle, Date issuedDate, Date returnDate, User user, Location location) {
        this.reservationId = reservationId;
        this.vehicle = vehicle;
        this.issuedDate = issuedDate;
        this.returnDate = returnDate;
        this.user = user;
        this.reservationStatus = ReservationStatus.SCHEDULED;
        this.location = location;

    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", vehicle=" + vehicle +
                ", issuedDate=" + issuedDate +
                ", returnDate=" + returnDate +
                ", user=" + user +
                ", reservationStatus=" + reservationStatus +
                ", location=" + location +
                '}';
    }
}
