import java.util.HashMap;

public class ProductStorage {

    static public HashMap<Integer, Product> products = new HashMap<>();

    static void add(Product product) {
        products.put(product.getId(), product);
    }

    static HashMap<Integer, Product> getProducts() {
        return products;
    }
}
