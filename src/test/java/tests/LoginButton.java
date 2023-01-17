package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.US20_PickBazaar.AllCategories;
import pages.Login.CustomerLoginPage;
import pages.US20_PickBazaar.MenulerSekmesi;
import pages.US20_PickBazaar.ViewMore;
import utilities.Driver;


public class LoginButton  {



    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app");
        CustomerLoginPage lp=new CustomerLoginPage();
        lp.customerLogin();
        MenulerSekmesi ms=new MenulerSekmesi();
        ms.DailyNeedsClisck();
        AllCategories ac=new AllCategories();
        Actions actions=new Actions(Driver.getDriver());
        ac.visibility();
        ViewMore vm=new ViewMore();
        vm.viewMoree();




    }
}
