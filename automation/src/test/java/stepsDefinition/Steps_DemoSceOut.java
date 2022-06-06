package stepsDefinition;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pageObjects.PageDemoBDDPage;

public class Steps_DemoSceOut {
    PageDemoBDDPage demoPage;

    public Steps_DemoSceOut() {
        demoPage = new PageDemoBDDPage();
    }

    @Given("accedo al Store del sitio de demoblaze")
    public void accedo_al_store_del_sitio_de_demoblaze() {
        demoPage.abrir_Portal();
    }

    @Given("ingreso a la categoria Phones del home page")
    public void ingreso_a_la_categoria_phones_del_home_page() {
        demoPage.clic_PhoneOptions();
    }

    @Given("selecciono el primer telefono de la lista")
    public void selecciono_el_primer_telefono_de_la_lista() {
        demoPage.select_FirstPhone();
    }

    @Given("lo agrego al carro de compra")
    public void lo_agrego_al_carro_de_compra() throws InterruptedException {
        demoPage.clic_AddToCart();
    }

    @Given("accedo al carro de compra")
    public void accedo_al_carro_de_compra() {
        demoPage.goTo_Cart();
    }

    @Given("se agrego el producto a la grilla")
    public void se_agrego_el_producto_a_la_grilla() {
        demoPage.goTo_PlaceOrder();
    }

    @Given("completo los datos requeridos de la compra")
    public void completo_los_datos_requeridos_de_la_compra() {
        demoPage.enter_Name("USER ONE");
        demoPage.enter_Country("ARG");
        demoPage.enter_City("CABA");
        demoPage.enter_CardNumber("1234678912346789");
        demoPage.enter_Month("11");
        demoPage.enter_Year("26");
        demoPage.complete_PurchaseOrder();
    }

    @Given("se confirma el proceso de compra")
    public void se_confirma_el_proceso_de_compra() {
        String sExpetedMessage = "Thank you for your purchase!";
        String sObtainedMessage = demoPage.get_ConfirmOrder();
        Assert.assertEquals(sExpetedMessage, sObtainedMessage);
    }

    @Given("selecciono realizar pedido")
    public void selecciono_realizar_pedido() {
        demoPage.goTo_PlaceOrder();
    }

    @Given("completo {string}, {string}, {string}, {string}, {string} y {string} del formulario")
    public void completo_y_del_formulario(String name, String country, String city, String card, String month, String year) {
        demoPage.enter_Name(name);
        demoPage.enter_Country(country);
        demoPage.enter_City(city);
        demoPage.enter_CardNumber(card);
        demoPage.enter_Month(month);
        demoPage.enter_Year(year);
    }

    @Given("hago clic en comprar")
    public void hago_clic_en_comprar() {
        demoPage.complete_PurchaseOrder();
    }

    @Given("obtengo la confirmacion de la compra")
    public void obtengo_la_confirmacion_de_la_compra() {
        String sExpetedMessage = "Thank you for your purchase!";
        String sObtainedMessage = demoPage.get_ConfirmOrder();
        Assert.assertEquals(sExpetedMessage, sObtainedMessage);
    }
}
