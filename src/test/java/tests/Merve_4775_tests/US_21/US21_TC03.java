package tests.Merve_4775_tests.US_21;

import org.testng.annotations.Test;
import tests.Merve_4775.ReusableMethods_4775Merve.Reusable;
import pages.US21_PickBazaar.*;
import utilities.BaseTestReport;
import utilities.Driver;

public class US21_TC03 extends BaseTestReport {


    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("test()");
        Reusable.Login();
        Reusable.dailyNeeds();
        Reusable.RiceClick();
        TC03_Tittle tt = new TC03_Tittle();
        tt.tittle();
        Driver.closeDriver();


    }
}
