package tests.gursoy.US_05;

import org.testng.annotations.Test;
import pages.Login.CustomerLoginPage;
import pages.gursoyPages.US05.HomePageShops;
import utilities.BaseTestReport;
import utilities.Driver;

public class testCaseShopsDo extends BaseTestReport {


    @Test
    public void testCaseShopsDo() {

        /*
 1-Kullanıcı  url gıder
2-Kullanıcı sayfaya join butonuna tıklar ve login olur
3-Kullanıcı Shop seçeneğini tıklar ve açılan sayfada alışveriş seçeneklerinin herhangi birine tıklayıp ,gelen ürünü seçebilmelidir.
4-Kullanıcı alışveriş sepetinde eklediği ürünü görebilmelidir ve eklediği üründe miktar değişikliği yapabilmelidir.
5-Kullanıcı yaptığı değişikliğin sonucunu total fiyatta görebilmelidir.

         */

        extentTest = extentReports.createTest("testcaseShopsDo");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        CustomerLoginPage cc=new CustomerLoginPage();
        cc.customerLogin();
        HomePageShops hs=new HomePageShops();
        hs.shopsDo();
        Driver.closeDriver();



    }




}
