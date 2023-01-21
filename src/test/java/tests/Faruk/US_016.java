package tests.Faruk;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login.CustomerLoginPage;
import pages.Login.HomePage;
import pages.Faruk.Bags;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;


public class US_016 extends BaseTestReport {

    public Actions actions = new Actions(Driver.getDriver());//Actions aktiflestirildi.
    public Bags bags = new Bags();//Bags class'ina erisim saglandi
    public HomePage hP = new HomePage();//HomePage class'ina erisim saglandi

    @BeforeTest
    public void loginWebsite() throws InterruptedException {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");//siteye gidildi
        CustomerLoginPage cLP = new CustomerLoginPage();//customer login icin obje uretildi
        cLP.customerLogin();//musteri olarak login olundu.

        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(hP.menu)).click();
//Ustteki kategori sekmesi gorunene kadar(max 10sn) beklendi gorununce de tiklandi.

        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOf(hP.bags)).click();
//Kategorilerden Bags gorunene kadar (max 10sn) beklendi, gorununce de tiklandi.

        Driver.getDriver().navigate().refresh();//Kategori ekranini atlatabilmek icin sayfa guncellendi
//Scroll islemi yapildi.
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("window.scrollBy(0,1500)");
    }

    @AfterMethod
    public void tearDown() {
//        Driver.getDriver().quit();
    }

    @AfterTest
    public void tearDown1() {
   Driver.getDriver().quit();
    }

    @Test
    public void testCase01(ITestContext context) throws InterruptedException {
/*Sayfada iken secilen urun miktari degistirilmelidir
1-Kullanıcı, site ana sayfasının URL’sine gider
2-Kullanıcı, sayfaya müşteri statüsünde login olur ve Categories tıklar.
3-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
4-Kullanıcı, sayfada 3 defa Page Down’a tıklar.
5-Sayfada herhangi bir üründe önce „Cart“a tıklanmalı sonra da ürün sayısı artırılmalıdır.

 */
        extentTest = extentReports.createTest("testCase01");

        bags.methodBalenciaga();//Herhangi bir urun secildi.
        bags.miktarGuncelle();// Urun detay sayfasindaki miktar guncelleme islemlerinin methodudur.
    }

    @Test
    public void testCase02(ITestContext context) throws InterruptedException {
/*Sepete gittiginde urun miktari degistirilmelidir
1-Kullanıcı, site ana sayfasının URL’sine gider
2-Kullanıcı, sayfaya müşteri statüsünde login olur ve Categories tıklar.
3-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
4-Kullanıcı, sayfada 3 defa Page Down’a tıklar.
5-Sayfada herhangi bir üründe önce „Cart“a tıklanmalı sonra da ürün sayısı artırılmalıdır.
6-Sepete tıklanılarak, aynı ürünün sayısı değiştirilir.
7- Ürünün sepete eklenen miktarıyla güncellenen miktarının sıfırdan büyük olduğu doğrulanmalıdır.

 */
        extentTest=extentReports.createTest("testCase02");
        bags.methodSalvatoreFerragamo();//Bir urun secildi.
        bags.refreshInCart();

    }
}