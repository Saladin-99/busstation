package sample;

public class Human {
    private String name="";
    private String username;
    private String phonenum;
    private String email;
    private String password;

    public Human(String name, String username, String phonenum, String email, String password) {
        this.name = name;
        this.username = username;
        this.phonenum = phonenum;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean verify(String username)
    {
        if (username==getUsername())
            return true;
        else
            return false;
    }
}
