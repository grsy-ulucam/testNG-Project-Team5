package pages.US_19;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(className = "whitespace-nowrap")
    public WebElement categoryDropDownButton;
    @FindBy(xpath = "//span[text()='Daily Needs']")
    public WebElement dailyNeedsButton;


}
