package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

import static utilities.Driver.driver;
import static utilities.Driver.getDriver;

public class DemoqaPage {

    public DemoqaPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@role='columnheader']")
    public List<WebElement> baslikElementleriListesi;

    @FindBy(xpath = "//*[@role='gridcell']")
    public List<WebElement> tumDataElementleriListesi;

    @FindBy(xpath = "//*[@class='rt-td']")
    public List<WebElement> hucrelerListesi;

    @FindBy(xpath = "//*[@role='rowgroup']")
    public List<WebElement> tabloSatirElementleriListesi;

    @FindBy(xpath = "//*[@role='rowgroup'] // *[@role='gridcell'][3]")
    public List<WebElement> ucncuKolonElementleriListesi;

    @FindBy(xpath = "//*[@role='rowgroup'][3] // *[@role='gridcell'][5]")
    public WebElement kierraMaasElementi;


    //*[@role='rowgroup'][satir] // *[@role='gridcell'][sutun]

    public void istenenHucreDatasiniYazdir(int satirNo, int sutunNo) {

        String dinamikXpath = "//*[@role='rowgroup'][" + satirNo + "] // *[@role='gridcell'][" + sutunNo + "]";

        WebElement istenenHucreDataElementi = Driver.getDriver().findElement(By.xpath(dinamikXpath));

        System.out.println("Istenilen hucre datasi : " + istenenHucreDataElementi.getText());
    }


}
