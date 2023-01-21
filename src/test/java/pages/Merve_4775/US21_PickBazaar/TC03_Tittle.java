package pages.Merve_4775.US21_PickBazaar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

public class TC03_Tittle {

    public TC03_Tittle() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div/h1")
    private WebElement tittle;

    public void tittle(){
        Assert.assertTrue(tittle.isDisplayed());
    }
}
