package stepsDefinition;

import base.GlobalParams;
import org.junit.Assert;
import context.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.Page_sample_Scenario;

public class Steps_sample_Scenario {

	TestContext tst;
	GlobalParams param;
	Page_sample_Scenario home;
	WebDriver driver;

	public Steps_sample_Scenario(TestContext context) {
		tst=context;
		home= new Page_sample_Scenario(driver);
	}
	
	@Given("^accedo al homebanking individuo$")
	public void accedo_al_homebanking_individuo() throws Throwable {
	    //
		home.to_HomeICBC();
	}

	@When("^hago clic en el menu Personas de la pagina Personas$")
	public void hago_clic_en_el_menu_Personas_de_la_pagina_Personas() throws Throwable {
	    //
		home.clic_onPersonas();
	}

	@When("^hago clic en la solapa Productos y Servicios de la pagina Personas$")
	public void hago_clic_en_la_solapa_Productos_y_Servicios_de_la_pagina_Personas() throws Throwable {
	    //
		home.clic_onProductos();
	}

	@When("^hago clic en la opcion Paquetes de la pagina Personas$")
	public void hago_clic_en_la_opcion_Paquetes_de_la_pagina_Personas() throws Throwable {
	    //
		home.clic_onPaquete();
	}

	@Then("^accedo a los productos y servicios de la pagina Paquetes$")
	public void accedo_a_los_productos_y_servicios_de_la_pagina_Paquetes() throws Throwable {
	    //
		System.out.println(home.get_Url());
		System.out.println(home.get_Title());
	}
	
	@Then("^accedo a \"([^\"]*)\" de la pagina Paquetes$")
	public void accedo_a_de_la_pagina_Paquetes(String title) throws Throwable {
	    // 
		Assert.assertEquals(title, home.get_Title());
		Assert.assertEquals("No coincide los titulos. Verificar. ", title, home.get_Title());
	}
	
	@Given("^accedo a la pagina principal$")
	public void accedo_a_la_pagina_principal() throws Throwable {
	    System.out.println("Dado que accedo a la pagina principal.");
	}

	@When("^busco un producto por \"([^\"]*)\" como descripcion$")
	public void busco_un_producto_por_como_descripcion(String desc) throws Throwable {
		System.out.println("Cuando busco un producto por "+desc+" como descripción."); 

	}

	@When("^hago clic en el boton aceptar$")
	public void hago_clic_en_el_boton_aceptar() throws Throwable {
		System.out.println("Cuando hago clic en el boton aceptar.");

	}

	@Then("^veo la lista de los productos$")
	public void veo_la_lista_de_los_productos() throws Throwable {
		System.out.println("Entonces veo la lista de los productos.");

	}
	
}
