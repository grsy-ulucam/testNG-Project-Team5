package pages.Emine;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePageAll {
    public HomePageAll() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(className = "whitespace-nowrap")
    public WebElement categoryDropDownButton;
    @FindBy(xpath = "//span[text()='Daily Needs']")
    public WebElement dailyNeedsButton;
    @FindBy(xpath="//h1[.='You Deserve To Eat Fresh']")
    public WebElement dNText;
    @FindBy(xpath="(//span[@class='text-sm font-semibold text-heading ltr:ml-3 rtl:mr-3'])[1]")
    public WebElement theFirstOption;
    @FindBy(xpath="//h3[.='No products found']")
    public WebElement noProductsText;
    @FindBy(id = "search")
    public WebElement searchArea;
    @FindBy(xpath = "//span[text()='Bags']")
    public WebElement bagsButton;

    @FindBy(xpath="//div[@class='mb-3 w-full lg:mb-0 lg:max-w-[400px]']")
    public WebElement AddtoShoppingButton;
    @FindBy(xpath="//span[text()='Cart']")
    public WebElement cartButton;

    @FindBy(xpath = "//span[@class='flex ltr:ml-2 rtl:mr-2']")
    public WebElement itemCartButton;

    @FindBy(xpath = "//section[@class='relative flex h-full flex-col']")
    public WebElement TextInChart;
    @FindBy(xpath = "(//h3[@class='mb-2 truncate text-sm font-semibold text-heading'])[1]")
    public WebElement thefirstItem;
    @FindBy(xpath = "//h3[@class='mb-2 truncate text-sm font-semibold text-heading']")
    public List<WebElement> theBagItems;

    @FindBy (xpath = "//div[@class='mt-6 flex flex-col items-center md:mt-6 lg:flex-row']")
    public WebElement textStock;
    @FindBy(xpath = "(//span[text()='plus'])[3]")
    public WebElement artırmaButton;

    @FindBy(xpath = "(//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold'])[2]")
    public WebElement eklenenmiktar;

    @FindBy(xpath = "(//span[text()='plus'])[2]")
    public WebElement plusButtonofChart;

    @FindBy(xpath = "(//span[text()='minus'])[2]")
    public WebElement minusButtonofChart;

    @FindBy(xpath = "(//span[text()='close'])[2]")
    public WebElement productDeletingButton;
    @FindBy(tagName = "//h4[@class='mt-6 text-base font-semibold']")
    public WebElement noProductFoundTextoftheChart;

    @FindBy(xpath = "//header[@class='relative p-3 md:p-5 md:py-6']")
    public List<WebElement> allTextoftheAllBags;

    @FindBy (xpath = "//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold !px-0 text-heading']")
    public WebElement theNumberofProductsintheChart;

    @FindBy(xpath = "//p[@class='my-2.5 font-semibold text-accent']")
    public WebElement priceOfProductintheChart;

    @FindBy(xpath = "//span[@class='font-bold text-heading ltr:ml-auto rtl:mr-auto']")
    public WebElement totalPriceOfProductintheChart;
}
