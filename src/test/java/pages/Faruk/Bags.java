package pages.Faruk;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.Login.HomePage;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bags {

    public Bags() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public Actions actions = new Actions(Driver.getDriver());
    public HomePage hP = new HomePage();

    @FindBy(xpath = "(//h3[@role='button'])[1]")
    public WebElement armaniLeatherPurse;

    @FindBy(xpath = "(//h3[@role='button'])[2]")
    public WebElement armaniPurse;

    @FindBy(xpath = "(//h3[@role='button'])[3]")
    public WebElement givenchyPurse;

    @FindBy(xpath = "(//h3[@role='button'])[4]")
    public WebElement givenchyMiniPurse;

    @FindBy(xpath = "(//h3[@role='button'])[5]")
    public WebElement gucciPurse;

    @FindBy(xpath = "(//h3[@role='button'])[6]")
    public WebElement armaniSilverPurse;

    @FindBy(xpath = "(//h3[@role='button'])[7]")
    public WebElement gucciGGMarmontTote;

    @FindBy(xpath = "(//h3[@role='button'])[8]")
    public WebElement kAAIPyramidBag;

    @FindBy(xpath = "(//h3[@role='button'])[9]")
    public WebElement theMarcJacobs;

    @FindBy(xpath = "(//h3[@role='button'])[10]")
    public WebElement balenciaga;

    @FindBy(xpath = "(//h3[@role='button'])[11]")
    public WebElement gucciHandbag;

    @FindBy(xpath = "(//h3[@role='button'])[12]")
    public WebElement armaniHandbag;

    @FindBy(xpath = "(//h3[@role='button'])[13]")
    public WebElement mastHarbour;

    @FindBy(xpath = "(//h3[@role='button'])[14]")
    public WebElement seeByChloé;

    @FindBy(xpath = "(//h3[@role='button'])[15]")
    public WebElement salvatoreFerragamo;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement heart;//Begeni butonu locati'dir.

    //Asagidaki WebElement normalde HomePage Class'inda olmasina ragmen, locator dogru olmadigi icin buraya xpath ile eklenmistir.
    @FindBy(xpath = "//button[text()='My Wishlists']")
    public WebElement myWishlists;

    @FindBy(xpath = "//div[@class='os-content']")
    public WebElement listCategory;//Sol bolumdeki kategori listesinin locator'i alindi.

    @FindBy(xpath = "//span[@class='whitespace-nowrap text-base text-body ltr:lg:ml-7 rtl:lg:mr-7']")
    public WebElement stok;//Urun detay sayfasinda bulunan urun stok bilgisi locati'dir.

    @FindBy(xpath = "//div[@class='whitespace-nowrap text-base text-red-500 ltr:lg:ml-7 rtl:lg:mr-7']")
    public WebElement outOfStock;

    @FindBy(xpath = "//span[@class='flex ltr:ml-2 rtl:mr-2']")
    public WebElement cart;//Sag kenarda kucuk kulakcik gibi gorunen Sepet'in locate'dir.

    @FindBy(xpath = "(//span[text()='Add To Shopping Cart'])[2]")
    public WebElement addShoppingCart;//urun detay sayfasindaki "Sepete Ekle" butonunun locate'dir.

    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none px-5'])[4]")
    public WebElement clickPlus;//Sepete eklenen urunde + veya - isaretiyle islem yapilabileceginden arti butonunun locator'u alindi.

    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none px-5'])[3]")
    public WebElement clickMinus;//Sepete eklenen urunde + veya - isaretiyle islem yapilabileceginden eksi butonunun locator'u alindi.

    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none hover:!bg-gray-100'])[2]")
    public WebElement plusInCart;//Sepete eklenen urunde + veya - isaretiyle islem yapilabileceginden arti butonunun locator'u alindi.

    @FindBy(xpath = "(//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold'])[3]")
    public WebElement amount;//Urun sayisi urun detay sayfasinda locate edildi.

    @FindBy(xpath = "//span[text()='Checkout']")
    public WebElement checkout;//Cart icinden ulasilan Checkout butonu locati'dir.

    @FindBy(xpath = "//span[@class='text-sm font-bold text-heading']")
    public WebElement cartAmount;//Urunun sepete eklenen adet bilgisinin Checkout sayfasindaki locate'dir.

    @FindBy(xpath = "//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold !px-0 text-heading']")
    public WebElement cartAmount2;//Urunun sepette ne kadar oldugu bilgisi locate edildi.

    @FindBy(name = "details")
    public WebElement prodDetails;//Urun detayinda aciklama bolumu Locate edildi.

    @FindBy(xpath = "(//div[@class='swiper-wrapper'])[4]")
    public WebElement relatedProd;//Urunle ilgili fotograflarin yer aldigi bolum locate edildi.
    @FindBy(xpath = "//del[@class='absolute -top-4 text-xs italic text-muted text-opacity-75 md:-top-5']")
    public WebElement discountPrice;

    @FindBy(xpath = "//del[@class='text-sm font-normal text-muted ltr:ml-2 rtl:mr-2 md:text-base']")
    public WebElement listeFiyati;//Urunun detayindan liste fiyati locate edilerek gorunur olmasi hali verify edildi.

    @FindBy(xpath = "//ins[@class='text-2xl font-semibold text-accent no-underline md:text-3xl']")
    public WebElement sellingPrice;//Urunun detayindan satis fiyati locate edildi.

    @FindBy(xpath = "//div[@class='rounded-full bg-yellow-500 px-3 text-xs font-semibold leading-6 text-light ltr:ml-auto rtl:mr-auto']")
    public WebElement discountRate;//Urunun detayindan indirim orani locate edildi.

    @FindBy(xpath = "//button[text()='Read more']")
    public WebElement readMore;//Urunle ilgili ust bolumde bulunan aciklama locate edildi

    @FindBy(xpath = "//div[@class='mt-3 text-sm leading-7 text-body md:mt-4']")
    public WebElement detail;//Urunle ilgili detaylarin oldugu ilk bolum locate edildi.


    public void methodArmaniLeatherPurse() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(armaniLeatherPurse));
        actions.moveToElement(armaniLeatherPurse).click().perform();

    }

    public void addMyWishlistArmaniLeatherPurse() {
        methodArmaniLeatherPurse();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(armaniLeatherPurse)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(armaniLeatherPurse.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodArmaniPurse() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(armaniPurse));
        actions.moveToElement(armaniPurse).click().perform();
    }

    public void addMyWishlistArmaniPurse() {
        methodArmaniPurse();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(armaniPurse)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(armaniPurse.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodGivenchyPurse() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(givenchyPurse));
        actions.moveToElement(givenchyPurse).click().perform();

    }

    public void addMyWishlistGivenchyPurse() {
        methodGivenchyPurse();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(givenchyPurse)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(givenchyPurse.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodGivenchyMiniPurse() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(givenchyMiniPurse));
        actions.moveToElement(givenchyMiniPurse).click().perform();

    }

    public void addMyWishlistGivenchyMiniPurse() {
        methodGivenchyMiniPurse();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(givenchyMiniPurse)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(givenchyMiniPurse.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodGucciPurse() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(gucciPurse));
        actions.moveToElement(gucciPurse).click().perform();

    }

    public void addMyWishlistGucciPurse() {
        methodGucciPurse();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(gucciPurse)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(gucciPurse.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodArmaniSilverPurse() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(armaniSilverPurse));
        actions.moveToElement(armaniSilverPurse).click().perform();

    }

    public void addMyWishlistArmaniSilverPurse() {
        methodArmaniSilverPurse();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(armaniSilverPurse)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(armaniSilverPurse.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodGucciGGMarmontTote() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(gucciGGMarmontTote));
        actions.moveToElement(gucciGGMarmontTote).click().perform();

    }

    public void addMyWishlistGucciGGMarmontTote() {
        methodGucciGGMarmontTote();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(gucciGGMarmontTote)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(gucciGGMarmontTote.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodKAAIPyramidBag() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(kAAIPyramidBag));
        actions.moveToElement(kAAIPyramidBag).click().perform();

    }

    public void addMyWishlistKAAIPyramidBag() {
        methodKAAIPyramidBag();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(kAAIPyramidBag)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(kAAIPyramidBag.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodTheMarcJacobs() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(theMarcJacobs));
        actions.moveToElement(theMarcJacobs).click().perform();

    }

    public void addMyWishlistTheMarcJacobs() {
        methodTheMarcJacobs();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(theMarcJacobs)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(theMarcJacobs.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodBalenciaga() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(balenciaga));
        actions.moveToElement(balenciaga).click().perform();

    }

    public void addMyWishlistBalenciaga() {
        methodBalenciaga();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(balenciaga)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(balenciaga.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodGucciHandbag() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(gucciHandbag));
        actions.moveToElement(gucciHandbag).click().perform();

    }

    public void addMyWishlistGucciHandbag() {
        methodGucciHandbag();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(gucciHandbag)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(gucciHandbag.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodArmaniHandbag() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(armaniHandbag));
        actions.moveToElement(armaniHandbag).click().perform();

    }

    public void addMyWishlistArmaniHandbag() {
        methodArmaniHandbag();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(armaniHandbag)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(armaniHandbag.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodMastHarbour() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(mastHarbour));
        actions.moveToElement(mastHarbour).click().perform();

    }

    public void addMyWishlistMastHarbour() {
        methodMastHarbour();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(mastHarbour)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(mastHarbour.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodSeeByChole() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(seeByChloé));
        actions.moveToElement(seeByChloé).click().perform();

    }

    public void addMyWishlistSeeByChole() {
        methodSeeByChole();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(seeByChloé)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(seeByChloé.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void methodSalvatoreFerragamo() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(salvatoreFerragamo));
        actions.moveToElement(salvatoreFerragamo).click().perform();

    }

    public void addMyWishlistSalvatoreFerragamo() {
        methodSalvatoreFerragamo();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait2.until(ExpectedConditions.visibilityOf(heart)).click();//Urun Wishlists'e (favorilere) eklendi

        actions.sendKeys(Keys.ESCAPE).perform();//Urun detay sayfasindan Bags ana menusune geri donuldu.

        hP.profilImage.click();//My Wishlists'e gitmek icin monster'a tiklandi.
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait3.until(ExpectedConditions.visibilityOf(salvatoreFerragamo)).click();//My Wishlist'e tiklandi.

        Assert.assertTrue(salvatoreFerragamo.isDisplayed());//Urunun favorilerde olmasi dogrulandi.

    }

    public void fugtBisEndeHinzu() {
        addShoppingCart.click();//Urun, "Add To Shopping Cart" butonuyla sepete eklendi

        String stringStock = stok.getText().substring(0, 2);//Urunden kac tane oldugu bilgisi String olarak alindi
        int intStock = Integer.parseInt(stringStock);//String stok verisi integer degere donusturuldu.

        //TRICK: Urunun stok sayisinin 1 fazlasi kadar + butonuna tiklandi
        // ancak bu islemin sadece urun sayisina kadar artmis oldugu en alttaki Assert bolumunde dogrulandi.
        //OZETLE; + butonuna fazla tiklansa bile sadece urun stok sayisi kadar sepete urun eklenmis oldu.

        for (int i = 1; i <= intStock + 1; i++) {
            clickPlus.click();
        }
        actions.sendKeys(Keys.ESCAPE).perform();//Urunlerin listelendigi kategori sayfasina geri donuldu(Bags)

        cart.click();//sepete gidildi.
        checkout.click();//Checkout'a'tiklandi.

        String strCartAmount = cartAmount.getText().substring(0, 2);//Sepete ne kadar urun eklendigi bilgisi String olarak alindi.
        int intCartAmount = Integer.parseInt(strCartAmount);//String alinan veri integer'a donusturuldu.

        Assert.assertEquals(intStock, intCartAmount);//Stok bilgisiyle sepete eklenen verilerin esitligi karsilastirildi.

    }

    public void showDetails() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));//Tedbiren beklendi.
        wait1.until(ExpectedConditions.visibilityOf(prodDetails)).click();//Urunun Details bolumune tiklanarak detayi acildi.

        Assert.assertTrue(prodDetails.isDisplayed());//Urun detayi bolumunun gorunur olmasi hali verify edildi.

    }

    public void relatedProduct() {
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));//Tedbiren bekleme komutu yazildi.
        wait1.until(ExpectedConditions.visibilityOf(relatedProd));//Urunle ilgili fotolarin oldugu alanin yuklenmesi beklendi.
        //Ancak hicbir urunde 1'den fazla fotograf olmadigi icin bu alan Automation testte bulunamadi.

        Assert.assertTrue(relatedProd.isDisplayed());//Urunle ilgili diger fotograflarin yer alandigi bolumun
        // gorunurlugu verify edildi.

