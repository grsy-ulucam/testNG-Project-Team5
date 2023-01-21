package tests.Merve_4775_tests.US_21;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import tests.Merve_4775.ReusableMethods_4775Merve.Reusable;
import pages.US21_PickBazaar.RiceInformations;
import utilities.BaseTestReport;
import utilities.Driver;

public class US21_TC04 extends BaseTestReport {

    public US21_TC04() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("test()");
        Reusable.Login();
        Reusable.dailyNeeds();
        Reusable.RiceClick();
        RiceInformations ri = new RiceInformations();
        ri.riceInformation();
        Driver.closeDriver();




    }
}
