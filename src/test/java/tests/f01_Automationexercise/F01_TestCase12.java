package tests.f01_Automationexercise;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationexercisePage;
import utilities.ConfigReader;
import utilities.Driver;


public class F01_TestCase12 {

    @Test
    public void test01(){

        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //3. Verify that home page is visible successfully
        AutomationexercisePage automationexercisePage = new AutomationexercisePage();
        Assert.assertTrue(automationexercisePage.anasayfa.isDisplayed());
        //4. Click 'Products' button
        automationexercisePage.productButonu.click();
        //5. Hover over first product and click 'Add to cart'
        automationexercisePage.firstProduct.click();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",automationexercisePage.addToCart);
        automationexercisePage.addToCart.click();
        //6. Click 'Continue Shopping' button
        automationexercisePage.continuoShopButonu.click();
        //7. Hover over second product and click 'Add to cart'
        automationexercisePage.secondProduct.click();
        automationexercisePage.addToCart2.click();
        //8. Click 'View Cart' button
        automationexercisePage.viewCardElementi.click();
        //9. Verify both products are added to Cart
        Assert.assertTrue(automationexercisePage.cartProduct1.isDisplayed());
        Assert.assertTrue(automationexercisePage.cartProduct2.isDisplayed());
        //10. Verify their prices, quantity and total price
        Assert.assertTrue(automationexercisePage.cartBasliklar.isDisplayed());
        System.out.println("Basliklar : " +automationexercisePage.cartBasliklar.getText());

        Driver.getDriver().quit();

    }
}
