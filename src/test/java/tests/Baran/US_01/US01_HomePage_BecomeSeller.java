package tests.Baran.US_01;

import Login.SellerLoginPage;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.baran.US_01.*;
import utilities.BaseTestReport;
import utilities.Driver;

import java.awt.*;

public class US01_HomePage_BecomeSeller extends BaseTestReport {

    @Test
    public void sellerRegisterTest() {
        extentTest = extentReports.createTest("sellerRegisterTest");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        BecomeSeller bs = new BecomeSeller();
        bs.sellerRegister();
        Driver.closeDriver();
    }


    @Test()
    public void usersTest(ITestContext context) throws InterruptedException, AWTException {
        extentTest = extentReports.createTest("usersTest");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        SellerLoginPage slp = new SellerLoginPage();
        slp.logAsSeller();
        Users users = new Users();
        users.permissionTest();
        users.walletPointsTest();
        users.statusTest();
        Driver.closeDriver();

    }

    @Test()
    public void couponTest() throws InterruptedException {
        extentTest = extentReports.createTest("couponTest");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        SellerLoginPage slp = new SellerLoginPage();
        slp.logAsSeller();
        Coupons coupons = new Coupons();
        coupons.couponTest();
        Driver.closeDriver();
    }


@Test
    public void usersAddCustomer(){
    extentTest = extentReports.createTest("createShopTest");
    Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
    SellerLoginPage slp = new SellerLoginPage();
    slp.logAsSeller();

    Users us=new Users();
    us.addCustomerTest();
}

@Test
    public void taxesTest() {
    extentTest = extentReports.createTest("taxesTest");
    Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
    SellerLoginPage slp = new SellerLoginPage();
    slp.logAsSeller();
    Taxes tx=new Taxes();
    tx.editTax();
    Driver.closeDriver();

}
}
