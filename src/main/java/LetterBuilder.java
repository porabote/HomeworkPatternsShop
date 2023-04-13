public class LetterBuilder {

    private String email;
    private String msg;

    public LetterBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public LetterBuilder setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public LetterBuilder getMsg() {
        this.email = email;
        return this;
    }

    public Letter create() throws Exception {

        try {
            if (this.email == null || this.msg == null) {
                throw new Exception("Недостаточно данных о пользователе");
            } else {
                return new Letter(this.email, this.msg);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
