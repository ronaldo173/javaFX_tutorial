package sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Santer on 20.02.2016.
 */
public class LoadDataFromPropToView {

    public Map<String, String> getDataFromProp(String path) throws IOException {
        LinkedHashMap map = new LinkedHashMap<>();

        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(path);
        properties.load(inputStream);
        inputStream.close();


        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }

        return map;
    }

    public static void main(String[] args) throws IOException {
        Map<String, String> dataFromProp = new LoadDataFromPropToView().
                getDataFromProp("myProp.properties");

        List<String> list = new ArrayList<>(dataFromProp.keySet());
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i) + " " + dataFromProp.get(list.get(i)));
        }
    }
}
