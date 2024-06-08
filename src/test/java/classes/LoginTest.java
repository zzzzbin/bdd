package classes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class LoginTest extends WebTestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;

    public LoginTest(){
        super();
    }

    @BeforeMethod
    public void beforeMethod() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(description = "Verify Login with valid username and valid password")
    public void verifyLogin() {
        SoftAssert softAssert = new SoftAssert();
        homePage.closedFirstAd();
        homePage.clickOnMyAccountBtn();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        softAssert.assertEquals(myAccountPage.getTextOfMyAccount(), "MY ACCOUNT", "text should be MY ACCOUNT");
        softAssert.assertAll();
    }

    @Test(description = "Verify Login with valid username and invalid password")
    public void verifyLoginWithValidUsernameAndInvalidPassword() {
        SoftAssert softAssert = new SoftAssert();
        homePage.closedFirstAd();
        homePage.clickOnMyAccountBtn();
        loginPage.login(prop.getProperty("username"), prop.getProperty("invalidPassword"));
        softAssert.assertEquals(loginPage.getTextOfErrorElement(), "ERROR", "text should be ERROR");
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
