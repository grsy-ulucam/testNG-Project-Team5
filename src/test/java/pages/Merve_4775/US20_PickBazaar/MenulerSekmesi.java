package pages.Merve_4775.US20_PickBazaar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseTestReport;
import utilities.Driver;

public class MenulerSekmesi extends BaseTestReport {

    public MenulerSekmesi() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "whitespace-nowrap")
    private WebElement grocery;

    @FindBy(partialLinkText = "Daily Needs")
    private WebElement dailyNeeds;


    public void DailyNeedsClisck(){
        grocery.click();
        dailyNeeds.click();
    }







}
