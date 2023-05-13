package cart;

import products.Product;

public class CardProduct extends Product {

    protected int id;
    protected String name;
    protected Double price;
    protected int categoryId;
    protected int count;

    public CardProduct(int id, String name, Double price, int categoryId, int count) {
        super(id, name, price, categoryId);
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }
}
