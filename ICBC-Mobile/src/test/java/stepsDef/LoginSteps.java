package stepsDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("accedo al portal principal")
	public void accedo_al_portal_principal() {
		System.out.println("STEP: accedo al portal principal");
	}

	@Given("selecciono ingreso personas")
	public void selecciono_ingreso_personas() {
		System.out.println("STEP: selecciono ingreso personas");
	}

	@When("ingreso mi usuario y clave")
	public void ingreso_mi_usuario_y_clave() {
		System.out.println("STEP: ingreso mi usuario y clave");
	}

	@When("hago click en ingresar")
	public void hago_click_en_ingresar() {
		System.out.println("STEP: hago click en ingresar");
	}

	@Then("me muestra la pagina principal de usuarios")
	public void me_muestra_la_pagina_principal_de_usuarios() {
		System.out.println("STEP: me muestra la pagina principal de usuarios");
	}

	@When("ingreso mis usuario {string} y mi clave {string}")
	public void ingreso_mis_usuario_y_mi_clave(String sUser, String sPass) {
		System.out.println("STEP: ingreso mis usuario "+sUser+" y mi clave "+sPass);
	}

	@Then("verifico el mensaje {string} obtenido")
	public void verifico_el_mensaje_fail_obtenido(String sMsg) {
		System.out.println("STEP: verifico el mensaje "+sMsg+" obtenido");
	}
	
}
