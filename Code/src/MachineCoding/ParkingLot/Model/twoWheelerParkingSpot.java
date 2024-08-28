package MachineCoding.ParkingLot.Model;

public class twoWheelerParkingSpot extends ParkingSpot{

    public twoWheelerParkingSpot(int id, boolean isEmpty) {
        super(id, isEmpty);
    }
    public int getPrice() {
        setPrice(ParkingSpotPrice.twoWheeler);
        return ParkingSpotPrice.twoWheeler;
    }


}
