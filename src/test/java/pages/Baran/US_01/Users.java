package pages.Baran.US_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;

public class Users extends BaseTestReport {

    public Users() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //Users Elements
    @FindBy(xpath = "//*[text()='Users']")
    WebElement users;
    @FindBy(xpath = "//button[contains(@title,'Assign')]")
    WebElement permission;
    @FindBy(xpath = "//button[contains(@title,'wallet')]")
    WebElement walletPoints;
    @FindBy(id = "points")
    WebElement inputPoints;
    @FindBy(xpath = "//button[contains(@title,'Ban')]")
    WebElement ban;
    @FindBy(xpath = "//button[.='Yes']")
    WebElement submit;
    @FindBy(xpath = "//button[.='Block']")
    WebElement block;
    @FindBy(className = "Toastify__toast-body")
    WebElement alertMessage;
    @FindBy(xpath = "//a[.='+ Add Customer']")
    WebElement addCustomer;
    @FindBy(id = "name")
    WebElement name;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//button[.='Create Customer']")
    WebElement createCust;


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    Faker faker = new Faker();

    public void permissionTest() {

        users.click();
        permission.click();
        submit.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        Assert.assertTrue(alertMessage.getText().contains("Success"));
    }

    public void walletPointsTest() {

        Faker faker = new Faker();
        users.click();
        walletPoints.click();
        inputPoints.sendKeys(faker.number().digit() + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        Assert.assertTrue(alertMessage.getText().contains("Success"));
    }

    public void statusTest() {

        users.click();
        ban.click();
        block.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        Assert.assertTrue(alertMessage.getText().contains("Success"));
    }

    public void addCustomerTest() {
        String username = faker.lordOfTheRings().character();
        users.click();
        addCustomer.click();
        name.sendKeys(username);
        email.sendKeys(faker.gameOfThrones().character() + "@demo.com");
        password.sendKeys("" + faker.number().randomNumber());
        createCust.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        Assert.assertTrue(alertMessage.getText().equals("Register Successfully."));

    }

    //Login Elements
    //  @FindBy(linkText = "Become a Seller")
    //  WebElement becomeSeller;
    //  @FindBy(className = "ms-1")
    //  WebElement login;
    //  @FindBy(xpath = "//*[@data-variant]")
    //  WebElement login2;
    //  @FindBy(id = "email")
    //  WebElement email;
    //  @FindBy(id = "password")
    //  WebElement password;


    //   public void logAsSeller() throws InterruptedException, AWTException {
//       WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//       becomeSeller.click();

//       Driver.getDriver().switchTo().newWindow(WindowType.TAB);

//       Driver.getDriver().get("https://admin-pickbazar-rest.vercel.app/register");

//       wait.until(ExpectedConditions.elementToBeClickable(login)).click();

//       wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/login"));
//       wait.until(ExpectedConditions.elementToBeClickable(login2)).click();
//   }


}
