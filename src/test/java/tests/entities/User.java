package tests.entities;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Paul on 18.03.2017.
 */
public class User {
    String login;
    String password;
     String email;
    String phone;


    public User(String name, String login, String password, String email, String phone) {
        this.login = name;
        this.password = password;

        this.email = email;
        this.phone = phone;

    }



    public User(String name, String login, String password){
        this.email = login;
        this.login = name;
        this.password = password;
    }

    public User(Map<String, String> user){
        this.email = user.get("email");
        this.login = user.get("login");
        this.phone = user.get("phone");
        this.password = user.get("password");
    }

    public String getName() {
        return login;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.login = name;
    }

    public void setLogin(String login) {
        this.email = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String[] toArray(){
        ArrayList<String> list = new ArrayList<>();
        list.add(login);
        list.add(email);
        list.add(phone);
        list.add(password);

        String[] values = list.toArray(new String[list.size()]);

        return values;
    }


}
