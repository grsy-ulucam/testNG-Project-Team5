package tests.Merve_4775_tests.US_21;

import org.testng.annotations.Test;
import tests.Merve_4775.ReusableMethods_4775Merve.Reusable;
import pages.US21_PickBazaar.*;
import utilities.BaseTestReport;
import utilities.Driver;

public class US21_TC01 extends BaseTestReport {


    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("test()");
        Reusable.Login();
        Reusable.dailyNeeds();
        Reusable.RiceClick();
        BlackRicePrice rp = new BlackRicePrice();
        rp.blackRicePrice();
        Driver.closeDriver();





    }
}
