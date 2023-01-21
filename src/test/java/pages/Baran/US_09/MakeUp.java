package pages.Baran.US_09;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeUp extends BaseTestReport {

    public MakeUp() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    @FindBy(id = "headlessui-menu-button-1")
    WebElement menu;

    @FindBy(linkText = "Makeup")
    WebElement makeup;

    @FindBy(id = "search")
    WebElement searchBar;

    @FindBy(xpath = "//article[@class]")
    List<WebElement> result;

    @FindBy(xpath = "//li[.='Face']")
    WebElement face;

    @FindBy(xpath = "//button[.='close']")
    WebElement close;


    List<String> product = new ArrayList<>(Arrays.asList("Foundation", "Powder", "Mascara", "Blusher", "Eyeshadow", "Glitter"));

    public void searchKeyword() {
        menu.click();
        makeup.click();
        wait.until(ExpectedConditions.visibilityOf(face));
        SoftAssert soft = new SoftAssert();
        for (String w : product) {
            searchBar.sendKeys(w + Keys.ENTER);
            close.click();
            for (int i = 0; i < result.size(); i++) {
               // System.out.println(result.get(i).getText());
                while (true) {
                    soft.assertTrue(result.get(i).getText().contains(w));
                    break;
                }
            }
        }
    }
}
