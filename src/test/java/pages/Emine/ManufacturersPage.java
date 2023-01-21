package pages.Emine;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ManufacturersPage {
    public ManufacturersPage(){
        PageFactory.initElements(Driver.getDriver(), this);}
    @FindBy(linkText = "Manufacturers/Publications")
    public WebElement manufPubButton;

    @FindBy(partialLinkText = "Add Manufacturer/Publication")
    public WebElement manufPubAddingButton;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameInfo;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement descriptionInfo;

    @FindBy(xpath = "//input[@id='website']")
    public WebElement websiteInfo;
    @FindBy(xpath = "//div[@id='react-select-2-placeholder']")
    public WebElement categoryInfoBox;

    @FindBy(xpath = "//button[text()='Add Manufacturer/Publication']")
    public WebElement addManuBox;

    @FindBy(xpath = "(//tr[@class='rc-table-row rc-table-row-level-0'])[1]")
    public WebElement firstManuPubInfo;

    @FindBy(xpath = "(//button[@class='bg-accent relative inline-flex h-6 w-11 items-center rounded-full focus:outline-none'])[1]")
    public WebElement approvalButton;


}
