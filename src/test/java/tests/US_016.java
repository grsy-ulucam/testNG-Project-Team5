package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login.CustomerLoginPage;
import pages.US15_Bags.Bags;
import pages.US20_PickBazaar.MenulerSekmesi;
import utilities.Driver;

public class US_016 {
    @AfterMethod
    public void tearDown() {
//        Driver.getDriver().quit();
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
        //   Driver.getDriver().quit();
    }

    @Test
    public void testCase01() throws InterruptedException {
/*Sayfada iken secilen urun miktari degistirilmelidir
1-Kullanıcı, site ana sayfasının URL’sine gider
2-Kullanıcı, sayfaya müşteri statüsünde login olur ve Categories tıklar.
3-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
4-Kullanıcı, sayfada 3 defa Page Down’a tıklar.
5-Sayfada herhangi bir üründe önce „Cart“a tıklanmalı sonra da ürün sayısı artırılmalıdır.

 */
        Bags bags = new Bags();
        bags.clickBalenciaga();//Herhangi bir urun secildi.

        Thread.sleep(2000);//Tedbiren eklendi

        WebElement addCart = Driver.getDriver().findElement(By.xpath("(//span[text()='Add To Shopping Cart'])[2]"));
        addCart.click();//Urun sepete eklendi

        WebElement clickPlus = Driver.getDriver().findElement(By.xpath("(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none px-5'])[4]"));
//Sepete eklenen urunde + veya - isaretiyle islem yapilabileceginden arti butonunun locator'u alindi.
        clickPlus.click();//Urune 1 adet eklendi.
        clickPlus.click();//Urune 1 adet eklendi.
        clickPlus.click();//Urune 1 adet eklendi.

//Urun sayisi locate edildi.
        WebElement amount = Driver.getDriver().findElement(By.xpath("(//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold'])[3]"));
        String strAmount = amount.getText();//Urun miktari string formatinda alindi.
        int intAmount = Integer.parseInt(strAmount);//string olan urun miktari int'e donusturuldu.
        System.out.println("intAmount = " + intAmount);//Miktar konsolda yazdirildi

//Sepete eklenen urunde + veya - isaretiyle islem yapilabileceginden eksi butonunun locator'u alindi.
        WebElement clickMinus = Driver.getDriver().findElement(By.xpath("(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none px-5'])[3]"));
        clickMinus.click();//Urunden 1 adet azaltildi.

//Bu kontrolde; int urun miktari 1'e esit oldugu durumda urun miktarinin degistirilmedigi varsayilarak
// testin fail olacagi kabul edilmistir. Sepetteki urun miktari sayisi 1 harici ise
// sepette degisiklik yapildigi icin test pass olarak sonuclanmistir.
        if (intAmount == 1) {
            Assert.fail();
        }
    }

    @Test
    public void test02() throws InterruptedException {
/*Sepete gittiginde urun miktari degistirilmelidir
1-Kullanıcı, site ana sayfasının URL’sine gider
2-Kullanıcı, sayfaya müşteri statüsünde login olur ve Categories tıklar.
3-Kullanıcı, en üstte „Grocery“ yazılı alandan Bags’i seçer ve sonra sayfaya refresh yapılmalıdır.
4-Kullanıcı, sayfada 3 defa Page Down’a tıklar.
5-Sayfada herhangi bir üründe önce „Cart“a tıklanmalı sonra da ürün sayısı artırılmalıdır.
6-Sepete tıklanılarak, aynı ürünün sayısı değiştirilir.
7- Ürünün sepete eklenen miktarıyla güncellenen miktarının sıfırdan büyük olduğu doğrulanmalıdır.

 */
        Bags bags = new Bags();
        bags.clickBalenciaga();

        WebElement addCart = Driver.getDriver().findElement(By.xpath("(//span[text()='Add To Shopping Cart'])[2]"));
        addCart.click();//Urun sepete eklendi

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ESCAPE).perform();//Urun detayindan --> Bags kategorisinin genel gorundugu sayfaya geri donuldu.

        WebElement cart = Driver.getDriver().findElement(By.xpath("//span[@class='flex pb-0.5']"));
        cart.click();//Sepete tiklandi

        Thread.sleep(1500);//Tedbiren beklendi.

//Sepete eklenen urunde + veya - isaretiyle islem yapilabileceginden arti butonunun locator'u alindi.
        WebElement cartPlus = Driver.getDriver().findElement(By.xpath("(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none hover:!bg-gray-100'])[2]"));
        cartPlus.click();//Urun 1 adet artirildi.
        cartPlus.click();//Urun 1 adet artirildi.

//Urunun sepette ne kadar oldugu bilgisi locate edildi.
        WebElement amountCart = Driver.getDriver().findElement(By.xpath("//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold !px-0 text-heading']"));
        String strAmountCart = amountCart.getText();//Urun miktari string formatinda alindi.
        int intAmountCart = Integer.parseInt(strAmountCart);//String olan urun miktari integer'a donusturuldu.

//Bu kontrolde; int urun miktari 1'e esit oldugu durumda urun miktarinin degistirilmedigi varsayilarak
// testin fail olacagi kabul edilmistir. Sepetteki urun miktari sayisi 1 harici ise
// sepette degisiklik yapildigi icin test pass olarak sonuclanmistir.

        if (intAmountCart == 1) {
            Assert.fail();
        }

    }
}