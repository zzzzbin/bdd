package classes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class HomeTest extends WebTestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;

    public HomeTest(){
        super();
    }

    @BeforeMethod
    public void beforeMethod() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(description = "Verify My Account btn is displayed on Home page")
    public void verifyMyAccountBtnDisplayed(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closedFirstAd();
        softAssert.assertTrue(homePage.myAccountBtnDisplayed(), "myAccount btn should be displayed");
        softAssert.assertAll();
    }


    @Test(description = "Verify mouse hover the shop option in tool tip")
    public void verifyMouseHover() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.closedFirstAd();
        homePage.selectShopOption(prop.getProperty("shopOption"));
        Thread.sleep(5000);
        softAssert.assertAll();
    }

    @Test(description = "Verify drop down option from list")
    public void verifyDropDownOptionFromList() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.closedFirstAd();
        homePage.selectShopOption(prop.getProperty("shopOption"));
        Thread.sleep(5000);
        homePage.closedFirstAd();
        homePage.selectPopularityOption("Latest");
        Thread.sleep(5000);
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
