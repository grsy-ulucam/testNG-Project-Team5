package tests.Merve_4775_tests.US_20;

import org.testng.annotations.Test;
import tests.Merve_4775.ReusableMethods_4775Merve.Reusable;
import pages.US20_PickBazaar.AllCategories;
import utilities.BaseTestReport;
import utilities.Driver;

public class US20_TC02  {

    @Test
    public void test()  {
        Reusable.Login();
        Reusable.dailyNeeds();
        AllCategories ac = new AllCategories();
        ac.visibility();
        Driver.closeDriver();



    }
}
