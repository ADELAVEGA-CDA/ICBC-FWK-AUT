package stepsDefinition;

import context.TestContext;
import io.cucumber.java.en.Given;
import pageObjects.dataBase.SampleDataBasePage;

public class SampleDataBaseSteps {
    SampleDataBasePage dataBase;
    TestContext tst;

    public SampleDataBaseSteps(TestContext context) {
        tst = context;
        dataBase = new SampleDataBasePage();
    }

    @Given("^al obtener datos de la tabla estudiante$")
    public void obtengo_datos_de_la_tabla_estudiante() throws Throwable {
        dataBase.selectExampleQuery();
    }
}
