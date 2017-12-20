package tests.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvReader {

    static ArrayList<String> getLinesAsArrayList (File file) throws IOException {
        ArrayList list;
        try (BufferedReader br = Files.newBufferedReader(file.toPath())){
            list = (ArrayList<String>) br.lines().collect(Collectors.toList());
        }
        return list;
    }

    public static ArrayList<Map<String, String>> getLinesAsHashMaps(File file, String separator) throws IOException {
        ArrayList<Map<String, String>> maps = new ArrayList<>();
        ArrayList<String> list = getLinesAsArrayList(file);
        String[] keys = list.get(0).split(separator);
        String[] values;
        for (int i = 1; i <= list.size()-1; i++) {
            values = list.get(i).split(separator);
            Map<String, String> element = new HashMap<>();
            for (int j = 0; j < keys.length; j++) {
                 element.put(keys[j], values[j]);
            }
            maps.add(element);
        }

        return maps;
    }

}
