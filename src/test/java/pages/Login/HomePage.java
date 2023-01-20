package pages.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseTestReport;
import utilities.Driver;

public class HomePage extends BaseTestReport {

    public HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    //Homepage locators
    @FindBy(linkText = "Shops")
    public WebElement shops;
    @FindBy(linkText = "Offers")
    public WebElement offers;
    @FindBy(linkText = "FAQ")
    public WebElement faq;
    @FindBy(linkText = "Contact")
    public WebElement contact;
    @FindBy(xpath = "//img[@alt='user name']")
    public WebElement profilImage;
    @FindBy(id = "headlessui-menu-button-1")
    public WebElement menu;
    @FindBy(linkText = "Grocery")
    public WebElement grocery;
    @FindBy(linkText = "Bakery")
    public WebElement bakery;
    @FindBy(linkText = "Makeup")
    public WebElement makeup;
    @FindBy(linkText = "Bags")
    public WebElement bags;
    @FindBy(linkText = "Clothing")
    public WebElement clothing;
    @FindBy(linkText = "Furniture")
    public WebElement furniture;
    @FindBy(linkText = "Daily Needs")
    public WebElement dailyNeeds;
    @FindBy(linkText = "Books")
    public WebElement books;
    @FindBy(id = "search")
    public WebElement search;
    @FindBy(xpath = "//button[text()='Profile']")
    public WebElement profile;
    @FindBy(xpath = "//button[text()='Checkout']")
    public WebElement checkout;
    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logout;

    //Profil sayfası locators
    @FindBy(linkText = "Change Password")
    public WebElement changePassword;
    @FindBy(linkText = "My Orders")
    public WebElement myOrders;
    @FindBy(linkText = "Downloads")
    public WebElement downloads;
    @FindBy(linkText = "My Whishlists")
    public WebElement myWhishlists;
    @FindBy(linkText = "My Questions")
    public WebElement myQuestions;
    @FindBy(linkText = "My Refunds")
    public WebElement myRefunds;
    @FindBy(linkText = "My Cards")
    public WebElement myCards;
    @FindBy(linkText = "Need Help")
    public WebElement needHelp;
    @FindBy(xpath = "//button[text()='Load More']")
    public WebElement loadMore;


}
