package tests.Emine;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Emine.HomePageAll;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;

public class US19 extends BaseTestReport{

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("US19_TC_01", "Aranan ürün varsa, arama yapılan keyword listelenen ürünlerde bulunmalıdır.");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //1-Kullanıcı URL ye gider.
       Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
       HomePageAll hp=new HomePageAll();
       //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();
       //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden DAİLYNEEDS sekmesine tıklar
       hp.dailyNeedsButton.click();
       wait.until(ExpectedConditions.visibilityOf(hp.dNText));
       //4-Kullanıcı SEARCH(Arama) bölmesine sayfada bulunan ürünlerden birini yazar
        String metin="coca cola";
        hp.searchArea.sendKeys(metin+Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(hp.theFirstOption));
      //5-Kullanıcı aradığı ürünün SEARCH bölmesinden aşağı doğru uzanan sekmede bulunduğunu görür
        System.out.println("theFirstOption.getText() = " + hp.theFirstOption.getText());
        Assert.assertTrue(hp.theFirstOption.getText().toLowerCase().contains(metin.toLowerCase()));
        extentTest.pass("Arama yapılan Keyword'ün Listede olduğu doğrulandı.");
        Driver.closeDriver();

    }

    @Test
    public void test02() {
        extentTest = extentReports.createTest("US19_TC_02", "Aranan ürün yoksa, aranan keyword listelenen ürünlerde bulunmamalıdır.");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePageAll hp=new HomePageAll();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden DAİLYNEEDS sekmesine tıklar
        hp.dailyNeedsButton.click();
        wait.until(ExpectedConditions.visibilityOf(hp.dNText));
        //4-Kullanıcı SEARCH(Arama) bölmesine sayfada bulunmayan ürünlerden birini yazar
        String metin="ayran";
        hp.searchArea.sendKeys(metin+Keys.ENTER);
        wait.withTimeout(Duration.ofSeconds(3));
        //5-Kullanıcı  SEARCH bölmesinden aşağı doğru uzanan sekmede "No Product Found" yazısını aradığı ürünün sayfada bulunmadığını görür
        System.out.println("theFirstOption.getText() = " + hp.noProductsText.getText());
        Assert.assertTrue(hp.noProductsText.getText().contains("No products found"));
        extentTest.pass("Arama yapılan Keyword'ün Listede olmadığı doğrulandı.");
        Driver.closeDriver();
    }
}
