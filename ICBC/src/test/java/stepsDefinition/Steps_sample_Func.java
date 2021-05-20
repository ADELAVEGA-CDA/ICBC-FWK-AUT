package stepsDefinition;

import org.junit.Assert;
import context.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.PageExampleHome;

public class Steps_sample_Func {

	TestContext tstContext;
	PageExampleHome home;
	public Steps_sample_Func(TestContext context) {
		tstContext=context;
		home=tstContext.getPageObjMng().getHome();
	}
	
	@Given("^accedo a la pagina principal$")
	public void accedo_a_la_pagina_principal() throws Throwable {
	    System.out.println("Dado que accedo a la pagina principal.");
	    home.toHomepage();
	}

	@When("^busco un producto por \"([^\"]*)\" como descripción$")
	public void busco_un_producto_por_como_descripción(String desc) throws Throwable {
		System.out.println("Cuando busco un producto por "+desc+" como descripción."); 
		home.clickOn_Search();
		home.type_SearchText(desc);
	}

	@When("^hago clic en el boton aceptar$")
	public void hago_clic_en_el_boton_aceptar() throws Throwable {
		System.out.println("Cuando hago clic en el boton aceptar.");
		home.enterOn_SearchText();
	}

	@Then("^veo la lista de los productos$")
	public void veo_la_lista_de_los_productos() throws Throwable {
		System.out.println("Entonces veo la lista de los productos.");
		if(home.size_listCard()>0)System.out.println("Se encontraron "+home.size_listCard()+" fichas en la busqueda");
		else Assert.assertEquals(1, home.size_listCard());
	}
	
}
