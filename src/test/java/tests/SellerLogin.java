package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.SellerLoginPage;

import java.awt.*;
import java.time.Duration;

public class SellerLogin {



    @Test
    public void test() throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://shop-pickbazar-rest.vercel.app/");

        SellerLoginPage sellLog=new SellerLoginPage(driver);


        sellLog.logAsSeller();



    }
}
