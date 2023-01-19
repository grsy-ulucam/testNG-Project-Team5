package tests;

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
import pages.US15_16_Bags.Bags;
import pages.US20_PickBazaar.MenulerSekmesi;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_015 extends BaseTestReport {

    @BeforeTest
    public void loginWebsite() throws InterruptedException {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");//siteye gidildi
        CustomerLoginPage cLP = new CustomerLoginPage();//customer login icin obje uretildi
        cLP.customerLogin();//musteri olarak login olundu.

        HomePage hP = new HomePage();

        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.visibilityOf(hP.menu)).click();
//Ustteki kategori sekmesi gorunene kadar(max 5sn) beklendi gorununce de tiklandi.

        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOf(hP.bags)).click();
//Kategorilerden Bags gorunene kadar (max 5sn) beklendi, gorununce de tiklandi.

        Driver.getDriver().navigate().refresh();//Kategori ekranini atlatabilmek icin sayfa guncellendi

//Scroll islemi yapildi.
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("window.scrollBy(0,1500)");

        //Scroll icin 2. YONTEM
        //     Actions actions = new Actions(Driver.getDriver());
        //     actions.sendKeys(Keys.PAGE_DOWN)
        //             .sendKeys(Keys.PAGE_DOWN)
        //             .sendKeys(Keys.PAGE_DOWN)
        //             .perform();//sayfa asagiya scroll yapildi

    }

    @AfterTest
    public void tearDown1() {
//        Driver.getDriver().quit();
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().quit();
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
        HomePage hP = new HomePage();//HomePage class'ina erisim saglandi.
        Bags bags = new Bags();//Bags class'ina erisim saglandi.

        bags.theMarcJacobs.click();//Bir urun secildi

        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));//Tedbiren beklendi.
        wait1.until(ExpectedConditions.visibilityOf(bags.heart)).click();//Urun Wishlists'e (favorilere) eklendi

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(bags.myWishlists)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(bags.theMarcJacobs.isDisplayed());//Urunun favorilerde olmasi dogrulandi.
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

        Bags bags = new Bags();//Bags class'a erisim saglandi.
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
        Actions actions = new Actions(Driver.getDriver());
        Bags bags = new Bags();//Bags class'a erisim saglandi

        bags.balenciaga.click();//Bir urun secildi

        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren eklendi
        wait1.until(ExpectedConditions.visibilityOf(bags.stok));//Stok bilgisinin gorunmesi durumuna kadar beklendi.(max 10sn)

//Out Of Stock olan tum urunlerin locator'larinda erisim problemi yasandigindan bug kaydi acildi.
//Bu nedenle sadece stok'u olan urunler icin Automation testing yapilabilmektedir ve testler PASS sonuclandi.

        if (bags.stok.getText().contains("Out Of Stock")) {//Stok olmamasi durumu analiz edildi.
            actions.sendKeys(Keys.ESCAPE).perform();//Bags categori sayfasina geri donuldu.

            WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
            wait2.until(ExpectedConditions.visibilityOf(bags.cart)).click();//Sepete tiklandi.

            WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklenebilir.
            wait3.until(ExpectedConditions.visibilityOf(bags.givenchyMiniPurse));
            Assert.assertFalse(bags.givenchyMiniPurse.isDisplayed());

            System.out.println("*****   ACIKLAMA-TC03    *****");
            System.out.println("Urun Out of Stock durumunda olmasina ragmen sepete eklenebilir durumdadir, " +
                    "stokta olmayan bir urun sepete eklenemeyeceginden, burada bug vardir ");

        } else {//Stok olmasi durumu ele alindi

            String stringStock = bags.stok.getText().substring(0, 2);//Urunden kac tane oldugu bilgisi String olarak alindi
            int intStock = Integer.parseInt(stringStock);//String stok verisi integer degere donusturuldu.

            bags.addShoppingCart.click();//Urun, "Add To Shopping Cart" butonuyla sepete eklendi

            Thread.sleep(1000);//Tedbiren beklendi

//TRICK: Urunun stok sayisinin 1 fazlasi kadar + butonuna tiklandi
// ancak bu islemin sadece urun sayisina kadar artmis oldugu en alttaki Assert bolumunde dogrulandi.
//OZETLE; + butonuna fazla tiklansa bile sadece urun stok sayisi kadar sepete urun eklenmis oldu.

            for (int i = 1; i <= intStock + 1; i++) {
                bags.clickPlus.click();
            }
            actions.sendKeys(Keys.ESCAPE).perform();//Urunlerin listelendigi kategori sayfasina geri donuldu(Bags)

            bags.cart.click();//sepete gidildi.
            bags.checkout.click();//Checkout'a'tiklandi.

            String strCartAmount = bags.cartAmount.getText().substring(0, 2);//Sepete ne kadar urun eklendigi bilgisi String olarak alindi.
            int intCartAmount = Integer.parseInt(strCartAmount);//String alinan veri integer'a donusturuldu.

            Assert.assertEquals(intStock, intCartAmount);//Stok bilgisiyle sepete eklenen verilerin esitligi karsilastirildi.
        }
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
        Bags bags = new Bags();//Bags class'ina objeyle erisim saglandi
        bags.seeByChloé.click();//Herhangi bir urun secildi.

        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait1.until(ExpectedConditions.visibilityOf(bags.prodDetails)).click();//Urunun Details bolumune tiklanarak detayi acildi.

        Assert.assertTrue(bags.prodDetails.isDisplayed());//Urun detayi bolumunun gorunur olmasi hali verify edildi.

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
        Bags bags = new Bags();//Bags class'ina objeyle erisim saglandi
        bags.gucciHandbag.click();//Herhangi bir urun secildi.

        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));//Tedbiren bekleme komutu yazildi.
        wait1.until(ExpectedConditions.visibilityOf(bags.relatedProd));//Urunle ilgili fotolarin oldugu alanin yuklenmesi beklendi.
        //Ancak hicbir urunde 1'den fazla fotograf olmadigi icin bu alan Automation testte bulunamadi.

        Assert.assertTrue(bags.relatedProd.isDisplayed());//Urunle ilgili diger fotograflarin yer alandigi bolumun
        // gorunurlugu verify edildi.

