package pages.Emine;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AuthorsPage {
    public AuthorsPage(){
        PageFactory.initElements(Driver.getDriver(), this);}
    @FindBy(linkText = "Authors")
    public WebElement yazarButon;
    @FindBy(partialLinkText = "Add Author")
    public WebElement yazarEklemeButonu;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement yazarAdı;
    @FindBy(xpath = "//input[@id='languages']")
    public WebElement yazarHangiDilleriBilir;
    @FindBy(xpath = "//textarea[@id='bio']")
    public WebElement biyografi;
    @FindBy(xpath = "//textarea[@id='quote']")
    public WebElement alıntıKutusu;
    @FindBy(xpath = "(//div[@class='react-datepicker-wrapper'])[1]")
    public WebElement doğum;
    @FindBy(xpath = "(//div[@class='react-datepicker-wrapper'])[2]")
    public WebElement ölüm;
    @FindBy(xpath = "//button[text()='Add Author']")
    public WebElement bilgileriEkleButonu;

    @FindBy(xpath = "//button[text()='Update Author']")
    public WebElement güncelleYazarı ;
    @FindBy(xpath = "//button[text()='Back']")
    public WebElement geriGel;
    @FindBy(xpath = "(//tr[@class='rc-table-row rc-table-row-level-0'])[1]")
    public WebElement listedeIlkYazar;

    @FindBy(xpath = "(//a[@class='text-base transition duration-200 hover:text-heading'])[1]")
    public WebElement düzenlemeButonu;
    @FindBy(xpath = "(//button[@class='text-red-500 transition duration-200 hover:text-red-600 focus:outline-none'])[1]")
    public WebElement silme;
    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement yazarSilSoru;
    @FindBy(xpath = "(//button[@class='bg-accent relative inline-flex h-6 w-11 items-center rounded-full focus:outline-none'])[1]")
    public WebElement approvalButton;
}
