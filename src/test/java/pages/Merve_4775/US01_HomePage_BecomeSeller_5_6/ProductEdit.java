package pages.Merve_4775.US01_HomePage_BecomeSeller_5_6;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductEdit {


    public ProductEdit() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Products")
    private WebElement productsClick;

    @FindBy(xpath = "(//div/a)[25]")
    private WebElement editClick;


    public void productEdit(){
        productsClick.click();
        editClick.click();
    }


}
