package tests.gursoy.US_06;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.Login.CustomerLoginPage;
import pages.gursoyPages.US06.HomePageJoin;
import pages.gursoyPages.US06.LoginClassPage;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;

public class testCaseValid extends BaseTestReport {

   /*
1-Kullanıcı url gıder
2-Kullanıcı joine  tıklar
3-Kullanıcı çıkan ekranda email adresine içinde en az bir tane @ işareti olan email adresini girer.
4-Ayrıca email adresi türkçe karakterler (ç,ğ vs) içermemelidir.
5-Password kısmına en az 8 karakterli bir şifre girmelidir
6-Kullanıcı daha sonra pages.Login butonuna  tıklar ve login olur
 */
   @Test
   public  void valid(){//geçerli email ve şifre ile giriş

      extentTest = extentReports.createTest("valid");
      Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
      LoginClassPage cc=new LoginClassPage();
      cc.loginPrivate();
      HomePageJoin jj=new HomePageJoin();
      jj.validEmail();

      Driver.closeDriver();

   }



}
