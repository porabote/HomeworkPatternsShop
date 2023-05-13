import cart.Card;
import delivery.DeliveryServiceCourier;
import delivery.DeliveryServicePickUp;
import orders.Order;
import products.Product;
import products.ProductStorage;
import user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    //    1 (S)  https://github.com/porabote/HomeworkPatternsShop/blob/main/src/main/java/user/User.java
//  (Auth.auth(user); аутентификацией занимается отдельный компонент)
//
// 2 (O) https://github.com/porabote/HomeworkPatternsShop/blob/main/src/main/java/components/auth/Auth.java (может приходить любой пользователь реализующий соотв интерфейс)
//
// 3 (L) https://github.com/porabote/HomeworkPatternsShop/blob/main/src/main/java/delivery/DeliveryServiceCourier.java - доставка курьером является частным случаем доставки
//
// 4 (I) https://github.com/porabote/HomeworkPatternsShop/tree/main/src/main/java/delivery - разделение интерфейсов на доставку и самовывоз (без обязательного указания адреса доставки)
//
//  5 (D) вот здесь вопрос, судя по лекции,  это  же можно подвести под тоже что и описано в пункте 2 (O), по примерам указанным в видео непонятно чем принцип открытости-закрытости отличается он этого принципа


    static Scanner scan = new Scanner(System.in);
    static boolean isProductsSelected = false;
    static HashMap<Integer, Product> products;

    public static void main(String[] args) throws Exception {

        User user = User.auth();

        getProducts();

        Card card = new Card();

        chooseProducts(card);
//        Categories categories = new Categories();
//        ArrayList catsList = categories.getList();


        createOrder(user, card.getCardList());

    }

    static private void chooseProducts(Card card) {
        while (!isProductsSelected) {

            System.out.println("Enter products ID and Count for put it in card:");
            for (Map.Entry<Integer, Product> entry : products.entrySet()) {
                Product value = entry.getValue();
                System.out.println(value);
            }
            System.out.println("If you are done, for go to cart, please, enter 100");

            int productId = scan.nextInt();
            if (productId == 100) {
                isProductsSelected = true;
                continue;
            }

            int count = scan.nextInt();
            if (productId > 0 && productId <= products.size()) {
                card.put(products.get(productId), count);
            } else {
                System.out.println("products.Product with this ID aren't issets");
            }

        }
    }

    static private void createOrder(User user, HashMap<Integer, Product> products) throws Exception {

        Order order = new Order(user, products);
        order.setTotal();

        System.out.println("Please, choose delivery type: \"curier\" or \"pickup\"");
        String deliveryType = scan.next();

        // TODO Abstract factory
        if (deliveryType.equals("curier")) {

            System.out.println("For ordering, please, enter yours Address");
            String address = scan.next();

            DeliveryServiceCourier deliveryService = new DeliveryServiceCourier();
            deliveryService.setUser(user);
            deliveryService.setOrderAddress(address);
            deliveryService.sendOrder();

            order.setAddress(address);

        } else if (deliveryType.equals("pickup")) {

            DeliveryServicePickUp deliveryService = new DeliveryServicePickUp();
            deliveryService.setUser(user);

        }

        //order.accept();

    }

    private static void getProducts() {

        // TODO DB request
        ProductStorage productsStorage = new ProductStorage();
        productsStorage.add(new Product(1, "Молоко", 105.50, 1));
        productsStorage.add(new Product(2, "Масло", 200.00, 1));
        productsStorage.add(new Product(3, "Хлеб", 50.00, 1));
        productsStorage.add(new Product(4, "Вилка", 500.00, 2));
        productsStorage.add(new Product(5, "Арбуз", 60.00, 1));
        productsStorage.add(new Product(6, "Ложка", 400.00, 2));

        products = productsStorage.getProducts();

    }

}
