package tests.gursoy.US_01;

import org.testng.annotations.Test;
import pages.Login.SellerLoginPage;
import pages.gursoyPages.US01.HomePageBecomeSeller;
import utilities.BaseTestReport;
import utilities.Driver;

public class testCase_07Categories extends BaseTestReport {

    /*
1-Kullanıcı satıcı url gıder
2-Kullanıcı sayfaya login ve Categoriese tıklar
3-Kullanıcı açılan sayfada tıklar
4-Kullanıcı açılan sayfada + Add Categoriese  tıklar
5-Kullanıcı açılan sayfada gerekli özellilkeri doldurarak Add Categoriese  tıklar
6-Kullanıcı açılan sayfada eklediği categoriyi görmeli ve düzenleyebilmelidir
7--Kullanıcı düzenleme yaptığı categoriyi silebilmelidir.

     */

    @Test
    public void testCategories() {

        extentTest = extentReports.createTest("testCaseCategories");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        SellerLoginPage sp = new SellerLoginPage();
        sp.logAsSeller();
        HomePageBecomeSeller ss = new HomePageBecomeSeller();
        ss.setCategories();
        Driver.closeDriver();

    }
}
