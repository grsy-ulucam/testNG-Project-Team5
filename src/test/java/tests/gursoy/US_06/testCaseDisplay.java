package tests.gursoy.US_06;

import org.testng.annotations.Test;
import pages.Login.CustomerLoginPage;
import pages.gursoyPages.US06.HomePageJoin;
import pages.gursoyPages.US06.LoginClassPage;
import utilities.BaseTestReport;
import utilities.Driver;

public class testCaseDisplay extends BaseTestReport {

/*
1-Kullanıcı URL gıder
2-Kuıllanıcı joine tıklar .
3-Kullanıcı açılan sayfada kullanıcı 4 seçeneğin aktif olduğunu görür .
 */
    @Test
    public  void display(){

        extentTest = extentReports.createTest("display");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        LoginClassPage ll=new LoginClassPage();
        ll.loginPrivate();
        HomePageJoin hm=new HomePageJoin();
        hm.isDisplayed();
        Driver.closeDriver();

    }







}
