package pages.Baran.US_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

public class BecomeSeller {

    public BecomeSeller() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    Faker faker = new Faker();

    Actions act = new Actions(Driver.getDriver());
    @FindBy(linkText = "Become a Seller")
    WebElement becomeSeller;
    @FindBy(id = "name")
    WebElement name;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//button[text()='Register']")
    WebElement register;
    @FindBy(xpath = "//div[text()='Register Successfully.']")
    WebElement alertMessage;
    @FindBy(xpath = "//img[@alt='avatar']")
    WebElement profileIcon;
    @FindBy(linkText = "Logout")
    WebElement loguot;
    @FindBy(tagName = "h3")
    WebElement checkUsername;

    String username, usermail, userpass;

    public void sellerRegister() {
        becomeSeller.click();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB).get("https://admin-pickbazar-rest.vercel.app/register");
        username = faker.lordOfTheRings().character();
        usermail = faker.pokemon().name() + "@testt.com";
        userpass = "" + faker.number().randomNumber();
        name.sendKeys(username);
        email.sendKeys(usermail);
        password.sendKeys(userpass);
        register.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        Assert.assertTrue(alertMessage.getText().toLowerCase().contains("success"));
    }

    public void sellerLogoutandLogin() {
        wait.until(ExpectedConditions.invisibilityOf(alertMessage));
        profileIcon.click();
        loguot.click();

        act.click(email).doubleClick(email).keyDown(Keys.BACK_SPACE).sendKeys(usermail).keyUp(Keys.BACK_SPACE).perform();
        act.click(password).doubleClick(password).keyDown(Keys.BACK_SPACE).sendKeys(userpass + Keys.ENTER).keyUp(Keys.BACK_SPACE).perform();

        Assert.assertTrue(checkUsername.isDisplayed());
    }
}
