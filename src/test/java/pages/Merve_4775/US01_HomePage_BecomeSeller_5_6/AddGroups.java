package pages.Merve_4775.US01_HomePage_BecomeSeller_5_6;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import java.awt.*;
import java.time.Duration;

public class AddGroups {
    public AddGroups() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    Actions actions = new Actions(Driver.getDriver());
    @FindBy(id = "name")
    private WebElement search;

    @FindBy(xpath = "//div[.='Select...']")
    private WebElement selectArea;

    @FindBy(xpath = "//span[.='Hand Bag']")
    private WebElement icon;

    @FindBy(xpath = "(//label/div)[1]")
    private WebElement classic;

    @FindBy(xpath = "(//label/div)[2]")
    private WebElement compact;

    @FindBy(xpath = "(//label/div)[3]")
    private WebElement minimal;

    @FindBy(xpath = "(//label/div)[4]")
    private WebElement modern;

    @FindBy(xpath = "(//label/div)[5]")
    private WebElement standart;

    @FindBy(xpath = "(//label/div)[6]")
    private WebElement helium;

    @FindBy(xpath = "(//label/div)[7]")
    private WebElement neon;

    @FindBy(xpath = "(//label/div)[8]")
    private WebElement argon;

    @FindBy(xpath = "(//label/div)[9]")
    private WebElement krypton;

    @FindBy(xpath = "(//label/div)[10]")
    private WebElement xenon;

    @FindBy(xpath = "(//label/div)[11]")
    private WebElement radon;

    @FindBy(xpath = "(//div/button)[2]")
    private WebElement addBanner;

    @FindBy(id = "banners.0.title")
    private WebElement tittleAdd;

    @FindBy(id = "banners.0.description")
    private WebElement descriptionAdd;

    @FindBy(xpath = "(//p/span)[1]")
    private WebElement image;

    @FindBy(xpath = "(//div/button)[4]")
    private WebElement addGroup;





    public void name() throws InterruptedException, AWTException {
        Faker faker = new Faker();
        search.sendKeys(faker.name().firstName());
        selectArea.click();
        icon.click();
        classic.click();
        compact.click();
        minimal.click();
        modern.click();
        standart.click();
        helium.click();
        neon.click();
        argon.click();
        krypton.click();
        xenon.click();
        radon.click();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addBanner)).click();
        tittleAdd.sendKeys(faker.name().title());
        descriptionAdd.sendKeys(faker.expression("this is the description field in the group section"));
        addGroup.click();





       //image.click();
       //image.sendKeys("src/test/java/pages/homepageClass/imagee/yanaşma.jpg");
       //Robot robot = new Robot();
       //robot.keyPress(KeyEvent.VK_CONTROL);// tuşa basılı tutarak ctrl ye bastık
       //robot.keyPress(KeyEvent.VK_S);// S tuşuna basılı tuttuk her ikisine basılı tutma komutu ile kaydettik
       //Thread.sleep(3000);
       //robot.keyRelease(KeyEvent.VK_CONTROL);// Controlu serbest bıraktık
       //robot.keyRelease(KeyEvent.VK_S);// S den elimizi kaldırdık
       //Thread.sleep(3000);
       //robot.keyPress(KeyEvent.VK_ENTER);// ENterladık
       //robot.keyRelease(KeyEvent.VK_ENTER);// EnTEr tuşundan elimizi çektik bıraktık






       // actions.sendKeys(Keys.TAB);
       // actions.sendKeys(Keys.TAB);
       // actions.sendKeys(Keys.TAB);
       // actions.sendKeys(Keys.ENTER);
        //JavascriptExecutor jse1 = (JavascriptExecutor)Driver.getDriver();
        //jse1.executeScript("arguments[0].click();",deleteSecond);
        //deleteSecond.click();

        //actions.sendKeys(Keys.ESCAPE);
        //actions.sendKeys(Keys.ESCAPE);





       //Thread.sleep(4000);
       //robot.keyPress(KeyEvent.VK_LEFT);
       //robot.keyPress(KeyEvent.VK_ENTER);
       //Thread.sleep(4000);
       //robot.keyRelease(KeyEvent.VK_LEFT);
       //robot.keyRelease(KeyEvent.VK_ENTER);




    }

}
