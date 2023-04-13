import java.util.HashMap;

public interface IDeliveryService {

    public void setProducts(HashMap<Integer, CardProduct> products);
    public void setUser(User user);
    public void setOrderAddress(String address);

}
