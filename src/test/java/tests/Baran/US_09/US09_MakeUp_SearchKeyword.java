package tests.Baran.US_09;

import org.testng.annotations.Test;
import pages.baran.US_09.MakeUp;
import utilities.BaseTestReport;
import utilities.Driver;

public class US09_MakeUp_SearchKeyword extends BaseTestReport {

    @Test
    public void searchKeywordTest(){
        extentTest=extentReports.createTest("searchKeywordTest");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        MakeUp control=new MakeUp();
        control.searchKeyword();
        Driver.closeDriver();
    }
}
