package tests.entities;

import tests.utils.CsvReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class PostFactory {

    ArrayList<Map<String, String>> posts;

    public PostFactory(){
        try {
            posts = CsvReader.getLinesAsHashMaps(new File(System.getProperty("user.dir") + "/src/test/resources/posts.csv"), ";");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection<Object[]> getAsCollection(){
        Collection<Object[]> list = new ArrayList<>();
        for (Map<String, String> i:posts) {
            list.add( new Object[]{i});
        }
        return list;
    }

    public ArrayList<Map<String, String>> getPosts() {
        return posts;
    }


}
