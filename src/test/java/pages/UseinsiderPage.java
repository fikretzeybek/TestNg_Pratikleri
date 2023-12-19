package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UseinsiderPage {

    public void Useinsider() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@role='button'])[3]")
    public WebElement cookiesElementi;

    @FindBy(id = "wt-cli-accept-btn")
    public WebElement cookies;

    @FindBy(xpath = "//*[@id=\"wt-cli-accept-btn\"]")
    public WebElement cookiesElementii;

    @FindBy(partialLinkText = "Company")
    public WebElement companyLink;

    @FindBy(linkText = "Careers")
    public WebElement careersLink;

    @FindBy(className = "glide__slides")
    public WebElement locations;

    @FindBy(xpath = "//*[@class='col-12 d-flex flex-wrap p-0 career-load-more']")
    public WebElement teams;

    @FindBy(className = "elementor-swiper")
    public WebElement lifeAtInsider;

    @FindBy(partialLinkText = "teams")
    public WebElement seeAllTeamsLink;

    @FindBy(linkText = "Quality Assurance")
    public WebElement qualityAssuranceLink;

    @FindBy(linkText = "See all QA jobs")
    public WebElement seeAllQaJobsLink;

    //@FindBy(xpath = "(//*[@class='select2-selection__arrow'])[1]")
    //public WebElement LocationSelect;

    @FindBy(xpath = "(//*[@role='presentation'])[2]")
    public WebElement locationSelect;

    //@FindBy(xpath = "(//*[@role='presentation'])[1]")
    //public WebElement locationSelect;

    @FindBy(xpath = "//*[@class='select2-results__option']")
    public List<WebElement> filterByLocationList;

    @FindBy(xpath = "(//*[text()='Istanbul, Turkey'])[5]")
    public WebElement locationIstanbul;

    @FindBy(id = "jobs-list")
    public WebElement QajobList;

    @FindBy(xpath = "//*[@data-location='istanbul-turkey']")
    public List<WebElement> jobList;
}


