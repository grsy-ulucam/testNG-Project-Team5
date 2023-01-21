package tests.Baran.US_07;

import Login.CustomerLoginPage;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.baran.US_07.ProfileUpdate;
import utilities.BaseTestReport;
import utilities.Driver;

public class US07_HomaPage_JoinProfil extends BaseTestReport {


    @Test
    public void testCase1(ITestContext context) {

        extentTest = extentReports.createTest("testCase1");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        CustomerLoginPage prof = new CustomerLoginPage();
        prof.customerLogin();
        ProfileUpdate profUpd = new ProfileUpdate();
        profUpd.profileUpdate();
        Driver.closeDriver();
    }

    @Test
    public void testCase2(ITestContext context) {
        extentTest = extentReports.createTest("testCase222222");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        CustomerLoginPage prof = new CustomerLoginPage();
        prof.customerLogin();
        ProfileUpdate profUpd = new ProfileUpdate();
        profUpd.passwordUpdate();
        Driver.closeDriver();
    }

    @Test
    public void testCase3() {
        extentTest = extentReports.createTest("testCase3");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        CustomerLoginPage prof = new CustomerLoginPage();
        prof.customerLogin();

        ProfileUpdate orders = new ProfileUpdate();
        orders.orderCheck();
        Driver.closeDriver();
    }

    @Test
    public void testCase4() {
        extentTest = extentReports.createTest("testCase4");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        CustomerLoginPage prof = new CustomerLoginPage();
        prof.customerLogin();

        ProfileUpdate wishlists = new ProfileUpdate();
        wishlists.wishlistsCheck();
        Driver.closeDriver();
    }

    @Test
    public void testCase5(){
        extentTest = extentReports.createTest("testCase4");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        CustomerLoginPage prof = new CustomerLoginPage();
        prof.customerLogin();

        ProfileUpdate logout=new ProfileUpdate();
        logout.logoutCheck();
        Driver.closeDriver();
    }

}
