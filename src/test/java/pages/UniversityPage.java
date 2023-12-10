package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UniversityPage {

    public void WDUPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@href='products.html']")
    public WebElement ourProductElementi;

    @FindBy(id = "camera-img")
    public WebElement cameraElementi;

    @FindBy(className = "modal-content")
    public WebElement popupMesajElementi;


}
