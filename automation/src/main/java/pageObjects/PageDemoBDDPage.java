package pageObjects;

import managers.FileReaderMng;
import managers.StartPagesMng;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageDemoBDDPage extends StartPagesMng {
    @FindBy(how = How.XPATH, using = "//div[@class='list-group']/a[@id='itemc'][2]")
    private WebElement btnPhone;
    @FindBy(how = How.XPATH, using = "//div[@id='tbodyid']/div[1]/div/a")
    private WebElement btnFirstPhone;
    @FindBy(how = How.CLASS_NAME, using = "btn-success")
    private WebElement btnAddCart;
    @FindBy(how = How.ID, using = "cartur")
    private WebElement btnCart;
    @FindBy(how = How.CLASS_NAME, using = "btn-success")
    private WebElement btnPlaceOrder;
    @FindBy(how = How.ID, using = "name")
    private WebElement tbxName;
    @FindBy(how = How.ID, using = "country")
    private WebElement tbxCountry;
    @FindBy(how = How.ID, using = "city")
    private WebElement tbxCity;
    @FindBy(how = How.ID, using = "card")
    private WebElement tbxCard;
    @FindBy(how = How.ID, using = "month")
    private WebElement tbxMonth;
    @FindBy(how = How.ID, using = "year")
    private WebElement tbxYear;
    @FindBy(how = How.XPATH, using = "//button[@onclick='purchaseOrder()']")
    private WebElement btnPurchase;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'sweet-alert')]/h2")
    private WebElement tbxMessage;
    @FindBy(how = How.CLASS_NAME, using = "confirm")
    private WebElement btnOkOrder;

    public void abrir_Portal() {
        driver.get(FileReaderMng.getInstance().getConfigReader().getURLdemo());
    }

    public void clic_PhoneOptions() {
        btnPhone.click();
    }

    public void select_FirstPhone() {
        btnFirstPhone.click();
    }

    public void clic_AddToCart() throws InterruptedException {
        btnAddCart.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void goTo_Cart() {
        btnCart.click();
    }

    public void goTo_PlaceOrder() {
        btnPlaceOrder.click();
    }

    public void enter_Name(String name) {
        tbxName.sendKeys(name);
    }

    public void enter_Country(String country) {
        tbxCountry.sendKeys(country);
    }

    public void enter_City(String city) {
        tbxCity.sendKeys(city);
    }

    public void enter_CardNumber(String card) {
        tbxCard.sendKeys(card);
    }

    public void enter_Month(String month) {
        tbxMonth.sendKeys(month);
    }

    public void enter_Year(String year) {
        tbxYear.sendKeys(year);
    }

    public void complete_PurchaseOrder() {
        btnPurchase.click();
    }

    public String get_ConfirmOrder() {
        String message = tbxMessage.getText();
        return message;
    }

    public void clic_OkButton() {
        btnOkOrder.click();
    }
}
