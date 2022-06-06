package context;

import base.GlobalParams;
import base.GlobalRest;
import driversManager.BrowsersMng;

public class TestContext {

    private static BrowsersMng webDrvMng;
    private static SceneContext sceneContext;
    private static GlobalParams globalParams;
    private static GlobalRest globalRest;

    public TestContext() {
        webDrvMng = new BrowsersMng();
        sceneContext = new SceneContext();
        globalParams = new GlobalParams();
        globalRest = new GlobalRest();
    }

    public static BrowsersMng getWebDrvMng() {
        return webDrvMng;
    }

    public static SceneContext getScenarioContext() {
        return sceneContext;
    }

    public static GlobalParams getGlobalParams() {
        return globalParams;
    }

    public GlobalRest getGlobalRest() {
        return globalRest;
    }

}
