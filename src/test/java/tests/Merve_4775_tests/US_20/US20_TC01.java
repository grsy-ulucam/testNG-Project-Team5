package tests.Merve_4775_tests.US_20;
import org.testng.annotations.Test;
import tests.Merve_4775.ReusableMethods_4775Merve.Reusable;
import utilities.BaseTestReport;


public class US20_TC01 extends BaseTestReport {
    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("test()");
        Reusable.Login();
        Reusable.dailyNeeds();
    }


}
