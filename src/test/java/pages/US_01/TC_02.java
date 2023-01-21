package pages.US_01;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;


import java.time.Duration;

public class TC_02 {  //Kullanici satici olarak kayit yaptiktan sonra login olabilmelidir
    public TC_02() {
        PageFactory.initElements(Driver.getDriver(),this);}

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @FindBy(linkText = "Become a Seller")  //Musteri butonu
    WebElement becomeSeller;
    @FindBy(className = "ms-1")  // Login butonu
    WebElement login;
    @FindBy(id = "email")  // Email butonu
    private WebElement boxEmail;
    @FindBy(id = "password")  // Password butonu
    private WebElement boxPassword;
    @FindBy(tagName = "button")// Bilgiler girildikten sonra  kullanilacak olan login butonu
    WebElement login2;
    @FindBy(xpath ="(//div/span)[7]")// Giris isleminin yapıldigini dogrulamak icin
    WebElement myShops;

    public void loginBtn(){
        // Siteye kullanici bilgileriye giris yapilir
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

       becomeSeller.click();// musteri butonuna  click işlemi

        Driver.getDriver().switchTo().newWindow(WindowType.TAB);

        Driver.getDriver().get("https://admin-pickbazar-rest.vercel.app/register");

        wait.until(ExpectedConditions.elementToBeClickable(login)).click();  //Login butonuna click işlemi

        Actions actions = new Actions(Driver.getDriver());
        actions.click(boxEmail).doubleClick(boxEmail).       //email kutusuna click islemi
                sendKeys(Keys.BACK_SPACE+"satıcı@gmail.com").perform();   //email kutusuna email bilgileri gonderilir
        actions.click(boxPassword).doubleClick(boxPassword)    // password kutusuna click islemi
                .sendKeys(Keys.BACK_SPACE+"123456"+Keys.TAB+Keys.ENTER).perform();   // password kutusuna password bilgileri gonderilir
        wait.until(ExpectedConditions.urlToBe("https://admin-pickbazar-rest.vercel.app/login"));
        wait.until(ExpectedConditions.visibilityOf(login2)).click();    // Bilgiler girildikten soonra Login butonuna click işlemi
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
       Assert.assertTrue(myShops.isDisplayed());// Giris islemi dogrulandi


    }
}
