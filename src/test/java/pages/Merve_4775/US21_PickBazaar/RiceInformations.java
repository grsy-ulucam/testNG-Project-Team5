package pages.Merve_4775.US21_PickBazaar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

public class RiceInformations {

    public RiceInformations() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[.='Add To Shopping Cart']")
    private WebElement addToCart;

    @FindBy(xpath = "//span[.='1 Item']")
    private WebElement goToCart;



    public void riceInformation(){

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addToCart)).click();

        WebDriverWait wait1=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(goToCart)).click();
    }
}
