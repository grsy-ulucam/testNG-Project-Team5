package pages.gursoyPages.US01;

import org.bouncycastle.cert.ocsp.jcajce.JcaBasicOCSPRespBuilder;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;

public class HomePageBecomeSeller extends BaseTestReport {
    public HomePageBecomeSeller() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Categories
    @FindBy(xpath = "//span[.='Categories']")
    WebElement Categories;

    @FindBy(xpath = "//span[@class='fcv'] ")
    WebElement AddCategory;

    @FindBy(xpath = "//span[@class='hidden md:block xl:hidden']")
    WebElement Add;

    @FindBy(xpath = "//input[@id='name']")
    WebElement Name;

    @FindBy(id = "react-select-3-input")
    WebElement Types;


    @FindBy(xpath = "//td[.='yun']")
    WebElement yun;


    @FindBy(xpath = "(//a[@class='text-base transition duration-200 hover:text-heading'])[1]")
    WebElement edit;

    @FindBy(id = "//textarea[@id='details']")
    WebElement Details;

    @FindBy(linkText = "first product")
    WebElement getEdit2;

    @FindBy(xpath = "//button[.='Delete']")
    WebElement delete;

    @FindBy(xpath = "//button[.='Update Category']")
    WebElement updateCategory;

    //Tags

    @FindBy(linkText = "Tags")
    WebElement Tags;

    @FindBy(xpath = "(//div[.='Add Tag'])[1]")
    WebElement AddTag;

    @FindBy(linkText = "kazak")
    WebElement Kazak;

    @FindBy(xpath = "//button[.='Update Tag']")
    WebElement UpdateTags;

    @FindBy(xpath = "//button[.='Back']")
    WebElement Backbutonu;

    @FindBy(className = "css-ackcql")
    WebElement SelectIcon;

    @FindBy(xpath = "//button[.='Update Tag']")
    WebElement UpdateTag;

    @FindBy(xpath = "//td[@title='kazak-2']")
    WebElement ChangeKazak;

    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    public void setCategories() {
        Categories.click();
        wait.until(ExpectedConditions.elementToBeClickable(AddCategory));
        AddCategory.click();
        Name.sendKeys("yun" + Keys.ENTER);
        Select dryTypes = new Select(Types);
        dryTypes.selectByVisibleText("Clothing");
        AddCategory.click();
        String value = yun.getText();
        Assert.assertEquals(value, "yun");
        actions.moveToElement(edit).perform();
        edit.click();
        Details.sendKeys("first product" + Keys.ENTER);
        updateCategory.click();
        Backbutonu.click();
        String editValue = getEdit2.getText();
        Assert.assertEquals(editValue, "first product");
        delete.click();

    }

    public void setTags() {
        wait.until(ExpectedConditions.elementToBeClickable(Tags));
        actions.moveToElement(Tags).perform();
        Tags.click();
        actions.moveToElement(AddTag).perform();
        AddTag.click();
        Name.sendKeys("kazak" + Keys.ENTER);
        Select dryTypes = new Select(Types);
        dryTypes.selectByVisibleText("Clothing");
        AddTag.click();
        String value = Kazak.getText();
        Assert.assertEquals(value, "kazak");
        actions.moveToElement(edit).perform();
        edit.click();
        Details.sendKeys("first product" + Keys.ENTER);
        UpdateTag.click();
        Backbutonu.click();
        String editValue = getEdit2.getText();
        Assert.assertEquals(editValue, "first product");
        delete.click();

    }
}
