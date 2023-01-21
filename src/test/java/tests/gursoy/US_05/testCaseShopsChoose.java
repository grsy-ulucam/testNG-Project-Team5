package tests.gursoy.US_05;

import org.testng.ITestResult;
import org.testng.annotations.Test;
import pages.Login.CustomerLoginPage;
import pages.gursoyPages.US05.HomePageShops;
import utilities.BaseTestReport;
import utilities.Driver;

public class testCaseShopsChoose extends BaseTestReport {

/*
1-Kullanıcı  url gıder
2-Kullanıcı sayfaya join butonuna tıklar ve login olur
3-Kullanıcı açılan sayfada Shops butonuna tıklar ve açılan sayfada All Shops altındaki 7 tane shops alışveriş seçeneğini görür .
4-Kullanıcı herhangi bir alışveriş seçeniğine tıklar.
5-Kullanıcı açılan her sayfada ilgili bölümün adres ve phone bilgierini  görebilmelidir ve  Visit This Site butonunu görebilmedir.
6_İlgili shopsa ait website gidebilmelidir.
 */

    @Test
    public  void testCaseShopsChoose(){

        extentTest = extentReports.createTest("testcaseShopsChoose");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        CustomerLoginPage cc=new CustomerLoginPage();
        cc.customerLogin();
        HomePageShops hs=new HomePageShops();
        hs.shops();
        Driver.closeDriver();

    }
}
