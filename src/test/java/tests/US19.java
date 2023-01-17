package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_19.HomePage;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;
import java.util.Locale;

public class US19 {

    @Test
    public void test01() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //1-Kullanıcı URL ye gider.
       Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
       HomePage hp=new HomePage();
       //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();
       //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden DAİLYNEEDS sekmesine tıklar
       hp.dailyNeedsButton.click();
       WebElement dNText = Driver.getDriver().findElement(By.xpath("//h1[.='You Deserve To Eat Fresh']"));
       wait.until(ExpectedConditions.visibilityOf(dNText));
       //4-Kullanıcı SEARCH(Arama) bölmesine sayfada bulunan ürünlerden birini yazar
        WebElement searchArea=Driver.getDriver().findElement(By.id("search"));
        String metin="coca cola";
        searchArea.sendKeys(metin+Keys.ENTER);
      //5-Kullanıcı aradığı ürünün SEARCH bölmesinden aşağı doğru uzanan sekmede bulunduğunu görür
        WebElement theFirstOption=Driver.getDriver().findElement(By.xpath("(//span[@class='text-sm font-semibold text-heading ltr:ml-3 rtl:mr-3'])[1]"));
        System.out.println("theFirstOption.getText() = " + theFirstOption.getText());
        Assert.assertTrue(theFirstOption.getText().toLowerCase().contains(metin.toLowerCase()));
        Driver.closeDriver();
    }

    @Test
    public void test02() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePage hp=new HomePage();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden DAİLYNEEDS sekmesine tıklar
        hp.dailyNeedsButton.click();
        WebElement dNText = Driver.getDriver().findElement(By.xpath("//h1[.='You Deserve To Eat Fresh']"));
        wait.until(ExpectedConditions.visibilityOf(dNText));
        //4-Kullanıcı SEARCH(Arama) bölmesine sayfada bulunmayan ürünlerden birini yazar
        WebElement searchArea=Driver.getDriver().findElement(By.id("search"));
        String metin="ayran";
        searchArea.sendKeys(metin+Keys.ENTER);
        //5-Kullanıcı  SEARCH bölmesinden aşağı doğru uzanan sekmede "No Product Found" yazısını aradığı ürünün sayfada bulunmadığını görür
        WebElement noProductsText=Driver.getDriver().findElement(By.xpath("//h3[.='No products found']"));
        System.out.println("theFirstOption.getText() = " + noProductsText.getText());
        Assert.assertTrue(noProductsText.getText().contains("No products found"));
        Driver.closeDriver();

    }
}
