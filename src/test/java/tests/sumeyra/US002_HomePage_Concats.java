package tests.sumeyra;


import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.Sumeyra.US002_Concats.ConcatsPage;

import utilities.BaseTestReport;
import utilities.Driver;

/*
1-Kullanıcı URL ye gider.              *                                          (PASSED)
2-Kullanıcı Concat a gider.             *                                      (PASSED)
3-Adress bilgilerini görür.                *                                  (PASSED)
4-Kullanıcı phone bilgilerini  görür.     *                           (PASSED)
5-Kullanıcı Websitesi bilgilerini  görür.*                          (PASSED)
6-Kullanıcı sosyal medya hesaplarına erişebilir.  *     (PASSED)
7-Kullanıcı  "Qestions, Comments, Or Concerns?"  bölümünü aktif kullanabilir.   (PASSED)
8-Kullanıcı geçersiz email girdiğinde uyarıyı görebilir.                            (PASSED)
9-Kullanıcı gerekli alanı boş bıraktığında uyarıyı görebilir.                  (PASSED)
10-Kullanıcı Descreption bölümde sınırlandırmayla karşılaşıyor.                  (FAİL)

 */
public class US002_HomePage_Concats extends BaseTestReport {

    // CONCAT Sayfasinda iletisimbilgilerinin gorunurlugu kontrol edildi  PASSED
    @Test
    public  void case01() {
        extentTest=extentReports.createTest("case01");           // 1den 7 ye kadar tum caseler
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        ConcatsPage concats = new ConcatsPage();  //ConcatsPage sayfasindan obje uretildi.
        concats.contactPage();//contactPage methodu cagrildi.
        concats.contactPageIletisimBilgileri();
        Driver.closeDriver();

    }

    //- Kullanıcı  "Qestions, Comments, Or Concerns?"  bölümünü aktif kullanabilir.  PASSED
    @Test
    public void case07() throws InterruptedException {
        extentTest=extentReports.createTest("case07");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        ConcatsPage concats = new ConcatsPage();
        concats.contactPage();
        concats.concatsBoxContol();
        Driver.closeDriver();
    }

    //Kullanıcı geçersiz email girdiğinde uyarıyı görebilir. PASSED
    @Test
    public void case08() throws InterruptedException {
        extentTest=extentReports.createTest("case08");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        ConcatsPage concats = new ConcatsPage();
        concats.contactPage();
        concats.hataliEmail();
        Driver.closeDriver();
    }

    //Kullanıcı gerekli alanı boş bıraktığında uyarıyı görebilir.
    @Test
    public void case09() throws InterruptedException {
        extentTest=extentReports.createTest("case09");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        ConcatsPage concats = new ConcatsPage();
        concats.contactPage();
        concats.bosBox();
        Driver.closeDriver();
    }

    //Kullanıcı Descreption bölümde sınırlandırmayla karşılaşıyor.  FAIL
    @Test
    public void case10(ITestContext context) throws InterruptedException {
        extentTest=extentReports.createTest("case10");
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        ConcatsPage concats = new ConcatsPage();
        concats.contactPage();
        concats.descriptionBoxContol();
        Driver.closeDriver();

    }
}
