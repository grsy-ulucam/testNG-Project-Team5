package tests.Merve_4775_tests.ReusableMethods_4775Merve;

import pages.Login.CustomerLoginPage;
import pages.Login.SellerLoginPage;
import pages.US20_PickBazaar.MenulerSekmesi;
import pages.US21_PickBazaar.BlackRice;
import pages.US21_PickBazaar.FirstProduct;
import pages.US21_PickBazaar.SecondProduct;

public class Reusable {

    public static void Login (){
        CustomerLoginPage lp = new CustomerLoginPage() ;
        lp.customerLogin();

    }
    public static void sellerLogin(){
        SellerLoginPage lp = new SellerLoginPage();
        lp.logAsSeller();

    }


    public static void dailyNeeds(){
        MenulerSekmesi ms =new MenulerSekmesi();
        ms.DailyNeedsClisck();
    }

    public static void RiceClick(){
        FirstProduct fp = new FirstProduct();
        fp.firstClick();
        SecondProduct sc = new SecondProduct();
        sc.productClick();
        BlackRice br = new BlackRice();
        br.blackRiceClick();

    }

}
