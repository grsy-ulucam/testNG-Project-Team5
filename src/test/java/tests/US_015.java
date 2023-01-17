package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Login.CustomerLoginPage;
import pages.US15_Bags.Bags;
import pages.US20_PickBazaar.MenulerSekmesi;
import utilities.Driver;

import java.time.Duration;

public class US_015 {
    @AfterMethod
    public void tearDown() {
//        Driver.getDriver().quit();
    }

    @Test
    public void test01() throws InterruptedException {
/*  TestCase01 --> Kullanici urunu favorilere ekleyebilmelidir

1-Kullanıcı, müşteri sayfası URL’sine gıder
2-Kullanıcı, sayfaya müşteri statüsünde login olur ve Categories tıklar.
3-Kullanıcı, açılan sayfada Bags’e tıklar ve sonra sayfaya refresh yapılmalıdır.
4-Kullanıcı, açılan sayfada herhangi bir ürüne tıklar ve detayına ulaşır.
5-Kullanıcı, açılan ürün detayı sayfasında kalp ikonuna tıklar ve ürün favorilere eklenir.

*/
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");//siteye gidildi
        CustomerLoginPage cLP = new CustomerLoginPage();//customer login icin obje uretildi
        cLP.customerLogin();//musteri olarak login olundu.

        Bags bags = new Bags();
        MenulerSekmesi mS=new MenulerSekmesi();
        mS.bagsClick();

//        Select select = new Select(dropDown);
//        select.selectByVisibleText("Bags");

        Driver.getDriver().navigate().refresh();

        Actions actions = new Actions(Driver.getDriver());
//       actions.keyDown(Keys.ESCAPE).perform();
//       actions.keyUp(Keys.ESCAPE).perform();

        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();


        Thread.sleep(1500);//Tedibren beklendi
        WebElement urunMJacobs = Driver.getDriver().findElement(By.xpath("//h3[text()='The Marc Jacobs']"));
        urunMJacobs.click();
        Thread.sleep(2000);//Tedibren beklendi
        WebElement heart = Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[5]"));
        heart.click();
        WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));//Tedbiren eklendi.

        actions.sendKeys(Keys.ESCAPE).perform();

        WebElement mWish1 = Driver.getDriver().findElement(By.xpath("//img[@alt='user name']"));
        mWish1.click();

        WebElement mWish2 = Driver.getDriver().findElement(By.xpath("//button[text()='My Wishlists']"));
        mWish2.click();
        WebElement urunMJacobs2 = Driver.getDriver().findElement(By.xpath("//a[text()='The Marc Jacobs']"));
        Assert.assertTrue(urunMJacobs2.isDisplayed());
    }
}
