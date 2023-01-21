package tests.Merve_4775_tests.US_20;

import org.testng.annotations.Test;
import pages.US20_PickBazaar.AllCategories;
import tests.Merve_4775.ReusableMethods_4775Merve.Reusable;
import pages.US20_PickBazaar.ViewMore;
import utilities.BaseTestReport;
import utilities.Driver;

public class US20_TC03 extends BaseTestReport {


    @Test
    public void test() throws InterruptedException {
        Reusable.Login();
        Reusable.dailyNeeds();
        AllCategories ac=new AllCategories();
        ac.visibility();
        ViewMore vm=new ViewMore();
        vm.viewMoree();

    }
}
