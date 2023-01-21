package tests.Emine;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login.SellerLoginPage;
import pages.Emine.AuthorsPage;
import pages.Emine.ManufacturersPage;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;

public class US1_TestCase9_10 extends BaseTestReport {

    @Test
    public void Test01()  {
        extentTest = extentReports.createTest("US1_TC_09", "Kullanıcı manufacturers bölümünde ekleme işlemi yapabilmeli");
        //Kullanıcı  manufacturers/publications bölümüne tıklar.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        //Kullanıcı email adresi ve şifre bilgilerini girerek  satıcı olarak login olur.
        SellerLoginPage sp=new SellerLoginPage();
        sp.logAsSeller();
        //Kullanıcı  manufacturers/publications bölümüne tıklar.
        ManufacturersPage mp=new ManufacturersPage();
        mp.manufPubButton.click();
        //Kullanıcı açılan sayfada "add manufacturer-publications" bölümüne tıklar.
        mp.manufPubAddingButton.click();
        //Kullanıcı adını, websitesi bilgisini ve üretim ile ilgili tanımlama bilgilerini girer.
        String metin = "The Best Manufacturer...";
        mp.nameInfo.sendKeys(metin);
        Faker faker=new Faker();
        mp.websiteInfo.sendKeys(faker.internet().domainName());
        mp.descriptionInfo.sendKeys(faker.name().fullName());
        Actions act = new Actions(Driver.getDriver());
        //Kullanıcı "groups" başlığına tıklayarak ürünlerin ait olduğu gruplara ait seçimleri yapar.
        act.moveToElement(mp.categoryInfoBox).click().sendKeys("Grocery"+ Keys.ENTER).perform();
        //Kullanıcı add manufacturer/publication butonuna tıklar.
        mp.addManuBox.click();
        System.out.println("fistManuPubInfo = "+mp.firstManuPubInfo.getText());
        //Kullanıcı açılan sayfada  eklediği ürünü görüntüler.
        Assert.assertTrue(mp.firstManuPubInfo.getText().contains(metin));
        Assert.assertTrue(mp.approvalButton.isDisplayed());
        extentTest.pass("Manufacturer bölümünde eklenme yapıldığı doğrulandı");
        Driver.closeDriver();
    }

    @Test
    public void test02()  {
        extentTest = extentReports.createTest("US1_TC_10", "Kullanıcı authors bölümünde ekleme işlemi yapabilmeli");
        // Kullanıcı URL'ye gider.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        // Kullanıcı email adresi ve şifre bilgilerini girerek  satıcı olarak login olur.
        SellerLoginPage sp=new SellerLoginPage();
        sp.logAsSeller();
        AuthorsPage ap=new AuthorsPage();
        ap.yazarButon.click();
        //Kullanıcı add author bölümüne tıklar.
        ap.yazarEklemeButonu.click();
        // Yazarın isim bilgisi girilr.
        String yazar = "Cengiz Aytmatov";
        System.out.println(yazar);
        ap.yazarAdı.sendKeys(yazar);
        // Yazarın bildiği diller girilir.
        Faker faker=new Faker();
        ap.yazarHangiDilleriBilir.sendKeys(faker.name().bloodGroup());
        // Yazarın biyografi bilgisi girilir.
        ap.biyografi.sendKeys(faker.funnyName().name());
        // Yazarın kitaplarında alıntılar belirlenerek bu alıntıların bilgisi girilir.
        ap.alıntıKutusu.sendKeys(faker.funnyName().name());
        // Yazarın doğum ve ölüm tarihi bilgileri girilir.
        Actions act = new Actions(Driver.getDriver());
        act.moveToElement(ap.doğum).click().sendKeys(faker.date().birthday().toString()+Keys.ENTER).perform();
        act.moveToElement(ap.ölüm).click().sendKeys(faker.date().toString()+Keys.ENTER).perform();
        //Kullanıcı authors bölümüne tıklar.
        ap.bilgileriEkleButonu.click();
        System.out.println("fistManuPubInfo = "+ap.listedeIlkYazar.getText());
        //Kullanıcı sayfada yazarın eklendiğini görür
        Assert.assertTrue(ap.listedeIlkYazar.getText().contains(yazar));
        Assert.assertTrue(ap.approvalButton.isDisplayed());
        extentTest.pass("Authors bölümünde ekleme yapıldığı doğrulandı");
        Driver.closeDriver();

    }

    @Test
    public void test03() throws InterruptedException {
        extentTest = extentReports.createTest("US1_TC_10", "Kullanıcı uazar bölümünde düzenleme işlemlerini yapabilmelidir.");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        SellerLoginPage sp=new SellerLoginPage();
        sp.logAsSeller();
        AuthorsPage ap=new AuthorsPage();
        ap.yazarButon.click();
        wait.until(ExpectedConditions.visibilityOf(ap.düzenlemeButonu));
        ap.düzenlemeButonu.click();
        wait.until(ExpectedConditions.visibilityOf(ap.yazarAdı));
        String yazarNew = "Orhan Pamuk";
        ap.yazarAdı.sendKeys(yazarNew);
        ap.güncelleYazarı.click();
        ap.geriGel.click();
        wait.until(ExpectedConditions.visibilityOf(ap.listedeIlkYazar));
        System.out.println("fistManuPubInfo = "+ap.listedeIlkYazar.getText());
        Thread.sleep(3000);
        Assert.assertTrue(ap.listedeIlkYazar.getText().contains(yazarNew));
        extentTest.pass("Authors bölümünde düzenleme yapılabildiği doğrulandı");
        Driver.closeDriver();
    }

    @Test
    public void test04() throws InterruptedException {
        extentTest = extentReports.createTest("US1_TC_10", "Kullanıcı yazar silme işlemini yapabilmelidir.");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        SellerLoginPage sp=new SellerLoginPage();
        sp.logAsSeller();
        AuthorsPage ap=new AuthorsPage();
        ap.yazarButon.click();
        String ilkYazarAdı=ap.listedeIlkYazar.getText();
        ap.silme.click();
        ap.yazarSilSoru.click();
        wait.until(ExpectedConditions.elementToBeClickable(ap.approvalButton));
        Thread.sleep(3000);
        Assert.assertFalse(ap.listedeIlkYazar.getText().contains(ilkYazarAdı));
        extentTest.pass("Authors bölümünde yazar silinebildiği doğrulandı");
        Driver.closeDriver();
    }
}
