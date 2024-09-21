package MachineCoding.VehicleRentalSystem.Services;

import MachineCoding.VehicleRentalSystem.Model.Store;
import MachineCoding.VehicleRentalSystem.Model.User;
import MachineCoding.VehicleRentalSystem.Model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VehicleRentalSystem {
    private List<User> users;
    private List<Store> stores;


    public VehicleRentalSystem() {
        this.users = new ArrayList<>();
        this.stores = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void addUser(User user) {
        this.users.add(user);
    }
    public void removeUser(User user) {
        this.users.remove(user);
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
    public void addStore(Store store) {
        this.stores.add(store);
    }

    public void removeStore(Store store) {
        this.stores.remove(store);
    }
    public Store searchByCity(String city) {
        for(Store store: getStores()) {
            if (Objects.equals(store.getLocation().getCity(), city)) {
                return store;
            }
        }
        return null;
    }

}
