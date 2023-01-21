package pages.Merve_4775.US21_PickBazaar;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;

public class BlackRice extends BaseTestReport {
    public BlackRice() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//img[@alt='Natural Black Rice 2lb']")
    private WebElement blackrice;


    @FindBy(xpath = "//h1[.='Natural Black Rice 2lb']")
    private WebElement firstBlackRiceClick;

    public void blackRiceClick() {
        blackrice.click();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstBlackRiceClick)).click();



    }
}






