package pages.Sumeyra.US002_Concats;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
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
import java.util.List;

public class ConcatsPage {
    public ConcatsPage() {
        PageFactory.initElements(Driver.getDriver(),this);}
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    //  1--Contact in locate alindi
    @FindBy(linkText = "Contact")
    private WebElement contactsubmit;

    //facebooksekmesinin locate alindi
    @FindBy(className= "text-muted")
    private WebElement facebook;

    //descriptionin locate alindi
    @FindBy(id = "description")
    private WebElement  description;

    //Hatali email girildiginde olusan hata messajinin lacate alindi
    @FindBy(className= "mt-2")
    private WebElement mailAssert;

    //subject kutusu bos birakildiginda gorulen mesajin lacate alindi
    @FindBy(className = "my-6")
    private  WebElement subjectAssert;

     //description tiklandiginda mesaj gorunuyor mu
    @FindBy (xpath = "//*[text()='Email successfully sent']")
    private  WebElement message;

      // daha sonra tiklayip  ustteki mesaji gorebilmek icin submit butonun locate alinir
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;

    //name locate alinir
    @FindBy(id="name")
    private WebElement name;


    public void contactPage() {    // 1-Kullanıcı Concat a gider. Contact sayfasi acilir
        wait.until(ExpectedConditions.elementToBeClickable(contactsubmit)).click();}


    public void contactPageIletisimBilgileri() {   //  Iletisim  bilgilerini görür.  PASSED

        //Iletişim  bilgileri  Tagname ile kismi listeye alindi
        List<WebElement> isyeriBilgileri = Driver.getDriver().findElements(By.tagName("span"));

        //  2--Adress bilgilerini görür.
        WebElement adres = isyeriBilgileri.get(8);
        Assert.assertTrue(adres.isDisplayed(), "Adres bilgileri gorunmuyor");

        //  3--Kullanıcı phone bilgilerini  görür.
        WebElement phone = isyeriBilgileri.get(10);
        Assert.assertTrue(phone.isDisplayed(), "Telefon bilgileri gorunmuyor");

        //  4--Kullanıcı Websitesi bilgilerini  görür.
        WebElement website = isyeriBilgileri.get(12);
        Assert.assertTrue(website.isDisplayed(), "Websitesi bilgileri gorunmuyor");

        //  5--Kullanıcı sosyal medya hesaplarına erişebilir.
        facebook.click();
        //Facebook gidildigi kontrol edildi
        Assert.assertTrue(facebook.isDisplayed());}


        //  6-Kullanıcı  "Qestions, Comments, Or Concerns?" ** bölümünü aktif kullanabilir.
    public void concatsBoxContol() {                                                                                  // PASSED

        Faker f = new Faker();    // Otomatik doldurulmasi icin faker methodu kullanildi

        Actions actions = new Actions(Driver.getDriver());
        actions.click(name)
                .sendKeys(f.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(f.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys("boyle devam").sendKeys(Keys.TAB)
                .sendKeys(f.internet().emailAddress(), f.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();}

    //  7--Kullanıcı geçersiz email girdiğinde uyarıyı görebilir.  **
        public void hataliEmail() {            //hatali email girisi yapildiginda hata mesaji goruldu   PASSED

            Faker f = new Faker();    // Otomatik doldurulmasi icin faker methodu kullanildi
            Actions actions = new Actions(Driver.getDriver());
            actions.click(name)
                    .sendKeys(f.name().firstName()).sendKeys(Keys.TAB)
                    .sendKeys("addd.com").sendKeys(Keys.TAB)                 //hatali email girildi
                    .sendKeys("boyle devam").sendKeys(Keys.TAB)
                    .sendKeys(f.internet().emailAddress(), f.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

            Assert.assertTrue(mailAssert.getText().contains("The provided email address format is not valid"));}


        //  8-  Kullanıcı gerekli alanı boş bıraktığında uyarıyı görebilir.
    public void bosBox() {            // kutu bos birakildiginde   hata mesaji goruldu   PASSED

        Faker f = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(name)
                .sendKeys(f.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(f.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)                                                                    // subject kutusu bos birakildi
                .sendKeys(f.internet().emailAddress(), f.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //bos birakildiginde hata mesaji dogrulandi.
        Assert.assertTrue(subjectAssert.getText().contains("What subject"));
    }

    //10--Kullanıcı Descreption bölümde sınırlandırmayla karşılaşıyor.   FAİL

    public void descriptionBoxContol() {     // FAİL

        Faker f = new Faker();    // Otomatik doldurulmasi icin faker methodu kullanildi
        Actions actions = new Actions(Driver.getDriver());
        actions.click(name)
                .sendKeys(f.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(f.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys("boyle devam").sendKeys(Keys.TAB)
                .sendKeys(f.internet().emailAddress(), f.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        Assert.assertFalse(submitButton.isDisplayed(),"Description bolumunde herhangi bir sinirlandirma yok");
        if (submitButton.isDisplayed() == true) {
            System.out.println("Description kutusu tum yazilanlari kabul ediyor. Testimiz  FAİL");
        } else System.out.println("Description kutusu secici davranıyor testimiz PASSED");

    }}



