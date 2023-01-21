package pages.Merve_4775.US21_PickBazaar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

public class BlackRicePrice {

    public BlackRicePrice() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[.='14%']")
    private WebElement percentage;

    @FindBy(xpath = "//ins[.='$2.99']")
    private WebElement discount;

    @FindBy(xpath = "//del[.='$3.49']")
    private WebElement price;

    public void blackRicePrice() {

        Assert.assertTrue(percentage.isDisplayed());

        Assert.assertTrue(discount.isDisplayed());

        Assert.assertTrue(price.isDisplayed());
    }
}
