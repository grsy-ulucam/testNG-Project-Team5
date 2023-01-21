package pages.gursoyPages.US06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;

public class HomePageJoin extends BaseTestReport {

    public HomePageJoin() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath ="//input[@id='email']")
    WebElement email;

    @FindBy(xpath ="//input[@id='password']")
    WebElement password;


    @FindBy(xpath ="//button[text()='pages.Login']")
    WebElement login;

    @FindBy(xpath ="//button[text()='pages.Login with Google']")
    WebElement loginGoogle;

    @FindBy(xpath ="(//button[.='pages.Login with Mobile number']")
    WebElement loginMobileNumber;

    @FindBy(xpath = "(//button[@data-variant='normal'])[5]")
    WebElement register;

    @FindBy(xpath ="//p[@class='mt-2 text-xs text-red-500']")
    WebElement errorMessage1;

    @FindBy(xpath ="//p[@class='text-sm']")
    WebElement errorMessage2;


    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
     public void validEmail (){

         wait.until(ExpectedConditions.elementToBeClickable(email)).click();

      Actions action=new Actions(Driver.getDriver());
      action.click(email).doubleClick(email)
              .sendKeys(Keys.BACK_SPACE+"customer@demo.com").perform();
      action.click(password).doubleClick(password).sendKeys(Keys.BACK_SPACE+"demodemo"+Keys.TAB+Keys.ENTER).perform();


       }
    public void unValidEmail1 (){

        wait.until(ExpectedConditions.elementToBeClickable(email)).click();
        Actions action=new Actions(Driver.getDriver());
        action.click(email).doubleClick(email)
                .sendKeys(Keys.BACK_SPACE+"customerdemo.com").perform();
        action.click(password).doubleClick(password).sendKeys(Keys.BACK_SPACE+"demodemo"+Keys.TAB+Keys.ENTER).perform();

        String errorMesaj=errorMessage1.getText();
        Assert.assertEquals(errorMesaj,"The provided email address format is not valid");
    }
    public void unValidEmail2 (){

        wait.until(ExpectedConditions.elementToBeClickable(email)).click();

        Actions action=new Actions(Driver.getDriver());
        action.click(email).doubleClick(email)
                .sendKeys(Keys.BACK_SPACE+"customer@demo.com").perform();
        action.click(password).doubleClick(password).sendKeys(Keys.BACK_SPACE+"demo"+Keys.TAB+Keys.ENTER).perform();
        String errorMesaj= errorMessage2.getText();
        Assert.assertEquals(errorMesaj,"The credentials was wrong!");

    }
    public void unValidEmail3 (){

        wait.until(ExpectedConditions.elementToBeClickable(email)).click();
        Actions action=new Actions(Driver.getDriver());
        action.click(email).doubleClick(email)
                .sendKeys(Keys.BACK_SPACE+"customeğç@demo.com").perform();
        action.click(password).doubleClick(password).sendKeys(Keys.BACK_SPACE+"demo"+Keys.TAB+Keys.ENTER).perform();

        String errorMesaj= errorMessage2.getText();
        Assert.assertEquals(errorMesaj,"The credentials was wrong!");

    }
    public  void  isDisplayed (){

        Assert.assertTrue(login.isDisplayed());
        Assert.assertTrue(loginGoogle.isDisplayed());
       // Assert.assertTrue(loginMobileNumber.isDisplayed());
        Assert.assertTrue(register.isDisplayed());

    }



}







