package delivery;

import cart.CardProduct;
import user.User;

import java.util.HashMap;

public interface IDeliveryService {
    public void setProducts(HashMap<Integer, CardProduct> products);
    public void setUser(User user);
}
