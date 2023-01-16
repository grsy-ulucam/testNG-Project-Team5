package pages.US20_PickBazaar;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;

public class AllCategories  {
    public AllCategories() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "h3")
    private WebElement vegetables;

    @FindBy(tagName = "h3")
    private WebElement snacks;

    @FindBy(tagName = "h3")
    private WebElement ricePulse;

    @FindBy(tagName = "h3")
    private WebElement meat;

    @FindBy(tagName = "h3")
    private WebElement fruits;

    @FindBy(tagName = "h3")
    private WebElement fish;

    @FindBy(tagName = "h3")
    private WebElement dairyEggs;

    @FindBy(tagName = "h3")
    private WebElement bakery;



    public void visibility(){
        vegetables.isDisplayed();
        snacks.isDisplayed();
        ricePulse.isDisplayed();
        meat.isDisplayed();
        fruits.isDisplayed();
        fish.isDisplayed();
        dairyEggs.isDisplayed();
        bakery.isDisplayed();
    }

}
