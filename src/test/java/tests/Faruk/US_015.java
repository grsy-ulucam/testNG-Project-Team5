package tests.Faruk;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

public class US_015 extends BaseTestReport {

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

    @AfterTest
    public void tearDown1() {
        Driver.getDriver().quit();
    }

    @AfterMethod
    public void tearDown() {
//        Driver.getDriver().quit();
    }

    @Test
    public void testCase01(ITestContext context) throws InterruptedException {
/*  TestCase01 --> Kullanici urunu favorilere ekleyebilmelidir

1-Kullanıcı, müşteri sayfası URL’sine gıder
2-Kullanıcı, sayfaya müşteri statüsünde login olur ve Categories tıklar.
3-Kullanıcı, açılan sayfada Bags’e tıklar ve sonra sayfaya refresh yapılmalıdır. Sonrasinda sayfada scroll yapilir.
4-Kullanıcı, açılan sayfada herhangi bir ürüne tıklar ve detayına ulaşır.
5-Kullanıcı, açılan ürün detayı sayfasında kalp ikonuna tıklar ve ürün favorilere eklenir.
*/

        extentTest = extentReports.createTest("testCase01");//Test raporu komutudur.
        bags.addMyWishlistArmaniLeatherPurse();//myWishlists'e alinmak istenen urunun methodu cagirildi.

    }

    @Test
    public void testCase02(ITestContext context) throws InterruptedException {

/* Test Case02--> Kullanici urun kategorilerini goruntuleyebilmelidir
1-Kullanıcı, site ana sayfasının URL’sine gıder
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, sayfada scroll yapar.
4-Sayfada, sol bölümdeki kategori listesinin görünür olduğu doğrulanır.
 */

        extentTest = extentReports.createTest("testCase02");//Test raporu alinmasi icin yazilan komuttur.

        Assert.assertTrue(bags.listCategory.isDisplayed());//Locator'un gorunur olmasi durumu verify edildi.
    }


    @Test
    public void testCase03(ITestContext context) throws InterruptedException {
/* Test Case03 --> Kullanici urun stogundan fazla ekleme yapamamalidir

1-Kullanıcı, müşteri sayfası URL’sine gıder ve Login olur. Bags kategorisine gidilir ve scroll yapilir.
2-Kullanıcı, herhangi bir ürüne tıklar.
3-Ürünün „Add to Cart“ tıklanma durumu kontrol edilir (stok durumu kontrol edilir)
4-Ürünün stoğu varsa max stok sayısına kadar ürün sepete eklenir. Stokta yoksa yeni bir ürün seçilir
5- Stok sayısından fazlasının eklenememe durumu doğrulanır.
 */

        extentTest = extentReports.createTest("caseTest03");//Bu kod satiri test raporu olusturmak icin yazildi.

        bags.methodBalenciaga();//Stogu olan bir urun secildi.
        bags.fugtBisEndeHinzu();//Urun sepete eklenerek stok sayisi kadar adedi arttirilarak kod dogrulandi
    }


    @Test
    public void testCase04(ITestContext context) throws InterruptedException {
/* Test Case04--> Kullanici details bolumunde urun ile ilglii ayrintili bilgi gormelidir
 1-Kullanıcı, site ana sayfasının URL’sine gıder
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, sayfada scroll yapilir.
4-Kullanıcı, herhangi bir ürüne tıklar.
5-Ürünün „Details“ bölümünün görünebilir olduğu doğrulanmalıdır.
*/

        extentTest = extentReports.createTest("testCase04");//Bu kod satiri test raporu olusturmak icin yazildi.

        bags.methodSeeByChole();//Herhangi bir urun secildi.
        bags.showDetails();

    }

    @Test
    public void testCase05(ITestContext context) throws InterruptedException {
/*Test Case05 -->Kullanici Related Products bolumunde urun ile iliskili baska resimler gormelidir
1-Kullanıcı, site ana sayfasının URL’sine gıder
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, sayfada scroll yapilir.
4-Kullanıcı herhangi bir ürün seçer.
5-Ürünün detayında iken „Related Product“ alanının tasarlanmadığı doğrulanır.

 */
        extentTest = extentReports.createTest("testCase05");//Bu kod satiri test raporu olusturmak icin yazildi.

        bags.methodGucciHandbag();//Herhangi bir urun secildi.
        bags.relatedProduct();
    }

    @Test
    public void testCase06(ITestContext context) throws InterruptedException {
/*Test Case 06 --> Kullanıcı sayfada daha fazla ürün görebilmek için scroll yapmalidir
1-Kullanıcı, site ana sayfasının URL’sine gider
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, ana sayfadayken scroll yapar ve ekran kaydırılarak aşağı inilir.

 */
        extentTest = extentReports.createTest("testCase06");//Bu kod satiri test raporu olusturmak icin yazildi.
        bags.scroll();
    }

    @Test
    public void testCase07(ITestContext context) throws InterruptedException {
/*Test Case07--> kullanici eger urunlerde indirim varsa ilk fiyat ve indirimli fiyat ve indirim oranını görmelidir
1-Kullanıcı, site ana sayfasının URL’sine gider
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, sayfada scroll yapilir.
4-Kullanıcı herhangi bir ürüne tıklar.
5-Kullanıcı’nin indirimli ve normal fiyatı ekran gördüğü doğrulanır.
6-Kullanıcı’nın indirim olan ürünlerde indirim oranını gördüğü doğrulanmalıdır.

 */

        extentTest = extentReports.createTest("testCase07");//Bu kod satiri test raporu olusturmak icin yazildi.
        bags.indirimliUrunler();//Indirimli urunler listeye alindi
        bags.methodMastHarbour();//Indirimi olan herhangi bir urun secildi.
        bags.listeFiyat();//Urun liste fiyati icin calisildi
        bags.sellingPrice();// Urun satis fiyati icin calisildi
        bags.discountRate();//Urun indirim orani icin calisildi
    }

    @Test
    public void testCase08(ITestContext context) throws InterruptedException {
/*Kullanici urun linkine tiklayarak urun sayfasina gidebilmelidir
1-Kullanıcı, site ana sayfasının URL’sine gider
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, sayfada scroll yapar.
4-Kullanıcı herhangi bir ürüne tıklar.
5-Kullanıcının ürün detayını görüntülediğine dair doğrulama yapılmalıdır.

 */

        extentTest = extentReports.createTest("testCase08");//Bu kod satiri test raporu olusturmak icin yazildi.

        bags.clickElementByJS_TC08(bags.gucciPurse);
    }
}