//Related Product bolumu tasarlanmis olsa da hicbir urunde 1'den fazla foto olmadigi icin bu bolum
// mecburen FAIL olacaktir.
//Baska kategoriden birden fazla fotografa sahip olan bir urun bu kod test edildiginde PASS sonucu alinmistir.

    }

    @Test
    public void testCase06(ITestContext context) throws InterruptedException {
/*Test Case 06 --> Kullanıcı sayfada daha fazla ürün görebilmek için scroll yapmalidir
1-Kullanıcı, site ana sayfasının URL’sine gider
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, ana sayfadayken scroll yapar ve ekran kaydırılarak aşağı inilir.

 */
        extentTest = extentReports.createTest("testCase06");//Bu kod satiri test raporu olusturmak icin yazildi.
        Actions actions = new Actions(Driver.getDriver());

        for (int i = 0; i < 50; i++) {//Scroll islemi arrow ile for dongusu kullanilarak yapildi.
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(10);
        }
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
        Actions actions = new Actions(Driver.getDriver());
        Bags bags = new Bags();//Bags class'ina objeyle erisim saglandi
        //Indirim tanimlanmis olan urunler list'e atildi
        List<WebElement> allDiscProd = new ArrayList<>(Arrays.asList(bags.discountPrice));
        System.out.println("*****   Indirimli Urunler Listesi   *****");
        for (WebElement each : allDiscProd) {
            System.out.println(each.getText());
        }

        bags.mastHarbour.click();//Indirimi olan herhangi bir urun secildi.

        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));//Tedbiren bekleme komutu yazildi.
        wait1.until(ExpectedConditions.visibilityOf(bags.listeFiyati));//Liste fiyati ekranda gorunmesi beklendi.

        Assert.assertTrue(bags.listeFiyati.isDisplayed());//Liste fiyatinin gorunurlugu dorulandi.

        String strNonDiscPr = bags.listeFiyati.getText().substring(1);//Liste fiyati string olarak alindi
        double doubleNonDisc = Double.parseDouble(strNonDiscPr);//Liste fiyati usd isareti olmadan double'a donusturuldu
        System.out.println("Liste Fiyati = " + doubleNonDisc);//Liste fiyati konsolda yazdirildi

        Assert.assertTrue(bags.sellingPrice.isDisplayed());//Satis fiyatinin gorunurlugu dogrulandi

        String strDiscPr = bags.sellingPrice.getText().substring(1);//Indirimli fiyat string olarak alindi
        double doubleDisc = Double.parseDouble(strDiscPr);//Indirimli fiyat, usd isareti olmadan double'a donusturuldu.
        System.out.println("Satis Fiyati = " + doubleDisc);//Indirimli fiyat konsolda yazdirildi.

        Assert.assertTrue(bags.discountRate.isDisplayed());//Urun detayinda indirim oraninin gorunurlugu dogrulandi.

        String strDiscRate = bags.discountRate.getText().substring(0, 2);//Urun detayindan indirim orani string formatinda alindi
        int intDisc = Integer.parseInt(strDiscRate);//Indirim orani integer formatina donusturuldu.
        System.out.println("Indirim Orani = " + intDisc + " %");//Indirim orani konsolda yazdirildi

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
        Bags bags = new Bags();//Bags class'ina erismek icin obje olusturuldu.
        bags.gucciPurse.click();//Herhangi bir urun locate edildi.
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));//Tedbiren bekleme komutu yazildi.
        wait1.until(ExpectedConditions.visibilityOf(bags.readMore)).click();//Urunle ilgili ust bolumde bulunan aciklamaya tiklandi.

        Assert.assertTrue(bags.detail.isDisplayed());//Urunun detaylarinin oldugu ilk bolumun gorunur olmasi verify edildi.
    }
}