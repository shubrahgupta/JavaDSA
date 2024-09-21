package MachineCoding.VehicleRentalSystem;

import MachineCoding.VehicleRentalSystem.Model.*;
import MachineCoding.VehicleRentalSystem.Services.VehicleRentalSystem;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        DriverClass driverClass = new DriverClass();
        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem();
        driverClass.addCars(vehicleRentalSystem);

        User user1 = new User(1, "ho lee sheet");
        Location location1 = new Location("Begusarai", 851101);
        Date date = new Date(2023, Calendar.NOVEMBER, 10);
        Store queriedStore = vehicleRentalSystem.searchByCity(location1.getCity());
        List<Vehicle> availableList;
        if (queriedStore != null) {
            List<Vehicle> list = queriedStore.getInventoryManagement().getVehicleList();
            for(Vehicle vehicle: list) {
                System.out.println(vehicle.toString());
            }
            System.out.println();

            System.out.println("Available vehicles: ");
            availableList = queriedStore.getInventoryManagement().getVehicleListByDate(date);
            for(Vehicle vehicle: availableList) {
                System.out.println(vehicle.toString());
            }
        }


        System.out.println();
        vehicleRentalSystem.addUser(user1);
        Scanner scanner = new Scanner(System.in);
        int vehicleId = Integer.parseInt(scanner.nextLine());
        if (queriedStore != null) {
            Vehicle vehicle = queriedStore.getInventoryManagement().getVehicleById(vehicleId);
            if (vehicle != null) {
                if (vehicle.getStatus() == VehicleStatus.ACTIVE) {
                    int reservationId = 1;
                    queriedStore.makeReservation(new Reservation(reservationId,vehicle, date, date, user1, location1));
                    Reservation reservation1 = queriedStore.getReservationById(reservationId);
                    System.out.println("Reservation made: " + reservation1.toString());
                    Payment payment1 = new Payment();
                    Bill bill1 = payment1.generateBill(reservation1);
                    System.out.println("Amount to be paid: " + bill1.getAmount());
                    payment1.payBill(bill1);
                }

            }

        }


    }

    public void addCars(VehicleRentalSystem vehicleRentalSystem) {
        Vehicle car1 = new Vehicle(1, VehicleType.CAR, 100, "mazda",50, 4000, new Date(2023, Calendar.NOVEMBER, 10), VehicleStatus.ACTIVE);
        Vehicle car2 = new Vehicle(2, VehicleType.CAR, 1000, "alto",20, 3000, new Date(2023, Calendar.NOVEMBER, 11), VehicleStatus.ACTIVE);
        Vehicle car3 = new Vehicle(3, VehicleType.CAR, 10, "suzuki",70, 6000, new Date(2023, Calendar.NOVEMBER, 10), VehicleStatus.INACTIVE);



        Store store1 = new Store(1, new Location("Begusarai", 851101));
        Store store2 = new Store(2, new Location("Bengaluru", 401621));

        store1.getInventoryManagement().addToList(car1);
        store1.getInventoryManagement().addToList(car2);

        store2.getInventoryManagement().addToList(car1);
        store2.getInventoryManagement().addToList(car2);
        store2.getInventoryManagement().addToList(car3);
        vehicleRentalSystem.addStore(store1);
        vehicleRentalSystem.addStore(store2);

    }


}
