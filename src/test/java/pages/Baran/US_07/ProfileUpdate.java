package pages.Baran.US_07;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class ProfileUpdate extends BaseTestReport {

    public ProfileUpdate(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Profile
    @FindBy(xpath = "//img[@alt='user name']")
    WebElement profileImage;
    @FindBy(xpath = "//button[text()='Profile']")
    WebElement profile;
    @FindBy(xpath = "//button[text()='Save']")
    WebElement save;

    //Change Password
    @FindBy(xpath = "//a[text()='Change Password']")
    WebElement password;
    @FindBy(id = "oldPassword")
    WebElement oldPass;
    @FindBy(id = "newPassword")
    WebElement newPass;
    @FindBy(id = "passwordConfirmation")
    WebElement confirmPass;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submit;

    //My Orders
    @FindBy(linkText = "My Orders")
    WebElement myOrders;

    @FindBy(xpath = "//div[@role]")
     List<WebElement> orders;

    @FindBy(xpath = "//h2[@class]")
    WebElement details;

    @FindBy(xpath = "//button[text()='Load More']")
    WebElement loadMore;

    //My Wishlists
    @FindBy(linkText = "My Wishlists")
    WebElement myWishlists;

    @FindBy(xpath = "//button[text()='Remove']")
    WebElement remove;

    @FindBy(xpath = "//div[@role='alert']")
     WebElement alertMessage;

    //Logout
    @FindBy(xpath = "//button[text()='Logout']")
     WebElement logout;
    @FindBy(xpath = "//button[text()='Join']")
    WebElement join;






    //Profile and Change Password
    public void profileUpdate(){
        profileImage.click();
        profile.click();
        save.click();
        String alertMessage= Driver.getDriver().switchTo().alert().getText();
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertEquals(alertMessage,"Profile Updated Successfully","Profil güncelleme başarısızdır");

    }

    public void passwordUpdate(){
        Faker rndm=new Faker();
        long newPassword=rndm.number().randomNumber();
        profileImage.click();
        profile.click();
        password.click();

        oldPass.sendKeys(rndm.number().randomNumber()+"");
        newPass.sendKeys(newPassword+"");
        confirmPass.sendKeys(newPassword+"");
        submit.click();
        String alertMessage= Driver.getDriver().switchTo().alert().getText();
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertEquals(alertMessage,"Password Changed Successfully","Password güncelleme başarısızdır");
    }

    //My Orders
    public void orderCheck() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        profileImage.click();
        profile.click();
        myOrders.click();
        for (int i = 0; i < orders.size(); i++) {

            if (orders.get(i).isDisplayed()) {
                orders.get(i).click();
                Assert.assertTrue(details.isDisplayed());
            }
            else {
                break;
            }
        }
    }
    //My Wishlists
    public void wishlistsCheck(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        profileImage.click();
        profile.click();
        myWishlists.click();
        remove.click();
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        Assert.assertTrue(alertMessage.getText().contains("Removed"));
    }

    //Loguout
    public void logoutCheck(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        profileImage.click();
        logout.click();
        Assert.assertTrue(join.isDisplayed());
    }
}
