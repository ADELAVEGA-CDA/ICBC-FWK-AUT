package pageObjects;

import managers.StartPagesMng;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageExampleE2E extends StartPagesMng {

    // FIND BY HOW AND USING
    @FindBy(how = How.CSS, using = ".noo-product-inner")
    private List<WebElement> lstCard;
    @FindBy(how = How.ID, using = "pa_color")
    private WebElement cbxOptionsColor;
    @FindBy(how = How.ID, using = "pa_size")
    private WebElement cbxOptionsSize;
    @FindBy(how = How.XPATH, using = "//select[@id='pa_color']/option[2]")
    private WebElement drpOptionColor;
    @FindBy(how = How.XPATH, using = "//select[@id='pa_size']/option[2]")
    private WebElement drpOptionSize;
    @FindBy(how = How.CSS, using = "#pa_color")
    private WebElement drpColor;
    @FindBy(how = How.CSS, using = "#pa_size")
    private WebElement drpSize;
    @FindBy(how = How.CSS, using = ".single_add_to_cart_button")
    private WebElement btnAddToCart;
    @FindBy(how = How.CSS, using = ".cart-name-and-total")
    private WebElement spnCart;
    @FindBy(how = How.XPATH, using = "//div[@class='noo-woo-thumbnails']/div[2]")
    private WebElement imgSlide2;

    // USE DEFINED ELEMENT
    public void select_Card(int index) {
        lstCard.get(index).click();
    }

    public void clickOn_dropdownColor() {
        cbxOptionsColor.click();
    }

    public void clickOn_dropdownSize() {
        cbxOptionsColor.click();
    }

    public void selectByIndex_Color(int color) {
        Select drpColorIndx = new Select(drpColor);
        drpColorIndx.selectByIndex(color);
    }

    public void selectByIndex_Size(int size) {
        Select drpSizeIndx = new Select(drpSize);
        drpSizeIndx.selectByIndex(size);
    }

    public void clicOn_optionsColor() {
        drpOptionColor.click();
    }

    public void clicOn_optionsSize() {
        drpOptionSize.click();
    }

    public void clicOn_imageSlide2() {
        imgSlide2.click();
    }

    public void clicOn_AddButton() {
        btnAddToCart.click();
    }

    public String getText_OnCart() {
        return spnCart.getText();
    }

}
