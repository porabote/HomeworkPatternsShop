package user;

import java.util.Scanner;

public class User implements IUser {

    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public static User auth() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Hello! For authenticate, please, enter your name");
        String name = scan.nextLine();

        System.out.println("and Email ");
        String email = scan.nextLine();

        return new User(name, email);
    }

}
