package tests.f01_Automationexercise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationexercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_21 {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Click on 'Products' button
    //4. Verify user is navigated to ALL PRODUCTS page successfully
    //5. Click on 'View Product' button
    //6. Verify 'Write Your Review' is visible
    //7. Enter name, email and review
    //8. Click 'Submit' button
    //9. Verify success message 'Thank you for your review.'
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //3. Click on 'Products' button
        AutomationexercisePage page = new AutomationexercisePage();
        page.productButonu.click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(page.allProductYaziElementi.isDisplayed());
        //5. Click on 'View Product' button
        page.viewProductElementi.click();
        //6. Verify 'Write Your Review' is visible
        Assert.assertTrue(page.writeYourReviewYaziElementi.isDisplayed());
        //7. Enter name, email and review
        //8. Click 'Submit' button
        Actions actions = new Actions(Driver.getDriver());
        actions.click(page.yourNameKutusu).sendKeys("ali")
                .sendKeys(Keys.TAB)
                .sendKeys("ali@ali.com")
                .sendKeys(Keys.TAB)
                .sendKeys("bugunden tezi yok calısmaya son vermek isterdim")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //9. Verify success message 'Thank you for your review.'
        Assert.assertTrue(page.thankYouYaziElementi.isDisplayed());
        System.out.println(page.thankYouYaziElementi.getText());

        Driver.closeDriver();
    }
}
