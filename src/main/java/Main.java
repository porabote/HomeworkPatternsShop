import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        Categories categories = new Categories();
        ArrayList catsList = categories.getList();

        User user = new User("Родион Раскольников", "crimeandpunishment@ya.ru");

        Card card = new Card();

        Product milk = new Product("Молоко", 105.50);
        Product butter = new Product("Масло", 200.00);
        Product bread = new Product("Топор", 2500.00);

        card.put(milk);
        card.put(butter);
        card.put(bread);

        createOrder(user, card.getCardList());

    }

    static private void createOrder(User user, ArrayList<Product> products) throws Exception {

        Order order = new Order(user, products);
        order.setTotal();

        order.setDetails("г. Санкт-Петербург ул. Достоевского, 39");
        order.accept();

    }

}
