package pages.Baran.US_01;

import com.github.javafaker.Faker;
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

public class Taxes {

    public Taxes(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    Faker faker=new Faker();
    Actions act=new Actions(Driver.getDriver());

    @FindBy(xpath = "//*[text()='Taxes']")
    WebElement taxes;
    @FindBy(xpath = "//td[@class]")
    WebElement firstTax;
    @FindBy(xpath = "//button[@title='Delete']")
    WebElement deleteTax;
    @FindBy(xpath = "(//*[text()='Delete'])[2]")
    WebElement deleteOk;
    @FindBy(id = "name")
    WebElement name;
    @FindBy(xpath = "//button[.='Update Tax']")
    WebElement updateTax;
    @FindBy(className = "Toastify__toast-body")
    WebElement alertMessage;
    @FindBy(xpath = "(//a[@class='text-base transition duration-200 hover:text-heading'])[2]")
    WebElement editTax;
    @FindBy(xpath = "//*[text()='Back']")
    WebElement back;


    public void editTax() {
        taxes.click();
        Assert.assertTrue(firstTax.isDisplayed());
        deleteTax.click();
        deleteOk.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        Assert.assertTrue(alertMessage.getText().equals("Successfully deleted!"));
        wait.until(ExpectedConditions.invisibilityOf(alertMessage));

        String editname = faker.pokemon().name();
        editTax.click();
        act.click(name).doubleClick(name).keyDown(Keys.BACK_SPACE).sendKeys(editname).keyUp(Keys.BACK_SPACE).build().perform();
        updateTax.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        Assert.assertTrue(alertMessage.getText().contains("Successfully updated!"));

    }
}
