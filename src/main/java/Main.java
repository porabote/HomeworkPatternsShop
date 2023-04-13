import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static boolean isProductsSelected = false;
    public static void main(String[] args) throws Exception {

        User user = auth();
        HashMap<Integer, Product> products = getProducts();
        Card card = new Card();

//        Categories categories = new Categories();
//        ArrayList catsList = categories.getList();

        while(!isProductsSelected) {

            System.out.println("Enter products ID and Count for put it in card:");
            for(Map.Entry<Integer, Product> entry : products.entrySet()) {
                Product value = entry.getValue();
                System.out.println(value);
            }
            System.out.println("If you are done, please, enter 100");

            int productId = scan.nextInt();
            if(productId == 100) {
                isProductsSelected = true;
                continue;
            }

            int count = scan.nextInt();
            if (productId > 0 && productId <= products.size()) {
                card.put(products.get(productId), count);
            } else {
                System.out.println("Product with this ID aren't issets");
            }

        }

        createOrder(user, card.getCardList());

    }

    static private void createOrder(User user, HashMap<Integer, Product> products) throws Exception {

        Order order = new Order(user, products);
        order.setTotal();

        order.setDetails("г. Санкт-Петербург ул. Достоевского, 39");
        order.accept();

    }

    private static User auth() {

        System.out.println("Hello! For authenticate, please, enter your name");
        String name = scan.nextLine();

        System.out.println("and Email ");
        String email = scan.nextLine();

        return new User(name, email);
    }

    private static HashMap<Integer, Product> getProducts() {

        ProductStorage products = new ProductStorage();
        products.add(new Product(1, "Молоко", 105.50, 1));
        products.add(new Product(2, "Масло", 200.00, 1));
        products.add(new Product(3, "Хлеб", 50.00, 1));
        products.add(new Product(4, "Вилка", 500.00, 2));

        return products.getProducts();
    }

}
