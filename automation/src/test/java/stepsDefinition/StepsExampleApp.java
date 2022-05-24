package stepsDefinition;

import base.GlobalParams;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.mobile.PageExampleApp;

import java.util.List;

public class StepsExampleApp {
    protected Logger logger = LogManager.getLogger(String.valueOf(this.getClass()));

    GlobalParams param;
    PageExampleApp exampleApp;

    public StepsExampleApp() {
        this.exampleApp = new PageExampleApp();
    }

    @Given("the example app has been launched")
    public void theExampleAppHasBeenLaunched() {
        exampleApp.appFullyLaunched();
    }

    @Then("the user sees {string} in the PageSource")
    public void theUserSeesInThePageSource(String expectedPageSource) {
        exampleApp.validatePageSource(expectedPageSource);
    }

    @Then("the user sees")
    public void theUserSees(List<String> existsInPageSource) {
        exampleApp.validateMultipleInPageSource(existsInPageSource);
    }

    @Then("the user sees the current activity is {string}")
    public void theUserSeesTheCurrentActivityIs(String currentActivity) {
        exampleApp.validateCurrentActivity(currentActivity);
    }

    @Then("the user sees the current context is {string}")
    public void theUserSeesTheCurrentContextIs(String currentContext) {
        exampleApp.validateCurrentContext(currentContext);
    }
}
