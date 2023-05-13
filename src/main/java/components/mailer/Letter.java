package components.mailer;

public class Letter {

    private String email;
    private String msg;

    public String getEmail() {
        return this.email;
    }

    public String getMsg() {
        return this.msg;
    }

    public Letter(String email, String msg) {
        this.email = email;
        this.msg = msg;
    }

}
