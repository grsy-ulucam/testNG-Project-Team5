package pages.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;


import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;

public class SellerLoginPage extends BaseTestReport {

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

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        becomeSeller.click();

        Driver.getDriver().switchTo().newWindow(WindowType.TAB);

        Driver.getDriver().get("https://admin-pickbazar-rest.vercel.app/register");

        wait.until(ExpectedConditions.elementToBeClickable(login)).click();

        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/login"));

        wait.until(ExpectedConditions.elementToBeClickable(login2)).click();

       //Assert.fail();






    }


    }














