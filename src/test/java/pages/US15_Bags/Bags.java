package pages.US15_Bags;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Bags {

    public Bags() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
/*ORNEKTIR
    @FindBy(className ="whitespace-nowrap")
    private WebElement dropDown;
*/

}

