package MachineCoding.ParkingLot.Model;

public class ParkingSpot {
    Vehicle v;
    int id;
    boolean isEmpty;
    int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ParkingSpot(int id, boolean isEmpty) {
        this.id = id;
        this.isEmpty = isEmpty;
        this.v = null;
    }

    public Vehicle getV() {
        return v;
    }

    public void setV(Vehicle v) {
        this.v = v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
