package components.mailer;

public class Mail {

    public static boolean send(Letter letter) {
        System.out.println("Letter to: " + letter.getEmail() + " Message:" + letter.getMsg());
        return true;
    }
}
