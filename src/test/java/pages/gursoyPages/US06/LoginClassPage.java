package pages.gursoyPages.US06;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;

public class LoginClassPage extends BaseTestReport {

    public LoginClassPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Join']")
    WebElement join;

    public void loginPrivate() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        join.click();

    }
}