//Related Product bolumu tasarlanmis olsa da hicbir urunde 1'den fazla foto olmadigi icin bu bolum
// mecburen FAIL sonuclanir.
//Baska kategoriden birden fazla fotografa sahip olan bir urun bu kod test edildiginde PASS sonucu alinmistir.

    }

    public void scroll() {

        for (int i = 0; i < 50; i++) {//Scroll islemi arrow ile for dongusu kullanilarak yapildi.
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
    }

    public void indirimliUrunler() {
        //Indirim tanimlanmis olan urunler list'e atildi
        List<WebElement> allDiscProd = new ArrayList<>(Arrays.asList(discountPrice));
        System.out.println("*****   Indirimli Urunler Listesi   *****");

        for (WebElement each : allDiscProd) {
            System.out.println(each.getText());
        }

    }

    public void listeFiyat() {

        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));//Tedbiren bekleme komutu yazildi.
        wait1.until(ExpectedConditions.visibilityOf(listeFiyati));//Liste fiyati ekranda gorunmesi beklendi.

        Assert.assertTrue(listeFiyati.isDisplayed());//Liste fiyatinin gorunurlugu dorulandi.

        String strNonDiscPr = listeFiyati.getText().substring(1);//Liste fiyati string olarak alindi
        double doubleNonDisc = Double.parseDouble(strNonDiscPr);//Liste fiyati usd isareti olmadan double'a donusturuldu
        System.out.println("Liste Fiyati = " + doubleNonDisc);//Liste fiyati konsolda yazdirildi

    }

    public void sellingPrice() {
        Assert.assertTrue(sellingPrice.isDisplayed());//Satis fiyatinin gorunurlugu dogrulandi

        String strDiscPr = sellingPrice.getText().substring(1);//Indirimli fiyat string olarak alindi
        double doubleDisc = Double.parseDouble(strDiscPr);//Indirimli fiyat, usd isareti olmadan double'a donusturuldu.
        System.out.println("Satis Fiyati = " + doubleDisc);//Indirimli fiyat konsolda yazdirildi.

    }

    public void discountRate() {
        Assert.assertTrue(discountRate.isDisplayed());//Urun detayinda indirim oraninin gorunurlugu dogrulandi.

        String strDiscRate = discountRate.getText().substring(0, 2);//Urun detayindan indirim orani string formatinda alindi
        int intDisc = Integer.parseInt(strDiscRate);//Indirim orani integer formatina donusturuldu.
        System.out.println("Indirim Orani = " + intDisc + " %");//Indirim orani konsolda yazdirildi

    }

    public void clickElementByJS_TC08(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();", element);

        Assert.assertTrue(detail.isDisplayed());//Urunun detaylarinin oldugu ilk bolumun gorunur olmasi verify edildi.
    }

    public void miktarGuncelle() {

        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(addShoppingCart)).click();//Urun, "Add To Shopping Cart" butonuyla sepete eklendi

        for (int i = 0; i < 5; i++) {//Donguyle urun sayisi5 arttirildi
            clickPlus.click();
        }
        String strAmount = amount.getText();//Urun miktari string formatinda alindi.
        int intAmount = Integer.parseInt(strAmount);//string olan urun miktari int'e donusturuldu.
        System.out.println("intAmount = " + intAmount);//Miktar konsolda yazdirildi

        clickMinus.click();//Urun sayisi 1 azaltildi.
        System.out.println("Guncelleme sonrasi miktar = " + intAmount);

