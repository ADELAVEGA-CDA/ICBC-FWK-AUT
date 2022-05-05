package context;

import driversManager.BrowsersMng;
import managers.StartPagesMng;

public class TestContext {

    // SET MANAGERS
    private BrowsersMng webDrvMng;
    private StartPagesMng pageObjMng;
    private SceneContext sceneContext;

    // CONTEXT
    public TestContext() {
        webDrvMng = new BrowsersMng();
        pageObjMng = new StartPagesMng(webDrvMng.getDrv());
        sceneContext = new SceneContext();
    }

    // INSTANCE OF
    public BrowsersMng getWebDrvMng() {
        return webDrvMng;
    }

    public StartPagesMng getPageObjMng() {
        return pageObjMng;
    }

    public SceneContext getScenarioContext() {
        return sceneContext;
    }

}
