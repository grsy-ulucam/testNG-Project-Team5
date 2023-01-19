package pages.US15_16_Bags;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Bags {

    public Bags() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//h3[@role='button'])[1])")//!!! Bu locator'un arama sonucu 1/1 olmasina ragmen
    // bu WebElement'e erisim saglanamamistir. Bu nedenle Bug kaydi olusturulmustur.
    public WebElement armaniLeatherPurse;

    @FindBy(xpath = "(//h3[@role='button'])[2])")//!!! Bu locator'un arama sonucu 1/1 olmasina ragmen
    // bu WebElement'e erisim saglanamamistir. Bu nedenle Bug kaydi olusturulmustur.
    public WebElement armaniPurse;

    @FindBy(xpath = "(//h3[@role='button'])[3])")//!!! Bu locator'un arama sonucu 1/1 olmasina ragmen
    // bu WebElement'e erisim saglanamamistir. Bu nedenle Bug kaydi olusturulmustur.
    public WebElement givenchyPurse;

    @FindBy(xpath = "(//h3[@role='button'])[4])")//!!! Bu locator'un arama sonucu 1/1 olmasina ragmen
    // bu WebElement'e erisim saglanamamistir. Bu nedenle Bug kaydi olusturulmustur.
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

    @FindBy(xpath = "//span[@class='flex ltr:ml-2 rtl:mr-2']")
    public WebElement cart;//Sag kenarda kucuk kulakcik gibi gorunen Sepet'in locate'dir.

    @FindBy(xpath = "(//span[text()='Add To Shopping Cart'])[2]")
    public WebElement addShoppingCart;//urun detay sayfasindaki "Sepete Ekle" butonunun locate'dir.

    @FindBy(xpath = "(//button[@class='cursor-pointer p-2 transition-colors duration-200 hover:bg-accent-hover focus:outline-none px-5'])[4]")
    public WebElement clickPlus;//Sepete eklenen urunde + veya - isaretiyle islem yapilabileceginden arti butonunun locator'u alindi.

    @FindBy(xpath = "//span[text()='Checkout']")
    public WebElement checkout;//Cart icinden ulasilan Checkout butonu locati'dir.

    @FindBy(xpath = "//span[@class='text-sm font-bold text-heading']")
    public WebElement cartAmount;//Urunun sepete eklenen adet bilgisinin Checkout sayfasindaki locate'dir.

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

}