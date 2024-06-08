package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.ActionsUtil;
import util.DropDownUtil;
import util.WaitUtil;
import util.WebDriverUtil;

import java.util.List;

public class HomePage extends WebTestBase{

    @FindBy(xpath = "//a[@class='newsletter__close newsletter__trigger']")
    WebElement firstAd;

    @FindBy(xpath = "//a[@class='user-controls__ul__li__a']")
    WebElement myAccountBtn;

    @FindBy(xpath = "//a[text()='Shop']")
    WebElement shopOption;

    @FindBy(xpath = "(//ul[@class='sub-menu'])[2]//li/a")
    List<WebElement> allShopOptions;

    @FindBy(xpath = "")
    List<WebElement> allElement;

    @FindBy(id = "sort")
    WebElement dropDownOption;


    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public void closedFirstAd(){
        WaitUtil.waitUntilElementToBeClickable(firstAd);
    }

    public void clickOnMyAccountBtn(){
        WaitUtil.waitUntilElementToBeClickable(myAccountBtn);
    }

    public boolean myAccountBtnDisplayed(){
        return WebDriverUtil.isElementDisplayed(myAccountBtn);
    }

    public void selectShopOption(String option){
        WaitUtil.waitUntilElement(shopOption);
        ActionsUtil.moveToWebElement(shopOption);
        WaitUtil.waitUntilElement(allShopOptions);
        ActionsUtil.selectRandomOptionInList(allShopOptions, option);
    }

    public void selectPopularityOption(String option){
        DropDownUtil.selectOptionByVisibleText(dropDownOption, option);
    }
}
