package tests.Merve_4775_tests.US01.US1_TC06;

import org.testng.annotations.Test;
import pages.Login.SellerLoginPage;
import pages.US01_HomePage_BecomeSeller_5_6.AddGroups;
import pages.US01_HomePage_BecomeSeller_5_6.GroupsInformations;
import utilities.BaseTestReport;
import utilities.Driver;

import java.awt.*;

public class SellerLoginGroups extends BaseTestReport {


    @Test
    public void test() throws InterruptedException, AWTException {
        extentTest=extentReports.createTest("test()");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app");
        SellerLoginPage sl = new SellerLoginPage();
        sl.logAsSeller();
        GroupsInformations inf = new GroupsInformations();
        inf.informations();
        AddGroups ag =new AddGroups();
        ag.name();





    }
}
