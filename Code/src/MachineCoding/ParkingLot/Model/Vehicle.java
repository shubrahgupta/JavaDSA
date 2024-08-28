package MachineCoding.ParkingLot.Model;

public class Vehicle {
    int id;
    VT vehicleType;

    public Vehicle(int id, VT vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VT getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VT vehicleType) {
        this.vehicleType = vehicleType;
    }
}
