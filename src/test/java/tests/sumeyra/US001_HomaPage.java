package tests.sumeyra;

import org.testng.annotations.Test;
import pages.US_01.TC_02;
import pages.US_01.TC_03;
import pages.US_01.TC_04;
import utilities.BaseTestReport;
import utilities.Driver;

public class US001_HomaPage extends BaseTestReport {


    @Test
    public void testcase03(){
        extentTest=extentReports.createTest("testcase03");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        TC_02 login=new TC_02();   //Satici siteye üyelik islemlerini gerceklestirir.
         login.loginBtn();
        TC_03 shops=new TC_03();// Satici  Shop Create eder.
         shops.setShops();
        TC_04 aktifKullamin=new TC_04();
        aktifKullamin.setProducts();  //Urunleri  filtreleyip urun secimi yapılabildimi


    }
}
