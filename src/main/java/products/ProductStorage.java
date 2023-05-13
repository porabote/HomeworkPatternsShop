package products;

import java.util.HashMap;

public class ProductStorage {

    static public HashMap<Integer, Product> products = new HashMap<>();
    static String sortByAsc = "name";
    public static void add(Product product) {
        products.put(product.getId(), product);
    }

    public static HashMap<Integer, Product> getProducts() {
        return products;
    }
}
