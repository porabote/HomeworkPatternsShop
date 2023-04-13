public class Product {

    protected int id;
    protected String name;
    protected Double price;
    protected int categoryId;

    public Product(int id, String name, Double price, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("ID: " + this.id + "; ");
        out.append("Name: " + this.name + "; ");
        out.append("Price: " + this.price + "; ");

        return out.toString();
    }

}
