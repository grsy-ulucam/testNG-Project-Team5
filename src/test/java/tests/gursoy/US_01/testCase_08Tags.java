package tests.gursoy.US_01;

import org.testng.annotations.Test;
import pages.Login.SellerLoginPage;
import pages.gursoyPages.US01.HomePageBecomeSeller;
import utilities.BaseTestReport;
import utilities.Driver;

public class testCase_08Tags extends BaseTestReport {

    /*
1-Kullanıcı satıcı url gıder
2-Kullanıcı sayfaya login ve Tagse tıklar
3-Kullanıcı açılan sayfada gerekli özellilkeri doldurarak + Add Tags  tıklar
4-Kullanıcı açılan sayfada gerekli özellilkeri doldurarak Add Categoriese  tıklar
5-Kullanıcı açılan sayfada eklediği Tags görmeli ve düzenleyebilmelidir
6-Kullanıcı düzenlediği Tagsleri silebilmelidir çıkan ekranda delete yapabilmelidir.
     */

    @Test
    public void testCaseTags() {

        extentTest = extentReports.createTest("testCaseTags");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        SellerLoginPage sp=new SellerLoginPage();
        sp.logAsSeller();
        HomePageBecomeSeller hp=new HomePageBecomeSeller();
        hp.setTags();
        Driver.closeDriver();

    }
}
