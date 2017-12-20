package tests.entities;

import tests.utils.CsvReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserFactory {
    ArrayList<Map<String, String>> usersList;

    public UserFactory() {

        try {
            usersList = CsvReader.getLinesAsHashMaps(new File(System.getProperty("user.dir") + "/src/test/resources/users.csv"), "/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getUser(Integer userId){
        for (Map<String, String> i: usersList){
            if (userId == Integer.parseInt(i.get("id")))
                return new User(i);
        }
        return null;
    }
}
