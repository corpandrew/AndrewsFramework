package http.requests;

import java.util.HashMap;
import java.util.Map;

public class Options {

    private static Map<String, Object> defaultParamMap = new HashMap<>();

    public static void addDefaultParam(String key, Object value) {
        defaultParamMap.put(key, value);
    }

    public static Map<String, Object> getDefaultParamMap() {
        return defaultParamMap;
    }
}
