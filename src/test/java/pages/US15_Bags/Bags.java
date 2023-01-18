package pages.US15_Bags;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Bags {

    public Bags() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /*ORNEKTIR
        @FindBy(className ="whitespace-nowrap")
        private WebElement dropDown;
    */
    @FindBy(xpath = "//h3[text()='Armani Leather Purse']")
    private WebElement armaniLeather;

    @FindBy(xpath = "//*[text()='Armani Purse']")
    private WebElement armaniPurse;

    @FindBy(xpath ="//h3[text()='Givenchy Purse']")
    private WebElement givenchyPurse;

    @FindBy(xpath = "//h3[text()='Givenchy Mini Purse']")
    private WebElement givenchyMiniPurse;

    @FindBy(xpath = "//h3[text()='Gucci Purse']")
    private WebElement gucciPurse;

    @FindBy(xpath = "//h3[text()='Armani Silver Purse']")
    private WebElement armaniSilverPurse;

    @FindBy(xpath = "//h3[text()='Gucci GG Marmont Tote']")
    private WebElement gucciGGMarmontTote;

    @FindBy(xpath = "//h3[text()='KAAI Pyramid Bag']")
    private WebElement kAAIPyramidBag;

    @FindBy(xpath = "//h3[text()='The Marc Jacobs']")
    private WebElement theMarcJacobs;

    @FindBy(xpath = "//h3[text()='Balenciaga']")
    private WebElement balenciaga;

    @FindBy(xpath = "//h3[text()='Gucci Handbag']")
    private WebElement gucciHandbag;

    @FindBy(xpath = "//h3[text()='Armani Handbag']")
    private WebElement armaniHandbag;

    @FindBy(xpath = "//h3[text()='Mast & Harbour']")
    private WebElement mastHarbour;

    @FindBy(xpath = "//h3[text()='See by Chloé']")
    private WebElement seeByChloé;

    @FindBy(xpath = "//h3[text()='Salvatore Ferragamo']")
    private WebElement salvatoreFerragamo;

    public void clickArmaniLeather() {
        armaniLeather.click();
    }

    public void clickArmaniPurse() {
        armaniPurse.click();
    }

    public void clickGivenchyPurse() {
        givenchyPurse.click();
    }

    public void clickGivenchyMiniPurse() {
        givenchyMiniPurse.click();
    }

    public void clickGucciPurse() {
        gucciPurse.click();
    }

    public void clickArmaniSilverPurse() {
        armaniSilverPurse.click();
    }

    public void clickGucciGGMarmontTote() {
        gucciGGMarmontTote.click();
    }

    public void clickKAAIPyramidBag() {
        kAAIPyramidBag.click();
    }

    public void clickTheMarcJacobs() {
        theMarcJacobs.click();
    }

    public void clickBalenciaga() {
        balenciaga.click();
    }

    public void clickArmaniHandbag() {
        armaniHandbag.click();
    }

    public void clickMastHarbour() {
        mastHarbour.click();
    }

    public void clickSeeByChloé() {
        seeByChloé.click();
    }

    public void clickSalvatoreFerragamo() {
        salvatoreFerragamo.click();
    }

}

