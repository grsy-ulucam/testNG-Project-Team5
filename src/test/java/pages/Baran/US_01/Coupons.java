package pages.Baran.US_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BaseTestReport;
import utilities.Driver;
import utilities.JSUtils;

import java.time.Duration;

public class Coupons extends BaseTestReport {

    public Coupons() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //Coupons Elements
    @FindBy(xpath = "//*[text()='Coupons']")
    WebElement coupon;//sol menüdeki Coupon sekmesi
    @FindBy(xpath = "(//*[contains(@class,'inline-flex items-center justify-center')])[2]")
    WebElement addCoupon;//yeni kupon ekleme butonu
    @FindBy(id = "code")
    WebElement couponCode;//buton ekleme sayfasında zorunlu doldurulacak buton codu elementi
    @FindBy(xpath = "//a[@class='text-base transition duration-200 hover:text-heading']")
    WebElement editCoupon;//eklenen butonu edit etme elementi
    @FindBy(xpath = "//*[text()='Update Coupon']")
    WebElement updateCoupon;//edit sayfasında update butonu
    @FindBy(xpath = "//*[text()='Back']")
    WebElement back;//update yapıldıktan sonra ürünler sayfasına dönmemekte bu sebeble back butonuyla dönüş yapıyoruz
    @FindBy(xpath = "//button[@title='Delete']")
    WebElement deleteCoupon;//kupon listesinde delete butonu
    @FindBy(xpath = "(//*[text()='Delete'])[2]")
    WebElement deleteOk;//delete isteğini onaylama
    @FindBy(className = "Toastify__toast-body")
    WebElement alertMessage;//alert mesajı



    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    public void couponTest() throws InterruptedException {


        Faker faker = new Faker();
        String codeName = faker.animal().name();

        //add
        coupon.click();
        addCoupon.click();
        couponCode.sendKeys(codeName);
        addCoupon.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        Assert.assertTrue(alertMessage.getText().contains("Success"));

        //edit
        WebElement firstCode = Driver.getDriver().findElement(By.xpath("//td[.='" + codeName + "']"));//eklenen ürünün locati alındı
        wait.until(ExpectedConditions.visibilityOf(firstCode));//eklenen yeni ürününn sayfaya düşmesini beklemek için
        wait.until(ExpectedConditions.invisibilityOf(alertMessage));//alert mesajları üst üste binmemesi için create alert mesajının kaybolmasını bekliyoruz
        editCoupon.click();
        updateCoupon.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        Assert.assertTrue(alertMessage.getText().contains("updated"));
        JSUtils.scrollIntoViewJS(back);//update işleminden sonra code list sayfasına dönmemekte.bu sebele sayfa altında bulunan back butonuyla dönüş yapıyoruz
        back.click();


        //delete
        deleteCoupon.click();
        deleteOk.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        Assert.assertTrue(alertMessage.getText().contains("Success"));

    }
}
