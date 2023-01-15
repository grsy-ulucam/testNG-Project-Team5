package tests;

import org.testng.annotations.Test;
import pages.SellerLoginPage;
import utilities.Driver;

public class SellerLoginPageClass {


    @Test
    public void test() {

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        SellerLoginPage sellLog=new SellerLoginPage();

        sellLog.logAsSeller();



    }
}
