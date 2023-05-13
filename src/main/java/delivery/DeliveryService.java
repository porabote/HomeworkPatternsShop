package delivery;

import cart.CardProduct;
import user.User;

import java.util.HashMap;

public class DeliveryService implements IDeliveryService {

    private HashMap<Integer, CardProduct> products;
    private User user;
    private String address;

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
}
