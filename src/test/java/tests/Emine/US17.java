package tests.Emine;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Emine.HomePageAll;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;

public class US17 extends BaseTestReport {
    @Test
    public void test01() {
        extentTest = extentReports.createTest("US17_TC_01", "Kulanıcı ürünü sepete ekleyebilmeli.");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePageAll hp=new HomePageAll();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden BAGS sekmesine tıklar
        hp.bagsButton.click();
        //4-Kullanıcı Ürünler görünene kadar sayfayı aşağı indirir
        Actions act=new Actions(Driver.getDriver());
        act.moveToElement(hp.thefirstItem).perform();
        String theFirstItemText=hp.thefirstItem.getText();
        System.out.println(theFirstItemText);
        wait.until(ExpectedConditions.elementToBeClickable(hp.thefirstItem));
        hp.thefirstItem.click();
        extentTest.info("Kullanıcı Bags kategorisinde listeden gelen ilk ürünü alır.");
       // 5-Kullanıcı çıkan ilk ürünün sağ altında bulunan CART butonuna tıklar ve ürünü sepete ekler
        hp.AddtoShoppingButton.click();
        act.sendKeys(Keys.ESCAPE).perform();
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        hp.itemCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(hp.TextInChart));
        //7-Kullanıcı Seçtiği ürünün sepete eklenmiş olduğunu görür
        System.out.println("hp.theFirstItemintheChart.getText() = " + hp.TextInChart.getText());
        Assert.assertTrue(hp.TextInChart.getText().contains(theFirstItemText));
        extentTest.pass("Sepete ürünün eklendiği doğrulandı");
        Driver.closeDriver();
    }

    @Test
    public void Test02()  {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        extentTest = extentReports.createTest("US17_TC_02", "Kullanıcı stockta olmayan ürünü listeye ekleyememeli");
        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePageAll hp=new HomePageAll();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden BAGS sekmesine tıklar
        hp.bagsButton.click();
        //4-Kullanıcı Ürünler görünene kadar sayfayı aşağı indirir
        Actions act=new Actions(Driver.getDriver());
        act.moveToElement(hp.thefirstItem).perform();
        System.out.println("theFirstBag.getText() = " + hp.thefirstItem.getText());
        String theFirstItemText=hp.thefirstItem.getText();
        hp.thefirstItem.click();
        // 5-Kullanıcı çıkan ilk ürünün sağ altında bulunan CART butonuna tıklar ve ürünü sepete ekler
        hp.AddtoShoppingButton.click();
        act.sendKeys(Keys.ESCAPE).perform();
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        hp.itemCartButton.click();
        //7-Kullanıcı Seçtiği ürünün sepete eklenmemiş olduğunu görür
        System.out.println("hp.theFirstItemintheChart.getText() = " + hp.TextInChart.getText());
        Assert.assertFalse(hp.TextInChart.getText().contains(theFirstItemText));
        extentTest.fail("Stoğu bitmiş olan ürün eklenememesi gerekirken sepete eklendi");
        Driver.closeDriver();
    }

    @Test
    public void test03() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        extentTest = extentReports.createTest("US17_TC_03", "Kullanıcı ürün stoğundan fazla ekleme yapamamalı");
        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePageAll hp=new HomePageAll();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden BAGS sekmesine tıklar
        hp.bagsButton.click();

        //4-Kullanıcı Ürünler görünene kadar sayfayı aşağı indirir
        Actions act=new Actions(Driver.getDriver());
        act.moveToElement(hp.thefirstItem).perform();
        //5-Kullanıcı çıkan  ilk stoğu bitmemiş ürünün üzerine tıklar.
        //6-Kullanıcı "Add To Shoping Cart" yazılı yeşil butona tıklar.
        //7-Kullanıcı "+" butonunun sağ tarafında bulunan ürün stoğundan daha çok olacak şekilde "+" butonuna tıklar.
        for (int i=5; i<hp.theBagItems.size(); i++ ){
            hp.theBagItems.get(i).click();
            if(hp.textStock.getText().contains("available")){
                hp.AddtoShoppingButton.click();
                wait.until(ExpectedConditions.visibilityOf(hp.artırmaButton));
                for( int k=1; k<50; k++){
                    act.moveToElement(hp.artırmaButton).click().perform();
                }
              break;
            }
            act.sendKeys(Keys.ESCAPE).perform();
        }
        //8-Kullanıcı eklenen ürün adedinin, stok adedini geçmediğini görür.
        System.out.println(hp.eklenenmiktar);
        System.out.println("hp.textStock = " + hp.textStock);
        Assert.assertTrue(hp.textStock.getText().contains(hp.eklenenmiktar.getText()));
        extentTest.pass("Stok adedinden fazla ürünün eklenemediği doğrulandı");
        Driver.closeDriver();
    }

    @Test
    public void test04()  {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        extentTest = extentReports.createTest("US17_TC_04", "Kullanıcı sepetinden ürün çıkarabilmeli.");
      // 1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePageAll hp=new HomePageAll();
      // 2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();
      // 3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden BAGS sekmesine tıklar
        hp.bagsButton.click();
        wait.until(ExpectedConditions.visibilityOf(hp.thefirstItem));
      // 4-Kullanıcı Ürünler görünene kadar sayfayı aşağı indirir
        Actions act=new Actions(Driver.getDriver());
        act.moveToElement(hp.thefirstItem).perform();
      // 5-Kullanıcı çıkan ilk stoğu bitmemiş ürünün sağ altında bulunan CART butonuna tıklar ve ürünü sepete ekler
        hp.cartButton.click();
      // 6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        hp.itemCartButton.click();
       wait.until(ExpectedConditions.visibilityOf(hp.productDeletingButton));
      // 8-Kullanıcı sağ tarafta bulunan "X" butonuna tıklar
        Actions actions =new Actions(Driver.getDriver());
        actions.moveToElement(hp.productDeletingButton).click().perform();
        wait.until(ExpectedConditions.visibilityOf(hp.TextInChart));
      // 9-Kullanıcı ürünün sepetten çıkarıldığını görür, eğer sepette başka ürün de yoksa "No products found" yazısını ve sepetin boş olduğunu görür
        System.out.println("hp.TextInChart.getText() = " + hp.TextInChart.getText());
        Assert.assertTrue(hp.TextInChart.getText().contains("No products found"));
        extentTest.pass("Sepetten ürünün çıkartıldığı doğrulandı.");
        Driver.closeDriver();
    }

    @Test
    public void test05()  {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        extentTest = extentReports.createTest("US17_TC_05", "Kullanıcı sepetinde ürün miktarını arttırabilmeli");
       //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePageAll hp=new HomePageAll();
       //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();
       //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden BAGS sekmesine tıklar
        hp.bagsButton.click();
       //4-Kullanıcı Ürünler görünene kadar sayfayı aşağı indirir
        Actions act=new Actions(Driver.getDriver());
        act.moveToElement(hp.thefirstItem).perform();
        System.out.println("hp.thefirstItem.getText() = " + hp.thefirstItem.getText());
        //5-Kullanıcı çıkan ilk stoğu bitmemiş ürünün sağ altında bulunan CART butonuna tıklar ve ürünü sepete ekler
       for(WebElement p: hp.allTextoftheAllBags){
           if(p.getText().contains("Cart")) {
               hp.cartButton.click();
               break;
           }
       }
        wait.withTimeout(Duration.ofSeconds(3));
       //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        hp.itemCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(hp.theNumberofProductsintheChart));
        int theInitialNumberofProductsintheChart= Integer.parseInt(hp.theNumberofProductsintheChart.getText());
        System.out.println("theInitialNumberofProductsintheChart = " + theInitialNumberofProductsintheChart);
        //7-Kullanıcı sepetin sol üstünde bulunan "+" butonuna tıklar ve adet sayısının 1 adet daha arttırır
        act.moveToElement(hp.plusButtonofChart).click().perform();
        int theFinalNumberofProductsintheChart= Integer.parseInt(hp.theNumberofProductsintheChart.getText());
        System.out.println("theFinalNumberofProductsintheChart = " + theFinalNumberofProductsintheChart);
        //8-Kullanıcı ürün sayısının 1 adet arttığını görür
        Assert.assertTrue(theFinalNumberofProductsintheChart>theInitialNumberofProductsintheChart);
        extentTest.pass("Sepetteki ürün adedinin arttırıldığı doğrulandı.");
        Driver.closeDriver();
    }
    @Test
    public void test06()  {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        extentTest = extentReports.createTest("US17_TC_06", "Kullanıcı sepetinde ürün miktarını azaltabilmeli");
        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePageAll hp=new HomePageAll();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden BAGS sekmesine tıklar
        hp.bagsButton.click();
        //4-Kullanıcı Ürünler görünene kadar sayfayı aşağı indirir
        Actions act=new Actions(Driver.getDriver());
        act.moveToElement(hp.thefirstItem).perform();
        System.out.println("hp.thefirstItem.getText() = " + hp.thefirstItem.getText());
        //5-Kullanıcı çıkan ilk stoğu bitmemiş ürünün sağ altında bulunan CART butonuna tıklar ve ürünü sepete ekler
        for(WebElement p: hp.allTextoftheAllBags){
            if(p.getText().contains("Cart")) {
                hp.cartButton.click();
                break;
            }
        }
        wait.withTimeout(Duration.ofSeconds(3));
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        hp.itemCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(hp.plusButtonofChart));
        //7-Kullanıcı sepetin sol üstünde bulunan "+" butonuna tıklar ve adet sayısının 1 adet arttırır
        act.moveToElement(hp.plusButtonofChart).click().perform();
        int theInitialNumberofProductsintheChart= Integer.parseInt(hp.theNumberofProductsintheChart.getText());
        System.out.println("theInitialNumberofProductsintheChart = " + theInitialNumberofProductsintheChart);
        wait.until(ExpectedConditions.visibilityOf(hp.minusButtonofChart));
        //8-Kullanıcı sol altta bulunan "-" butonuna tıklar ve 1 adet azaltır
        act.moveToElement(hp.minusButtonofChart).click().perform();
        int theFinalNumberofProductsintheChart= Integer.parseInt(hp.theNumberofProductsintheChart.getText());
        System.out.println("theFinalNumberofProductsintheChart = " + theFinalNumberofProductsintheChart);
        //8-Kullanıcı ürün sayısının 1 adet azaldığını görür
        Assert.assertTrue(theFinalNumberofProductsintheChart<theInitialNumberofProductsintheChart);
        extentTest.pass("Sepettek ürün adedinin azaltılabildiği doğrulandı.");
        Driver.closeDriver();
    }
    @Test
    public void test07()  {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        extentTest = extentReports.createTest("US17_TC_07", "Sepette ürünün birim fiyatı görüntülenir");
        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePageAll hp = new HomePageAll();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden BAGS sekmesine tıklar
        hp.bagsButton.click();
        //4-Kullanıcı Ürünler görünene kadar sayfayı aşağı indirir
        Actions act = new Actions(Driver.getDriver());
        act.moveToElement(hp.thefirstItem).perform();
        System.out.println("hp.thefirstItem.getText() = " + hp.thefirstItem.getText());
        //5-Kullanıcı çıkan ilk stoğu bitmemiş ürünün sağ altında bulunan CART butonuna tıklar ve ürünü sepete ekler
        for (WebElement p : hp.allTextoftheAllBags) {
            if (p.getText().contains("Cart")) {
                hp.cartButton.click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOf(hp.itemCartButton));
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        hp.itemCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(hp.priceOfProductintheChart));
        //7-Kullanıcı Seçtiği ürünün sepette sol tarafta birim fiyatını görür
        System.out.println("priceOfProductintheChart = " + hp.priceOfProductintheChart.getText());
        Assert.assertTrue(hp.priceOfProductintheChart.isDisplayed());
        extentTest.pass("Sepettek ürünün birim fiyatının görüntülendiği doğrulandı.");
        Driver.closeDriver();
    }
    @Test
    public void test08()  {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        extentTest = extentReports.createTest("US17_TC_08", "Sepette ürünün toplam fiyatı görüntülenmeli.");
        //1-Kullanıcı URL ye gider.
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        HomePageAll hp = new HomePageAll();
        //2-Kullanıcı sol üstteki GROCERY butonuna tıklar.
        hp.categoryDropDownButton.click();
        //3-Kullanıcı GROCERY butonundan aşağı doğru uzanan sekmelerden BAGS sekmesine tıklar
        hp.bagsButton.click();
        //4-Kullanıcı Ürünler görünene kadar sayfayı aşağı indirir
        Actions act = new Actions(Driver.getDriver());
        act.moveToElement(hp.thefirstItem).perform();
        System.out.println("hp.thefirstItem.getText() = " + hp.thefirstItem.getText());
        //5-Kullanıcı çıkan ilk stoğu bitmemiş ürünün sağ altında bulunan CART butonuna tıklar ve ürünü sepete ekler
        for (WebElement p : hp.allTextoftheAllBags) {
            if (p.getText().contains("Cart")) {
                hp.cartButton.click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOf(hp.itemCartButton));
        //6-Kullanıcı sayfanın sağ orta tarafında bulunan "1 Item" yazan yeşil butona tıklar
        hp.itemCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(hp.totalPriceOfProductintheChart));
        System.out.println("totalPriceOfProductintheChart = " + hp.totalPriceOfProductintheChart.getText());
        //8-Kullanıcı sepette sol üstte bulunan "+" butonuna tıklar ve adet sayısını arttırır
        act.moveToElement(hp.plusButtonofChart).click().perform();
        //9-Kullanıcı sağda ürünün toplam fiyatını görür
        System.out.println("totalPriceOfProductintheChart = " + hp.totalPriceOfProductintheChart.getText());
        Assert.assertTrue(hp.totalPriceOfProductintheChart.isDisplayed());
        extentTest.pass("Sepetteki ürünün toplam fiyatının görüntülenebildiği doğrulandı.");
        Driver.closeDriver();
    }
}
