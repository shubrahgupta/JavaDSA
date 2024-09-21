package MachineCoding.VehicleRentalSystem.Services;

import MachineCoding.VehicleRentalSystem.Model.Vehicle;
import MachineCoding.VehicleRentalSystem.Model.VehicleStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleInventoryManagement {
    private List<Vehicle> vehicleList;

    public VehicleInventoryManagement(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public VehicleInventoryManagement() {
        this.vehicleList = new ArrayList<>();
    }

    public void addToList(Vehicle vehicle) {
        this.vehicleList.add(vehicle);
    }
    public void removeFromList(Vehicle vehicle) {
        this.vehicleList.remove(vehicle);
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> getVehicleListByDate(Date date) {
        List<Vehicle> availableVehicle = new ArrayList<>();
        for(Vehicle vehicle: getVehicleList()) {
            if (vehicle.getDateAvailable().equals(date) && vehicle.getStatus() == VehicleStatus.ACTIVE) {
                availableVehicle.add(vehicle);
            }
        }
//        System.out.println(availableVehicle);
        return availableVehicle;
    }
    public Vehicle getVehicleById(int vehicleId) {
        for(Vehicle vehicle: getVehicleList()) {
            if (vehicle.getVehicleId() == vehicleId) {
                return vehicle;
            }
        }
        return null;
    }
}
