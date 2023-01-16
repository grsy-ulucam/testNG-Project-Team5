package pages.Sumeyra.US003_Faq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;
import java.time.Duration;

                 // 1-Kullanıcı URL ye gider.
                 // 2-Kullanıcı FAQ sayfasında 4 soru ve 4 cevap olduğunu görür.
                //3-Kullanıcı + sembolüne bastığında -sembolüne dönüştüğünü ve sorunun cevabını  görür.
public class FaqPage {
    public FaqPage() {
          PageFactory.initElements(Driver.getDriver(),this);}

                     WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    public void fagPage(){
        //FAQ Elementinin looate  bulunup tiklaniyor
        WebElement faq = Driver.getDriver().findElement(By.linkText("FAQ"));
        faq.click();
    }
       public void setAnswerOne() {
            // 1. sorunun  cevabi gorunuyor mu kontrol ediliyor
       WebElement answerOne = Driver.getDriver().findElement(By.xpath("//*[contains(text(),'need not to wait too')]"));
      Assert.assertTrue(answerOne.getText().contains("Our Customer Experience"));

        // 2 sorunun locate bulunup tiklaniyor
      WebElement questionsTwo=Driver.getDriver().findElement(By.xpath("//*[contains(text(),'App installation ')]"));
        questionsTwo.click();

        // 2. sorunun cevabi gorunuyor mu kontrol ediliyor
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[contains(text(),'Please read the')]")).getText().contains("Please read the documentation carefully" ));

        // 3 sorunun locate bulunup tiklaniyor
        WebElement questionThree=Driver.getDriver().findElement(By.xpath("//*[contains(text(),'Website response taking time')]"));
          questionThree.click();

          // 3. sorunun cevabi gorunuyor mu kontrol ediliyor
       Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[contains(text(),'At first, Please check your internet connection .')]")).isDisplayed());

          // 4. sorunun locate bulunup tiklaniyor
          WebElement questionFour=Driver.getDriver().findElement(By.xpath("//*[contains(text(),'How do I create a account?')]"));
        questionFour.click();

          // 4. sorunun cevabi gorunuyor mu kontrol ediliyor
          Assert.assertTrue( Driver.getDriver().findElement(By.xpath("//*[contains(text(),'If you want to open an account')]")).isDisplayed());
    }
    }



