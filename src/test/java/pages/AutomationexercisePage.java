package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationexercisePage {

    public AutomationexercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='col-sm-4']")
    public WebElement anasayfa;

    @FindBy(xpath = "//*[@href='/products']")
    public WebElement productButonu;

    @FindBy(xpath = "//*[text()='All Products']")
    public WebElement allProductYaziElementi;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement viewProductElementi;

    @FindBy(xpath = "//a[@href='#reviews']")
    public WebElement writeYourReviewYaziElementi;

    @FindBy(id = "name")
    public WebElement yourNameKutusu;

    @FindBy(xpath = "//*[text()='Thank you for your review.']")
    public WebElement thankYouYaziElementi;








    @FindBy(xpath = "//*[@src='/get_product_picture/1']")
    public WebElement firstProduct;

    @FindBy(xpath = "//*[@data-product-id='1']")
    public WebElement addToCart;


    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    public WebElement continuoShopButonu;

    @FindBy(xpath = "//*[@src='/get_product_picture/2']")
    public WebElement secondProduct;

    @FindBy(xpath = "//*[@data-product-id='2']")
    public WebElement addToCart2;


    @FindBy(xpath = "//*[text()='View Cart']")
    public WebElement viewCardElementi;


    @FindBy(xpath = "(//*[@class='product_image'])[1]")
    public WebElement cartProduct1;

    @FindBy(xpath = "(//*[@class='product_image'])[2]")
    public WebElement cartProduct2;


    @FindBy(className = "cart_menu")
    public WebElement cartBasliklar;





}
