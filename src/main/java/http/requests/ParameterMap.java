package http.requests;

import java.util.HashMap;

public class ParameterMap extends HashMap<String, Object>{

    public ParameterMap() {
        this.putAll(Options.getDefaultParamMap());
    }

    public ParameterMap put(String key, String value) {
        if(key != null && value != null)
            super.put(key, value);
        return this;
    }
}

