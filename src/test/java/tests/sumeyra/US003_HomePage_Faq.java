package tests.sumeyra;



import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Login.CustomerLoginPage;
import pages.Sumeyra.US003_Faq.FaqPage;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;
/*
   1-Kullanıcı URL ye gider.
2-Kullanıcı FAQ sayfasında 4 soru ve 4 cevap olduğunu görür.
3-Kullanıcı + sembolüne bastığında -sembolüne dönüştüğünü ve sorunun cevabını  görür.

    */
public class US003_HomePage_Faq extends BaseTestReport {

    @Test
    public void case1() throws InterruptedException {
        extentTest=extentReports.createTest("case1");
        CustomerLoginPage login=new CustomerLoginPage();
        login.customerLogin();
        FaqPage faQestions=new FaqPage();
        faQestions.fagPage();//faqPage methodu cagrildi
        faQestions.setAnswerOne();//setAnswerOne methodu cagrildi




    }

}
