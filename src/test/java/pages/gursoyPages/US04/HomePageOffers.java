package pages.gursoyPages.US04;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

public class HomePageOffers  {

    public HomePageOffers() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Offers']")
    public WebElement offers;
    @FindBy(xpath ="//a[text()='Shops']")
    public WebElement shops;
    @FindBy(xpath = "//img[@alt='Logo']")
    public WebElement furniture;
    @FindBy(xpath = "//img[@alt='Brown Hardwood Double Bed']")
    public WebElement bed;
    @FindBy(xpath = "//button[.='Add To Shopping Cart']")
    public WebElement shopCard;
    @FindBy(xpath ="//span[@class='flex ltr:ml-2 rtl:mr-2']")
    public WebElement boxes;
    @FindBy(xpath = "//*[.='Checkout']")
    public WebElement checkout;
    @FindBy(xpath = "//button[.='Copy']")
    public WebElement cuponName;
    @FindBy(xpath = "//button[.='Check Availability'")
    public WebElement hesap;
    @FindBy(xpath ="//*[@role='button'")
    public WebElement KupanVar;
    @FindBy(id = "code")
    public WebElement code;
    @FindBy(xpath = "//button[.='Apply'")
    public WebElement apply;
    @FindBy(xpath = "//span[@class='text-base font-semibold text-heading']")
    public WebElement kuponsuzFatura;

    @FindBy(xpath = "//span[@class='text-base font-semibold text-heading']")
    public WebElement kuponluFatura;

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrder;

    @FindBy(xpath = "//button[.='Pay']")
    WebElement pay;



    public void couponProcess() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(shops)).click();
        offers.click();
        cuponName.click();
        shops.click();
        furniture.click();
        bed.click();
        shopCard.click();
        boxes.click();
        checkout.click();
        hesap.click();
        KupanVar.click();
        code.click();
        code.sendKeys("EID2");
        String firstPrice=kuponsuzFatura.getText();
        apply.click();
        String secondPrice=kuponluFatura.getText();
        Assert.assertFalse(firstPrice.equals(secondPrice));
        placeOrder.click();
        pay.click();

    }
}


