package tests.OrdanBurdan;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UseinsiderPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class UseinsiderTesti {
    @Test
    public void test01(){
        UseinsiderPage usePage=new UseinsiderPage();
        //1. Visit https://useinsider.com/ and check Insider home page is opened or not
        Driver.getDriver().get(ConfigReader.getProperty("useinUrl"));
        String expectedUrl=ConfigReader.getProperty("useinUrl");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl,"homepage is not opened");
        usePage.cookiesElementii.click();
        ReusableMethods.bekle(2);
        //2. Select “Company” menu in navigation bar, select “Careers” and check Career page, its
        usePage.companyLink.click();
        usePage.careersLink.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("careers"),"The career page is not opened");
        //Locations, Teams and Life at Insider blocks are opened or not
        Assert.assertTrue(usePage.locations.isDisplayed());
        Assert.assertTrue(usePage.teams.isDisplayed());
        Assert.assertTrue(usePage.lifeAtInsider.isDisplayed());
        //3. Click “See All Teams”, select Quality Assurance, click “See all QA jobs”, filter jobs by
        //Location - Istanbul, Turkey and department - Quality Assurance, check presence of jobs list
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()", usePage.seeAllTeamsLink);
        js.executeScript("arguments[0].click()", usePage.qualityAssuranceLink);
        js.executeScript("arguments[0].click()", usePage.seeAllQaJobsLink);
        ReusableMethods.bekle(3);
        usePage.locationSelect.click();
        usePage.locationIstanbul.click();
        //2. Select “Company” menu in navigation bar, select “Careers” and check Career page, its
        //Locations, Teams and Life at Insider blocks are opened or not
        //3. Click “See All Teams”, select Quality Assurance, click “See all QA jobs”, filter jobs by
        //Location - Istanbul, Turkey and department - Quality Assurance, check presence of
        //jobs list
        //4. Check that all jobs’ Position contains “Quality Assurance”, Department contains
        //“Quality Assurance”, Location contains “Istanbul, Turkey” and “Apply Now” button
        //5. Click “Apply Now” button and check that this action redirects us to Lever Application

        Driver.closeDriver();

    }
}
