package tests.Merve_4775_tests.US01.US1_TC05;

import org.testng.annotations.Test;
import pages.Login.SellerLoginPage;
import pages.US01_HomePage_BecomeSeller_5_6.ProductEdit;
import pages.US01_HomePage_BecomeSeller_5_6.ProductInformation;
import utilities.BaseTestReport;
import utilities.Driver;

import java.awt.*;

public class SellerLoginProduct {


    @Test
    public void test() throws InterruptedException, AWTException {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app");
        SellerLoginPage sl = new SellerLoginPage();
        sl.logAsSeller();
        ProductEdit pe = new ProductEdit();
        pe.productEdit();
        ProductInformation pi = new ProductInformation();
        pi.product();
        Driver.closeDriver();



    }
}
