package tests.gursoy.US_04;

import org.testng.annotations.Test;
import pages.Login.CustomerLoginPage;
import pages.gursoyPages.US04.HomePageOffers;
import utilities.BaseTestReport;
import utilities.Driver;

public class testCaseOffers extends BaseTestReport {

    /*
1-Kullanıcı  url gıder
2-Kullanıcı sayfaya join butonuna tıklar ve login olur
3-Kullanıcı açılan sayfada shops butonuna tıklar .
4-Kullanıcı açılan sayfadan All Shops seçeceneklerinden birini seçer.
5-Kullanıcı açılan sayfadan herhangi bir ürün seçer ve sapete ekler
6-Kullanıcı offers seçeneğine tıklar ve çıkan sayfada kuponlardan birini kopyalar sepete tıklar ve çıkan ekranda kuponu ekler
7-Kulllanıcı sipariş ver seçeneğini tıklayıp ödeme yaparak alışverişi tamamlar.
     */

    @Test
    public void coupon() {

        extentTest = extentReports.createTest("coupon");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        CustomerLoginPage cl = new CustomerLoginPage();
        cl.customerLogin();
        HomePageOffers cp = new HomePageOffers();
        cp.couponProcess();
        Driver.closeDriver();
    }

}