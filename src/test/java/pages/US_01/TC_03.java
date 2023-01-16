package pages.US_01;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class TC_03 {

    /*
    1-Kullanıcı URL ye gider.
2-Kullanıcı Become a Seller (Satıcı olun) kısmına login olur
3-Kullanıcı shop a gelip active etmelidir.
4-Kullanıcı Productsa tıklar.
5-Filter By Group ta seçim yapar.
6-Kullanıcı Filter By Category gelip seçim yapar.

     */

    public TC_03() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @FindBy(xpath="//*[text()='Create Shop']")   //Shop create butonu
    private WebElement shops;
    @FindBy(xpath = "//input[@id='name']")   //Shop name butonu
    private WebElement shopName;
    @FindBy(xpath ="(//div/span)[4]")   //Shop olusturulduktan sonra dogrulama islemi icin alinan locate
    WebElement myShops;
    public  void setShops(){    //Shop  Create edilme islemleri
        shops.click();
        Faker f=new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(shopName)      //Shop name clicklenip sirasiyla gerekli bilgiler gonderilir.
                .sendKeys("Sevgi Cicekleri").sendKeys(Keys.TAB)          //Shop name
                .sendKeys("Sevdiklerinizi mutlu etmek icin bize mutlaka ugrayın ").sendKeys(Keys.TAB)  //Description
                .sendKeys(f.name().fullName()).sendKeys(Keys.TAB)   //Account Holder Name
                .sendKeys(f.internet().emailAddress()).sendKeys(Keys.TAB)   // Account Holder Email
                .sendKeys("Segi Bank").sendKeys(Keys.TAB)              //Bank Name
                .sendKeys("123654789333").sendKeys(Keys.TAB)  //Bank Account Number
                .sendKeys(f.address().country()).sendKeys(Keys.TAB)   //Country Name
                .sendKeys(f.address().cityName()).sendKeys(Keys.TAB)   //City Name
                .sendKeys(f.address().fullAddress()).sendKeys(Keys.TAB)   //State
                .sendKeys("987412336544").sendKeys(Keys.TAB)     //Postal Code(ZIB)
                .sendKeys(f.address().fullAddress()).sendKeys(Keys.TAB)     //   Street Address
                .sendKeys("Bim uzeri").sendKeys(Keys.TAB)  //Set location from map
                .sendKeys("0999000000").sendKeys(Keys.TAB)  //Contact Number
                .sendKeys(f.internet().ipV6Address()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)// Website
                .sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(myShops.isDisplayed());// Shop un Create edildigi dogrulanir

    }}

