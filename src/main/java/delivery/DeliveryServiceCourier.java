package delivery;

import cart.CardProduct;
import components.mailer.Letter;
import components.mailer.LetterBuilder;
import components.mailer.Mail;
import user.User;

import java.util.HashMap;

public class DeliveryServiceCourier extends DeliveryService implements IDeliveryService, IDeliveryServiceCourier{

    private String address;
    private User user;
    public void setOrderAddress(String address) {
        this.address = address;
    }

    public void sendOrder() {
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
}
