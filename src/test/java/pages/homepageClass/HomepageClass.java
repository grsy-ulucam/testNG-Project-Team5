package pages.homepageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseTestReport;
import utilities.Driver;

public class HomepageClass extends BaseTestReport {

    public HomepageClass() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//img[@alt='user name']")
    private WebElement monsterLoctr;

    @FindBy(xpath = "//*[contains(text(),'Checkout')]")
    private WebElement checkoutLoctr;


    public void monsterBtn()  { //login olunca sağ üstteki canavar :)

        monsterLoctr.click(); //canavara tıklayınca açılan sekme

        checkoutLoctr.click(); //checkout linki

    }












}
