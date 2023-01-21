package pages.Merve_4775.US01_HomePage_BecomeSeller_5_6;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductInformation {
    Faker faker = new Faker();
    public ProductInformation() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[.='Daily Needs']")
    private WebElement dailyNeeds;

    @FindBy(xpath = "//div[.='Makeup']")
    private WebElement makeUp;

    @FindBy(xpath = "//div[.='Blusher']")
    private WebElement blusher;

    @FindBy(xpath = "//div[.='Blusher']")
    private WebElement benjamin;

    @FindBy(xpath = "//div[.='Eko Shop']")
    private WebElement ekoShop;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "slug")
    private WebElement slug;

    @FindBy(id = "unit")
    private WebElement unit;

    @FindBy(id = "description")
    private WebElement description;

    @FindBy(xpath = "//label[text()='Draft']")
    private WebElement draft;

    @FindBy(id = "price")
    private WebElement price;

    @FindBy(id = "sale_price")
    private WebElement salePrice;

    @FindBy(id = "quantity")
    private WebElement quantity;

    @FindBy(id = "sku")
    private WebElement sku;

    @FindBy(id = "width")
    private WebElement width;

    @FindBy(id = "height")
    private WebElement height;

    @FindBy(id = "length")
    private WebElement length;

    @FindBy(id = "external_product_url")
    private WebElement url;

    @FindBy(id = "external_product_button_text")
    private WebElement urlText;

    @FindBy(xpath = "(//div/button)[4]")
    private WebElement updateProduct;

    @FindBy(xpath = "(//div/button)[3]")
    private WebElement back;

    @FindBy(xpath = "(//div/button)[5]")
    private WebElement firstDelete;

    @FindBy(xpath = "//button[.='Delete']")
    private WebElement secondDelete;

    public void product() throws InterruptedException {
        dailyNeeds.click();
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).
        //makeUp.click();
        //blusher.click();
        //benjamin.click();
        //ekoShop.click();
        sendKeys(Keys.BACK_SPACE+"team05").perform();
        //name.sendKeys("team05");
        //slug.sendKeys(faker.name().firstName());
        //unit.sendKeys(faker.name().title());
        //description.sendKeys(faker.expression("this is the description field in the product section"));
        //draft.click();
        //price.sendKeys("50");
        //salePrice.sendKeys("25");
        //quantity.sendKeys("30");
        //sku.sendKeys("200");
        //width.sendKeys("70");
        //height.sendKeys("170");
        //length.sendKeys("30");
        //url.sendKeys("team05.com");
        //url.sendKeys("05 text");
        //url.click();
        updateProduct.click();
        Thread.sleep(5000);
        back.click();
        firstDelete.click();
        secondDelete.click();
    }

















}
