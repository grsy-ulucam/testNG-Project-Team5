package pages.US_01;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
  //satici product(urun) arayabilmeli, arama yaparkende filtre kullanabilmelidir//
// -Kullanıcı shop a gelip active etmelidir.
//Kullanıcı Productsa tıklar.
// Filter By Group ta seçim yapar.
//Kullanıcı Filter By Category gelip seçim yapar.

public class TC_04 {
    public TC_04() {
        PageFactory.initElements(Driver.getDriver(),this);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }
    @FindBy(xpath = "(//div/span)[3]")// Shop active edildi
    WebElement inactive;
    @FindBy(linkText = "Products")  // products locate alindi
    private WebElement products;

    @FindBy(xpath = "//button[text()='Filter']")    //Filtre locate
    private WebElement  filtre;
    @FindBy(xpath = "//*[contains(text(),'No data found')]")   // No data found locate
    private WebElement  productsList;




    public void setProducts(){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        inactive.click();                                                                                        // inactive aktif edildi.
        wait.until(ExpectedConditions.visibilityOf(products)).click();                          // Urun arama click.
        filtre.click();                                                                                               // Filtreleme click.
        Assert.assertTrue(productsList.getText().contains("Data found"));           //Urun filtreleme  yapilinca urunler cikmadi.
    }

}
