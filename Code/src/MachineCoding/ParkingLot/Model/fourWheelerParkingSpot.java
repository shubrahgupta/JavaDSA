package MachineCoding.ParkingLot.Model;

public class fourWheelerParkingSpot extends ParkingSpot{

    public fourWheelerParkingSpot(int id, boolean isEmpty) {
        super(id, isEmpty);
    }
    public int getPrice() {

        setPrice(ParkingSpotPrice.fourWheeler);
        return ParkingSpotPrice.fourWheeler;
    }


}
