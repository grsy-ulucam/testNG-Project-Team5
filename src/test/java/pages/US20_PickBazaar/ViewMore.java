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

    @FindBy(xpath = "(//button[.='View More'])[1]")
    private WebElement vegetables;

    @FindBy(xpath = "(//button[.='View More'])[2]")
    private WebElement snacks;

    @FindBy(xpath = "(//button[.='View More'])[3]")
    private WebElement ricePulse;

    @FindBy(xpath = "(//button[.='View More'])[4]")
    private WebElement meat;

    @FindBy(xpath = "(//button[.='View More'])[5]")
    private WebElement fruits;

    @FindBy(xpath = "(//button[.='View More'])[6]")
    private WebElement fish;

    @FindBy(xpath = "(//button[.='View More'])[7]")
    private WebElement dairyEggs;

    @FindBy(xpath = "(//button[.='View More'])[8]")
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
        actions.moveToElement(snacks).perform();
        Assert.assertTrue(snacks.isDisplayed());

        actions.moveToElement(ricePulse).perform();
        Assert.assertTrue(ricePulse.isDisplayed());

        actions.moveToElement(meat).perform();
        Assert.assertTrue(meat.isDisplayed());

        actions.moveToElement(fruits).perform();
        Assert.assertTrue(fruits.isDisplayed());

        actions.moveToElement(fish).perform();
        Assert.assertTrue(fish.isDisplayed());

        actions.moveToElement(dairyEggs).perform();
        Assert.assertTrue(dairyEggs.isDisplayed());

        actions.moveToElement(bakery).perform();
        Assert.assertTrue(bakery.isDisplayed());



    }
}
