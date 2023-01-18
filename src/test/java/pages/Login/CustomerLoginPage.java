package pages.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTestReport;
import utilities.Driver;


import java.time.Duration;

public class CustomerLoginPage extends BaseTestReport {

    public CustomerLoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Join']")
    WebElement join;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement login;

    public void customerLogin() {

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

            join.click();

            login.click();


        }


    }
