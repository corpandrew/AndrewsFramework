package utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class JsonUtils {

    public static <O> String toJson(O obj) {
        return new Gson().toJson(obj);
    }

    public static <T> T parse(String inputObject, Class<T> className) {
        try {
            return new Gson().fromJson(inputObject, className);
        } catch (IllegalStateException | JsonSyntaxException e) {
            System.err.println("Failed to Parse Object.");
            try {
                return className.newInstance();
            } catch (InstantiationException | IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

}
