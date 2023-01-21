package tests.Merve_4775_tests.US_22;

import org.testng.annotations.Test;
import tests.Merve_4775.ReusableMethods_4775Merve.Reusable;
import pages.US21_PickBazaar.*;
import pages.US22_PickBazaar.PricePlus;
import utilities.BaseTestReport;
import utilities.Driver;

public class US22_TC01 extends BaseTestReport {


    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("test()");
        Reusable.Login();
        Reusable.dailyNeeds();
        Reusable.RiceClick();
        RiceInformations ri = new RiceInformations();
        ri.riceInformation();
        PricePlus pp = new PricePlus();
        pp.plusAdd();
        Driver.closeDriver();



    }
}
