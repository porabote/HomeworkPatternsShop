package orders;

import components.mailer.Letter;
import components.mailer.LetterBuilder;
import components.mailer.Mail;
import products.Product;
import user.User;

import java.util.HashMap;

public class Order {

    private User user;
    private String address;
    private HashMap<Integer, Product> products;
    public Double sumTotal;

    public Order(User user, HashMap<Integer, Product> products) {
        this.user = user;
        this.products = products;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void accept() throws Exception {

        try {
            Letter letter = new LetterBuilder()
                    .setEmail(this.user.getEmail())
                    .setMsg("Вы успешно оформили заказ")
                    .create();
            Mail.send(letter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setTotal() {

    }

}
