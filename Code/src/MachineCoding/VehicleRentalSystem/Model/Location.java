package MachineCoding.VehicleRentalSystem.Model;

public class Location {
    private String city;
    private int pinCode;

    public Location(String city, int pinCode) {
        this.city = city;
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
