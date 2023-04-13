import java.util.ArrayList;

public class Order {

    private User user;
    private String address;
    private ArrayList<Product> products;
    public Double sumTotal;

    public Order(User user, ArrayList<Product> products) {
        this.user = user;
        this.products = products;
    }

    public void setDetails(String address) {
        this.address = address;
    }

    public boolean accept() throws Exception {

        try {
            Letter letter = new LetterBuilder()
                    .setEmail(this.user.getEmail())
                    .setMsg("Вы успешно оформили заказ")
                    .create();
            Mail.send(letter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public void setTotal() {

    }

}
