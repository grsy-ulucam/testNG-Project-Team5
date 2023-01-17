package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login.CustomerLoginPage;
import pages.homepageClass.HomepageClass;

import utilities.Driver;

import java.time.Duration;

public class US__013 {

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().quit();
    }

    WebDriverWait wait;

    public void waitt(){

       wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    }


     //1-Kullanıcı URL gider
     //2-Kullanıcı olarak giriş yapar.
     //3-Kullanıcı checkout a tıklar.
     //4-Kullanıcı checkout sayfasına yönlendirilir.


       @BeforeMethod
      public void login(){

    CustomerLoginPage lp = new CustomerLoginPage();
    lp.customerLogin();

}

    @Test
    public void checkoutclick() {

        HomepageClass hm = new HomepageClass();
        hm.monsterBtn();

        waitt();

        wait.until(ExpectedConditions.urlToBe("https://shop-pickbazar-rest.vercel.app/checkout"));

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://shop-pickbazar-rest.vercel.app/checkout");

    }

          // 1-Kullanıcı URL gider.
          // 2-Kullanıcı olarak giriş yapar.
          // 3-Kullanıcı ürünü arar ve ürünü checkout a ekler.
          // 3-Kullanıcı checkout a gider.
          // 4-Kullanıcı aldığı ürünleri görür.
          // 5-Kullanıcı ödeyeceği tutarı görür.



}
