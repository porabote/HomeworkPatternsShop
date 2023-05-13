package delivery;

import cart.CardProduct;
import user.User;

import java.util.HashMap;

public class DeliveryService implements IDeliveryService {

    private HashMap<Integer, CardProduct> products;
    private User user;
    private String address;
    private int countKilometers;

    private int maxKilometers = 50;

    @Override
    public void setProducts(HashMap<Integer, CardProduct> products) {
        this.products = products;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderAddress(String address) {
        this.address = address;
    }

    public void setCountKilometers(int countKm) {
        if (countKm > maxKilometers) {
            System.out.println("Too far");
        } else {
            this.countKilometers = countKm;
        }
    }
}
