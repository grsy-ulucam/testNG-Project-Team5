package pages.Merve_4775.US21_PickBazaar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

public class BlackRiceValue {

    public BlackRiceValue() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='2lb']")
    private WebElement unit;

    public void riceValue() {

        Assert.assertTrue(unit.isDisplayed());
    }
}