//Bu kontrolde; int urun miktari 1'e esit oldugu durumda urun miktarinin degistirilmedigi varsayilarak
// testin fail olacagi kabul edilmistir. Sepetteki urun miktari sayisi 1 harici ise
// sepette degisiklik yapildigi icin test pass olarak sonuclanmistir.
        if (intAmount == 1) {
            Assert.fail();
        }
    }
    public void refreshInCart(){
        addShoppingCart.click();//Urun sepete eklendi
        actions.sendKeys(Keys.ESCAPE).perform();//Urun detayindan --> Bags kategorisinin genel gorundugu sayfaya geri donuldu.

        cart.click();//Sepete tiklandi
//span[@class='flex pb-0.5']

        WebDriverWait wait1=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(plusInCart)).click();//+ ifadesi gorunene kadar (max10sn bekle) ve artir komutudur.
        plusInCart.click();//2.defa miktar artirildi.

        String strAmountCart = cartAmount2.getText();//Urun miktari string formatinda alindi.
        int intAmountCart = Integer.parseInt(strAmountCart);//String olan urun miktari integer'a donusturuldu.
//Bu kontrolde; int urun miktari 1'e esit oldugu durumda urun miktarinin degistirilmedigi varsayilarak
// testin fail olacagi kabul edilmistir. Sepetteki urun miktari sayisi 1 harici ise
// sepette degisiklik yapildigi icin test pass olarak sonuclanmistir.

        if (intAmountCart == 1) {
            Assert.fail();
        }
    }
}