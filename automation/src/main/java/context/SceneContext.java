package context;

import enums.Context;

import java.util.HashMap;
import java.util.Map;

public class SceneContext {
    private Map<String, Object> sceneContext;

    public SceneContext() {
        sceneContext = new HashMap<>();
    }

    //     SET CONTEXT
    public void setContext(Context key, Object value) {
        sceneContext.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return sceneContext.get(key.toString());
    }

    public Boolean isContains(Context key) {
        return sceneContext.containsKey(key.toString());
    }
}
