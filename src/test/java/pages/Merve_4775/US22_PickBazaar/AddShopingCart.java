package pages.Merve_4775.US22_PickBazaar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

public class AddShopingCart {

    public AddShopingCart() {
        PageFactory.initElements(Driver.getDriver(), this);
    }




    @FindBy(xpath = "//span[.='Checkout']")
    private WebElement seeCart;

    public void shopping(){

        Assert.assertTrue(seeCart.isDisplayed());
    }
}
