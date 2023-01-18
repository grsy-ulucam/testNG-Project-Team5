package tests;

import com.graphbuilder.struc.Bag;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login.CustomerLoginPage;
import pages.US15_Bags.Bags;
import pages.US20_PickBazaar.MenulerSekmesi;
import utilities.Driver;
import utilities.JSUtils;

import java.time.Duration;
import java.util.List;

public class US_015 {
    @AfterMethod
    public void tearDown() {
        Driver.getDriver().quit();
    }

    @BeforeTest
    public void loginWebsite() throws InterruptedException {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");//siteye gidildi
        CustomerLoginPage cLP = new CustomerLoginPage();//customer login icin obje uretildi
        cLP.customerLogin();//musteri olarak login olundu.


        MenulerSekmesi mS = new MenulerSekmesi();//MenulerSekmesi isimli class'a erisim saglandi.
        mS.bagsClick();//Ust bolumden Bags kategorisine gidildi

        Driver.getDriver().navigate().refresh();//Kategori ekranini atlatabilmek icin sayfa guncellendi


        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();//sayfa asagiya scroll yapildi

        Thread.sleep(1500);//Tedbiren beklendi

    }

    @AfterTest
    public void tearDown1() {
        Driver.getDriver().quit();
    }

    @Test
    public void testCase01() throws InterruptedException {
/*  TestCase01 --> Kullanici urunu favorilere ekleyebilmelidir

1-Kullanıcı, müşteri sayfası URL’sine gıder
2-Kullanıcı, sayfaya müşteri statüsünde login olur ve Categories tıklar.
3-Kullanıcı, açılan sayfada Bags’e tıklar ve sonra sayfaya refresh yapılmalıdır.
4-Kullanıcı, açılan sayfada herhangi bir ürüne tıklar ve detayına ulaşır.
5-Kullanıcı, açılan ürün detayı sayfasında kalp ikonuna tıklar ve ürün favorilere eklenir.

*/
        Bags bags = new Bags();
        bags.clickTheMarcJacobs();//Bir urun secildi

        Thread.sleep(2000);//Tedbiren beklendi

        WebElement heart = Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[5]"));
        heart.click();//Urun begenilere eklendi

        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));//Tedbiren eklendi.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ESCAPE).perform();

        WebElement clickMonster = Driver.getDriver().findElement(By.xpath("//img[@alt='user name']"));
        clickMonster.click();//My Wishlists'e gitmek icin monster'a tiklandi.

        WebElement mWish2 = Driver.getDriver().findElement(By.xpath("//button[text()='My Wishlists']"));
        mWish2.click();//My Wishlist'e gidildi.

        WebElement urunMJacobs2 = Driver.getDriver().findElement(By.xpath("//a[text()='The Marc Jacobs']"));
        //Begeni listesine eklenen uyrun icin locate alindi.

        Assert.assertTrue(urunMJacobs2.isDisplayed());//Begeni listesine eklenen urun verify edildi.
    }

    @Test
    public void testCase02() throws InterruptedException {

/* Test Case02--> Kullanici urun kategorilerini goruntuleyebilmelidir
1-Kullanıcı, site ana sayfasının URL’sine gıder
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, sayfada 2 defa Page Down’a tıklar.
4-Sayfada, sol bölümdeki kategori listesinin görünür olduğu doğrulanır.
 */

        WebElement listCategory = Driver.getDriver().findElement(By.xpath("//div[@class='os-content']"));
//Sol bolumdeki kategori listesinin locator'i alindi.

        Assert.assertTrue(listCategory.isDisplayed());//Locator'un gorunur olmasi durumu verify edildi.
    }

    @Test
    public void testCase03() throws InterruptedException {
/* Test Case03 --> Kullanici urun stogundan fazla ekleme yapamamalidir

1-Kullanıcı, müşteri sayfası URL’sine gıder ve Login olur.
2-Kullanıcı, herhangi bir ürüne tıklar.
3-Ürünün „Add to Cart“ tıklanma durumu kontrol edilir (stok durumu kontrol edilir)
4-Ürünün stoğu varsa max stok sayısına kadar ürün sepete eklenir. Stokta yoksa yeni bir ürün seçilir
5- Stok sayısından fazlasının eklenememe durumu doğrulanır.
 */
        Actions actions = new Actions(Driver.getDriver());
        Bags bags = new Bags();//Bags class'a erisim saglandi
        bags.clickBalenciaga();//Bir urun secildi
        Thread.sleep(1500);//Tedbiren eklendi.

        WebElement miktar = Driver.getDriver().findElement(By.xpath("//span[@class='whitespace-nowrap text-base text-body ltr:lg:ml-7 rtl:lg:mr-7']"));
//Urunun stok bilgisinin locator'u alindi.

        if (miktar.getText().contains("Out Of Stock")) {//Stok olmamasi durumu analiz edildi.
            actions.sendKeys(Keys.ESCAPE).perform();
            WebElement goCart = Driver.getDriver().findElement(By.xpath("//span[@class='flex ltr:ml-2 rtl:mr-2']"));
            goCart.click();

            Thread.sleep(1000);
            Assert.assertFalse(Driver.getDriver().findElement(By.xpath("Armani Purse")).isDisplayed());
            System.out.println("*****   ACIKLAMA-TC03    *****");
            System.out.println("Urun Out of Stock durumunda olmasina ragmen sepete eklenebilir durumdadir, " +
                    "stokta olmayan bir urun sepete eklenemeyeceginden, burada bug vardir ");

        } else {//Stok olmasi durumu ele alindi
            String stringStock = miktar.getText().substring(0, 2);//Urunden kac tane oldugu bilgisi String olarak alindi
            int intStock = Integer.parseInt(stringStock);//String stok verisi integer degere donusturuldu.

            WebElement addCart = Driver.getDriver().findElement(By.xpath("(//span[text()='Add To Shopping Cart'])[2]"));
            addCart.click();//Urun, "Add To Shopping Cart" butonuyla sepete eklendi

            Thread.sleep(1000);//Tedbiren beklendi

            WebElement clickPlus = Driver.getDriver().findElement(By.xpath("(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none px-5'])[4]"));
//Sepete eklenen urunde + veya - isaretiyle islem yapilabileceginden arti butonunun locator'u alindi.

            for (int i = 1; i <= intStock; i++) {//Urunun stok sayisi kadar + butonuna tiklandi
                clickPlus.click();
            }
            actions.sendKeys(Keys.ESCAPE).perform();//Urunlerin listelendigi sayfaya geri donuldu(Bags)
            WebElement goCart = Driver.getDriver().findElement(By.xpath("//span[@class='flex ltr:ml-2 rtl:mr-2']"));
            goCart.click();//Sepete gidildi

            WebElement checkout = Driver.getDriver().findElement(By.xpath("//span[text()='Checkout']"));
            checkout.click();//Checkout butonu locate edildi ve tiklandi.
            Thread.sleep(1000);

            WebElement cartPiece1 = Driver.getDriver().findElement(By.xpath("//span[@class='text-sm font-bold text-heading']"));
            //Checkout bolumunde sepete eklenen adet bilgisi locate edildi.
            String cartPiece2 = cartPiece1.getText().substring(0, 2);//Sepete ne kadar urun eklendigi bilgisi String olarak alindi.
            int cartPieceLast = Integer.parseInt(cartPiece2);//Strin alinan veri integer'a donusturuldu.

            Assert.assertEquals(intStock, cartPieceLast);//Stok bilgisiyle sepete eklenen verilerin esitligi karsilastirildi.
        }
    }

    @Test
    public void testCase04() throws InterruptedException {
/* Test Case04--> Kullanici details bolumunde urun ile ilglii ayrintili bilgi gormelidir
 1-Kullanıcı, site ana sayfasının URL’sine gıder
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, sayfada 2 defa Page Down’a tıklar.
4-Kullanıcı, herhangi bir ürüne tıklar.
5-Ürünün „Details“ bölümünün görünebilir olduğu doğrulanmalıdır.

 */
        Bags bags = new Bags();//Bags class'ina objeyle erisim saglandi
        bags.clickSeeByChloé();//Herhangi bir urun secildi.

        Thread.sleep(1500);//Tedbiren beklendi.

        WebElement details = Driver.getDriver().findElement(By.name("details"));//Urun detayinda aciklama bolumu Locate edildi.
        Assert.assertTrue(details.isDisplayed());//Urun detayi bolumunun gorunur olmasi hali verify edildi.

    }

    @Test
    public void testCase05() throws InterruptedException {
/*Test Case05 -->Kullanici Related Products bolumunde urun ile iliskili baska resimler gormelidir
1-Kullanıcı, site ana sayfasının URL’sine gıder
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, sayfada 3 defa Page Down’a tıklar.
4-Kullanıcı herhangi bir ürün seçer.
5-Ürünün detayında iken „Related Product“ alanının tasarlanmadığı doğrulanır.

 */
        Thread.sleep(1500);
        Bags bags = new Bags();//Bags class'ina objeyle erisim saglandi
        bags.clickgucciHandbag();//Herhangi bir urun secildi.

        Thread.sleep(2000);//Tedbiren beklendi.

        WebElement relatedProduct = Driver.getDriver().findElement(By.xpath("(//div[@class='swiper-wrapper'])[4]"));
//Urunle ilgili fotograflarin yer aldigi bolum locate edildi.

        Assert.assertFalse(relatedProduct.isDisplayed());//Urunle ilgili diger fotograflarin yer alandigi bolumun
        // gorunurlugu verify edildi.
//Related Product bolumu tasarlanmis olsa da hicbir urunde 1'den fazla foto olmadigi icin bu bolum
// mecburen FAIL olacaktir.
//Baska kategoriden birden fazla fotografa sahip olan bir urun bu kod test edildiginde PASS sonucu alinmistir.

    }

    @Test
    public void testCase06() throws InterruptedException {
/*Kullanıcı sayfada daha fazla ürün görebilmek için scroll yapmalidir
1-Kullanıcı, site ana sayfasının URL’sine gider
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, ana sayfadayken scroll yapar ve ekran kaydırılarak aşağı inilir.

 */
        Actions actions = new Actions(Driver.getDriver());

        for (int i = 0; i < 30; i++) {//Scroll islemi arrow ile for dongusu kullanilarak yapildi.
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(10);
        }
    }

    @Test
    public void testCase07() throws InterruptedException {
/*Test Case07--> kullanici eger urunlerde indirim varsa ilk fiyat ve indirimli fiyat ve indirim oranını görmelidir
1-Kullanıcı, site ana sayfasının URL’sine gider
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, sayfada 2 defa Page Down’a tıklar.
4-Kullanıcı herhangi bir ürüne tıklar.
5-Kullanıcı’nin indirimli ve normal fiyatı ekran gördüğü doğrulanır.
6-Kullanıcı’nın indirim olan ürünlerde indirim oranını gördüğü doğrulanmalıdır.


 */
        Actions actions = new Actions(Driver.getDriver());
        List<WebElement> allDiscProd = Driver.getDriver().findElements(By.xpath("//del[@class='absolute -top-4 text-xs italic text-muted text-opacity-75 md:-top-5']"));
//Indirim tanimlanmis olan urunler list'e atildi.

        Bags bags = new Bags();//Bags class'ina objeyle erisim saglandi
        bags.clickMastHarbour();//Indirimi olan herhangi bir urun secildi.

        Thread.sleep(2000);//Tedbiren beklendi.

//Urunun detayindan liste fiyati locate edilerek gorunur olmasi hali verify edildi.
        WebElement listeFiyati = Driver.getDriver().findElement(By.xpath("//del[@class='text-sm font-normal text-muted ltr:ml-2 rtl:mr-2 md:text-base']"));
        Assert.assertTrue(listeFiyati.isDisplayed());


        String strNonDiscPr = listeFiyati.getText().substring(1);//Liste fiyati string olarak alindi
        double doubleNonDisc = Double.parseDouble(strNonDiscPr);//Liste fiyati usd isareti olmadan double'a donusturuldu
        System.out.println("Liste Fiyati = " + doubleNonDisc);//Liste fiyati konsolda yazdirildi

//Urunun detayindan satis fiyati locate edilerek gorunur olmasi hali verify edildi.
        WebElement sellingPrice = Driver.getDriver().findElement(By.xpath("//ins[@class='text-2xl font-semibold text-accent no-underline md:text-3xl']"));
        Assert.assertTrue(sellingPrice.isDisplayed());

        String strDiscPr = sellingPrice.getText().substring(1);//Indirimli fiyat string olarak alindi
        double doubleDisc = Double.parseDouble(strDiscPr);//Indirimli fiyat, usd isareti olmadan double'a donusturuldu.
        System.out.println("Satis Fiyati = " + doubleDisc);//Indirimli fiyat konsolda yazdirildi.

//Urunun detayindan indirim orani locate edilerek gorunur olmasi hali verify edildi.
        WebElement discountRate = Driver.getDriver().findElement(By.xpath("//div[@class='rounded-full bg-yellow-500 px-3 text-xs font-semibold leading-6 text-light ltr:ml-auto rtl:mr-auto']"));
        Assert.assertTrue(discountRate.isDisplayed());

        String strDiscRate = discountRate.getText().substring(0, 2);//Urun detayindan indirim orani string formatinda alindi
        int intDisc = Integer.parseInt(strDiscRate);//Indirim orani integer formatina donusturuldu.
        System.out.println("Indirim Orani = " + intDisc + " %");//Indirim orani konsolda yazdirildi

    }

    @Test
    public void testCase08() throws InterruptedException {
/*Kullanici urun linkine tiklayarak urun sayfasina gidebilmelidir
1-Kullanıcı, site ana sayfasının URL’sine gider
2-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
3-Kullanıcı, sayfada 3 defa Page Down’a tıklar.
4-Kullanıcı herhangi bir ürüne tıklar.
5-Kullanıcının ürün detayını görüntülediğine dair doğrulama yapılmalıdır.

 */
//Herhangi bir urun locate edildi.
        WebElement productDetails = Driver.getDriver().findElement(By.xpath("//h3[text()='Armani Leather Purse']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.click(productDetails).perform();//Urunun linkine tiklandi ve sayfa detayina ulasildi

        Thread.sleep(2000);

        WebElement readMore = Driver.getDriver().findElement(By.xpath("//button[text()='Read more']"));
        readMore.click();//Urunle ilgili ilk bolumde bulunan aciklama locate edilerek detayli aciklamaya tiklandi.

//Urunle ilgili detaylarin oldugu ilk bolum locate edildi.
        WebElement detail = Driver.getDriver().findElement(By.xpath("//div[@class='mt-3 text-sm leading-7 text-body md:mt-4']"));

        Assert.assertTrue(detail.isDisplayed());//Urunun detaylarinin oldugu ilk bolumun gorunur olmasi verify edildi.
    }
}