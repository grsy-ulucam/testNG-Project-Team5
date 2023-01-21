package pages.Merve_4775.US21_PickBazaar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class SecondProduct {
    public SecondProduct() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div/h3)[2]")
    private WebElement rice;

   // @FindBy(xpath = "(//button/span)[25]")
    //private WebElement reduce;

    public void productClick()  {
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(rice).perform();

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(rice)).click();
        //blackrice.click();


    }

    }

