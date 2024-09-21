package MachineCoding.VehicleRentalSystem.Model;
import java.util.*;
public class Vehicle {
    private int vehicleId;
    private VehicleType vehicleType;
    private int distanceDriven;
    private String vehicleName;
    private int hourlyCost;
    private int dailyCost;
    private Date dateAvailable;
    private VehicleStatus status;

    public Vehicle(int vehicleId, VehicleType vehicleType, int distanceDriven, String vehicleName, int hourlyCost, int dailyCost, Date dateAvailable, VehicleStatus status) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.distanceDriven = distanceDriven;
        this.vehicleName = vehicleName;
        this.hourlyCost = hourlyCost;
        this.dailyCost = dailyCost;
        this.dateAvailable = dateAvailable;
        this.status = status;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getDistanceDriven() {
        return distanceDriven;
    }

    public void setDistanceDriven(int distanceDriven) {
        this.distanceDriven = distanceDriven;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getHourlyCost() {
        return hourlyCost;
    }

    public void setHourlyCost(int hourlyCost) {
        this.hourlyCost = hourlyCost;
    }

    public int getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(int dailyCost) {
        this.dailyCost = dailyCost;
    }

    public Date getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(Date dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleType=" + vehicleType +
                ", distanceDriven=" + distanceDriven +
                ", vehicleName='" + vehicleName + '\'' +
                ", hourlyCost=" + hourlyCost +
                ", dailyCost=" + dailyCost +
                ", dateAvailable=" + dateAvailable +
                ", status=" + status +
                '}';
    }
}
