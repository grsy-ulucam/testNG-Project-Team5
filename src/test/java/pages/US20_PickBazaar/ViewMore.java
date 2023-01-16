package pages.US20_PickBazaar;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

public class ViewMore {
    public ViewMore() {
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

    public void viewMoree() throws InterruptedException {
        Actions actions =new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.moveToElement(vegetables).perform();
        Assert.assertTrue(vegetables.isDisplayed());
        Thread.sleep(5000);

    }
}
