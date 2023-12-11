package tests.f01_Automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UniversityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class UniversityTest {

    @Test
    public void iframeTest() {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("wduUrl"));
        //2. “Our Products” butonuna basin
        Driver.getDriver().switchTo().frame(0);
        UniversityPage universityPage = new UniversityPage();
        //universityPage.ourProductElementi.click();
        Driver.getDriver().findElement(By.xpath("//*[@href='products.html']")).click();
        //3. “Cameras product”i tiklayin
        //wduPage.cameraElementi.click();
        Driver.getDriver().findElement(By.id("camera-img")).click();
        ReusableMethods.bekle(2);
        //4. Popup mesajini yazdirin
        WebElement popup = Driver.getDriver().findElement(By.className("modal-content"));
        System.out.println(popup.getText());
        //5. “close” butonuna basin
        Driver.getDriver().findElement(By.xpath("//button[text()='Close']")).click();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().findElement(By.xpath("//*[@id='nav-title']")).click();
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test ed
        String expectedUrl = "https://webdriveruniversity.com/index.html";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
}
