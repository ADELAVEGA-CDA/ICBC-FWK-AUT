package pageObjects;

import managers.StartPagesMng;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.WebElementUtilities;

public class PageE2EScenario extends StartPagesMng {
    // FIND BY HOW AND USING
    @FindBy(how = How.XPATH, using = "(//div[contains(@class, 'avatar')])[1]")
    private WebElement btnElements;
    @FindBy(how = How.XPATH, using = "//li/span[text()='Upload and Download']")
    private WebElement uploadSection;
    @FindBy(how = How.ID, using = "uploadFile")
    private WebElement btnUpload;
    @FindBy(how = How.ID, using = "uploadedFilePath")
    private WebElement uploadedFilePath;

    WebElementUtilities webElementUtils;

    public PageE2EScenario() {
        webElementUtils = new WebElementUtilities();
    }

    // USE DEFINED ELEMENT
    public void SeccionElementos() {
        webElementUtils.wdScrollToElement(btnElements);
        btnElements.click();
    }

    public void Apartado(String option) {
        switch (option) {
            case "Upload and Download":
                webElementUtils.wdScrollToElement(uploadSection);
                uploadSection.click();
                break;
            default:
                log.warn("Section not found");
        }
    }

    public void SubirArchivo(String dir) {
        String path = System.getProperty("user.dir") + dir;
        webElementUtils.wdUploadFile(btnUpload, path);
    }

    public String PathDeSubida() {
        return uploadedFilePath.getText();
    }
}
