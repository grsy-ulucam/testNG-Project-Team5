package pages.gursoyPages.US05;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

public class HomePageShops {

    public HomePageShops() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //test case 1
    @FindBy(linkText = "Shops")
    public WebElement shops;

    @FindBy(xpath = "//span[.='Furniture Shop']")
    public WebElement FurnitureShop;

    @FindBy(xpath = "//span[.='Clothing Shop']")
    public WebElement ClothingShop;

    @FindBy(xpath = "//span[.='Bags Shop']")
    public WebElement BagsShop;

    @FindBy(xpath = "//span[.='Makeup Shop']")
    public WebElement MakeupShop;

    @FindBy(xpath = "//span[.='Bakery Shop']")
    public WebElement BakeryShop;

    @FindBy(xpath = "//span[.='Grocery Shop']")
    public WebElement GroceryShop;

    @FindBy(xpath ="//span[.='Books Shop']")
    public WebElement BooksShop;

    @FindBy(xpath ="//a[.='Visit This Site']")
    public WebElement VisitThisSite;

    @FindBy(xpath = "Address")
    public WebElement Address;

    @FindBy(xpath = "//span[.='Phone']")
    public WebElement Phone;

    @FindBy(xpath ="(//span[@class='h-full w-full rounded-full border border-border-200'])[3]")
    public WebElement womenDress;

    @FindBy(className ="h-full w-full rounded-full border border-border-200")
    public WebElement blueChose;

    @FindBy(xpath = "(//div[@role='button'])[9]")
    public WebElement small;

    @FindBy(xpath ="//span[text()='Add To Shopping Cart']" )
    public WebElement addShop;

    @FindBy(xpath ="//span[@class='flex ltr:ml-2 rtl:mr-2']")
    public WebElement CBoxes;

    @FindBy(xpath = "(//span[text()='$35.00'])[4]")
    public WebElement firstPrice;

    @FindBy(className = "md:w-4.5 h-3.5 w-3.5 stroke-2.5 md:h-4.5")
    public WebElement artıButton;

    @FindBy(xpath = "(//span[text()='$70.00'])[4]")
    public WebElement secondPrice;

    @FindBy(xpath = "//button[text()='Check Availability']")
    public WebElement CheckAvailabilityButton;

    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement PlaceOrder;

    @FindBy(xpath ="//button[text()='Pay']")
    public WebElement PayButton;

    /*
     Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();//sayfa asagiya scroll yapildi

        JavascriptExecutor jj=((JavascriptExecutor)Driver.getDriver());
        jj.executeScript("window.scrollBy(0,1500)");

     */



    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    public void shops() {
        wait.until(ExpectedConditions.elementToBeClickable(shops)).click();
        shops.click();
        Assert.assertTrue(FurnitureShop.isDisplayed());
        Assert.assertTrue(BagsShop.isDisplayed());
        Assert.assertTrue(ClothingShop.isDisplayed());
        Assert.assertTrue(MakeupShop.isDisplayed());
        Assert.assertTrue(BakeryShop.isDisplayed());
        Assert.assertTrue(GroceryShop.isDisplayed());
        Assert.assertTrue(BooksShop.isDisplayed());
        BooksShop.click();
        Assert.assertTrue(Address.isDisplayed());
        Assert.assertTrue(Phone.isDisplayed());
        Assert.assertTrue(VisitThisSite.isDisplayed());
        Driver.closeDriver();

    }
    public  void shopsDo(){

        Actions action=new Actions(Driver.getDriver());
        wait.until(ExpectedConditions.elementToBeClickable(shops)).click();
        shops.click();
        wait.until(ExpectedConditions.elementToBeClickable(ClothingShop));
        ClothingShop.click();
        wait.until(ExpectedConditions.elementToBeClickable(womenDress));
        action.moveToElement(womenDress).click().perform();
        wait.until(ExpectedConditions.elementToBeClickable(blueChose));
        action.moveToElement(blueChose).click().perform();
        wait.until(ExpectedConditions.elementToBeClickable(blueChose));
        small.click();
        wait.until(ExpectedConditions.elementToBeClickable(addShop));
        action.moveToElement(addShop).doubleClick(addShop).perform();
        String firstProduce=firstPrice.getText();
        artıButton.click();
        String secondProduct=secondPrice.getText();
        Assert.assertNotEquals(firstPrice,secondPrice);
        CBoxes.click();
        CheckAvailabilityButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(PayButton));
        PayButton.click();
        Driver.closeDriver();

    }

}

