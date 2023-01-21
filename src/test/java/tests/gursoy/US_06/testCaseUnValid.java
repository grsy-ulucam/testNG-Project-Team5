package tests.gursoy.US_06;

import org.testng.annotations.Test;
import pages.gursoyPages.US06.HomePageJoin;
import pages.gursoyPages.US06.LoginClassPage;
import utilities.BaseTestReport;
import utilities.Driver;

public class testCaseUnValid extends BaseTestReport {

  /*
1_Kullanıcı url gider
2-Kullanıcı joine veya   tıklar
3-Kullanıcı çıkan ekranda email adresine içinde en az bir tane @ işareti olmayan email adresini girer.
4-Ayrıca email adresi türkçe karakterler (ç,ğ vs) içermelidir.
5-Satıcı çıkan ekranda pages.Login butonuna tıklar ve giriş yapamaz
   */


    @Test
    public  void unValid1(){//geçersiz email ile giriş yapılmaması @ işareti olmadan giriş

        extentTest = extentReports.createTest("unValid1");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        LoginClassPage cc=new LoginClassPage();
        cc.loginPrivate();
        HomePageJoin jj=new HomePageJoin();
        jj.unValidEmail1();
       // Driver.closeDriver();

    }
    @Test
    public  void unValid2(){//geçersiz password en az 8 karakter olması

        extentTest = extentReports.createTest("unValid2");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        LoginClassPage cc=new LoginClassPage();
        cc.loginPrivate();
        HomePageJoin jj=new HomePageJoin();
        jj.unValidEmail2();
        Driver.closeDriver();
    }
    @Test
    public  void unValid3(){// ç,ğ gibi Türkçe karakterler girilmesi

        extentTest = extentReports.createTest("unValid3");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        LoginClassPage cc=new LoginClassPage();
        cc.loginPrivate();
        HomePageJoin jj=new HomePageJoin();
        jj.unValidEmail2();
        Driver.closeDriver();

    }

}
