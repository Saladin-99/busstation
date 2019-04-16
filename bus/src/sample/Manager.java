package sample;

public class Manager extends Human {
    private static int i=0;             //number of managers

    public Manager(String name, String username, String phonenum, String email, String password) {
        super(name, username, phonenum, email, password);
    }

    public static int getI() {
        return i;
    }

    public static void setI() {
        i++;
    }
}
