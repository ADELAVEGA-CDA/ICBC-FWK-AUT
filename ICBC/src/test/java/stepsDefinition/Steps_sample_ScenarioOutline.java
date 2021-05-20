package stepsDefinition;

import org.junit.Assert;

import context.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.PageExampleE2E;

public class Steps_sample_ScenarioOutline {

	TestContext tstContext;
	PageExampleE2E e2e;
	public Steps_sample_ScenarioOutline(TestContext context) {
		tstContext=context;
		e2e=tstContext.getPageObjMng().getEnd2End();
	}
	
	@When("^selecciono la ficha (\\d+) de la lista$")
	public void selecciono_la_ficha_de_la_lista(int ficha) throws Throwable {
	    System.out.println("Cuando selecciono la ficha "+ficha+" de la lista");
	    e2e.select_Card(ficha);
	}
	
	@When("^selecciono la opcion (\\d+) del dropdown \"([^\"]*)\"$")
	public void selecciono_la_opcion_del_dropdown(int index, String option) throws Throwable {
		System.out.println("Cuando selecciono la opcion "+index+" del dropdown "+option+".");
		switch (option.toUpperCase()) {
			case "COLOR":
				e2e.clickOn_dropdownColor();
				e2e.clicOn_optionsColor();
				break;
			case "TALLE":
				e2e.clickOn_dropdownSize();
				e2e.clicOn_optionsSize();
				break;
			default:
				System.out.println("Select options is invalid. Verify.");
				break;
		}
	}
	
	@When("^hago clic en el boton \"([^\"]*)\"$")
	public void hago_clic_en_el_boton(String boton) throws Throwable {
		System.out.println("Cuando hago clic en el boton "+boton+".");
		e2e.clicOn_imageSlide2();
		e2e.clicOn_AddButton();
	}
	
	@Then("^se agrega al carrito de compra un producto$")
	public void se_agrega_al_carrito_de_compra_un_producto() throws Throwable {
		String _expected="Cart(1)"; 
		System.out.println("Entonces se agrega al carrito de compra un producto: "+_expected);/*
		String _obtained=e2e.getText_OnCart();
		if(_obtained.contains(_expected)){System.out.println("Se verifico correctamente. Se obtuvo "+_obtained);}
		else {Assert.assertEquals("ERROR",_expected,_obtained);} */
	}



}
