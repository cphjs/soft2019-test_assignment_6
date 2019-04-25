package cphb;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Container
 */
public class Container {

    private static final String CONFIG_FILE = "/container-data.json";

    private Map<Class<?>, Class<?>> container = new HashMap<>();

    public Container() {

    }

    public void load() throws Exception {
        JSONTokener parser = new JSONTokener(getClass().getResourceAsStream(CONFIG_FILE));
        JSONObject data = new JSONObject(parser);

        for (String interfaceName : data.keySet()) {
            String className = data.getString(interfaceName);
            Class<?> interf = getClassByName(interfaceName);
            container.put(interf, getClassByName(className));
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> type) {
        Class<?> implementation = container.get(type);

        try {
            return (T) instantiate(implementation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T instantiate(Class<T> type) throws InstantiationException, IllegalAccessException {
        return type.newInstance();
    }

    private Class<?> getClassByName(String name) throws ClassNotFoundException {
        Class<?> impl = Class.forName(name);
        return impl;
    }
}