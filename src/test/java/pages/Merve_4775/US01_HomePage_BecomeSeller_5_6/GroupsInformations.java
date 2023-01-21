package pages.Merve_4775.US01_HomePage_BecomeSeller_5_6;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GroupsInformations {

    public GroupsInformations() {
        PageFactory.initElements(Driver.getDriver(), this);


    }

    @FindBy(linkText = "Groups")
    private WebElement groupsClick;

    @FindBy(partialLinkText = "Add Group")
    private WebElement groupsAdd;

    public void informations(){
        groupsClick.click();
        groupsAdd.click();
    }

}
