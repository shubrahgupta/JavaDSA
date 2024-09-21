package MachineCoding.VehicleRentalSystem.Model;

import MachineCoding.VehicleRentalSystem.Services.VehicleInventoryManagement;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int storeId;
    private Location location;
    private VehicleInventoryManagement inventoryManagement;
    private List<Reservation> reservations;

    public Store(int storeId, Location location, VehicleInventoryManagement inventoryManagement, List<Reservation> reservations) {
        this.storeId = storeId;
        this.location = location;
        this.inventoryManagement = inventoryManagement;
        this.reservations = reservations;
    }

    public Store(int storeId, Location location) {
        this.storeId = storeId;
        this.location = location;
        this.inventoryManagement = new VehicleInventoryManagement();
        this.reservations = new ArrayList<>();
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public VehicleInventoryManagement getInventoryManagement() {
        return inventoryManagement;
    }

    public void setInventoryManagement(VehicleInventoryManagement inventoryManagement) {
        this.inventoryManagement = inventoryManagement;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    public void makeReservation(Reservation reservation) {
        if (!(reservation.getVehicle().getStatus() == VehicleStatus.INACTIVE)) {
            this.reservations.add(reservation);
        }
        else {
            System.out.println("Vehicle is INACTIVE");
        }

    }
    public Reservation getReservationById(int reservationId) {
        for(Reservation reservation: getReservations()) {
            if (reservation.getReservationId() == reservationId){
                return reservation;
            }
        }
        return null;
    }
}
