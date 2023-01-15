package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class SellerLoginPage {

    private WebDriver localDriver;

    public SellerLoginPage(WebDriver localDriver) {
        this.localDriver = localDriver;
        PageFactory.initElements(localDriver, this);
    }

    @FindBy(linkText = "Become a Seller")
    WebElement becomeSeller;

    @FindBy(className = "ms-1")
    WebElement login;

    @FindBy(tagName = "button")
    WebElement login2;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;


    public void logAsSeller() throws InterruptedException, AWTException {
        WebDriverWait wait=new WebDriverWait(localDriver, Duration.ofSeconds(10));



        becomeSeller.click();

        localDriver.switchTo().newWindow(WindowType.TAB);

        localDriver.get("https://admin-pickbazar-rest.vercel.app/register");

        wait.until(ExpectedConditions.elementToBeClickable(login)).click();

        wait.until(ExpectedConditions.elementToBeClickable(login2)).click();
    }
}
