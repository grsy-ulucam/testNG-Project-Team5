package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SellerLoginPage {

    public SellerLoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Become a Seller")
    WebElement becomeSeller;

    @FindBy(className = "ms-1")
    WebElement login;

    @FindBy(tagName = "button")
    WebElement login2;

    public void logAsSeller()  {

        becomeSeller.click();

        Driver.getDriver().switchTo().newWindow(WindowType.TAB);

        Driver.getDriver().get("https://admin-pickbazar-rest.vercel.app/register");

        login.click();

        login2.click();


    }














}
