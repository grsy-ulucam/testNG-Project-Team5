package pages.Merve_4775.US22_PickBazaar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class PriceMinus {

    public PriceMinus() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div/button)[12]")
    private WebElement minus;

    public void minuss() {

        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOf(minus)).click();
    }
}
