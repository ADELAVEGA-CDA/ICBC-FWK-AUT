package context;

import base.GlobalParams;
import base.GlobalRest;
import driversManager.BrowsersMng;

public class TestContext {

    // SET MANAGERS
    private static BrowsersMng webDrvMng;
    //private StartPagesMng pageObjMng;
    private static SceneContext sceneContext;
    private static GlobalParams globalParams;
    private static GlobalRest globalRest;

    // CONTEXT
    public TestContext() {
        webDrvMng = new BrowsersMng();
        //pageObjMng = new StartPagesMng(webDrvMng.getDrv());
        sceneContext = new SceneContext();
        globalParams = new GlobalParams();
        globalRest = new GlobalRest();
    }

    // INSTANCE OF
    public static BrowsersMng getWebDrvMng() {
        return webDrvMng;
    }

//    public StartPagesMng getPageObjMng() {
//        return pageObjMng;
//    }

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
