package com.automation.testsuite;

import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;

public class SignPageTest extends TestBase {

    HomePage homePage;
    SignInPage signInPage;
    SoftAssert softAssert;
    CreateAccountPage createAccountPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt(){

        homePage = new HomePage();
        signInPage = new SignInPage();
        softAssert = new SoftAssert();
        createAccountPage = new CreateAccountPage();
        PageFactory.initElements(driver, this);
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldNavigateToSignInPageSuccessFully(){
        homePage.clickOnSignInLink();
        String expectedTest= "AUTHENTICATION";
        String actualTest= signInPage.verifyAuthenticationText();
        softAssert.assertEquals(expectedTest,actualTest);
        softAssert.assertAll();
    }

    @Test(groups = {"sanity","smoke", "regression"},dataProvider = "credentials", dataProviderClass = TestData.class )
    public void verifyTheErrorMessageWithInValidCredentials(String username, String password,String message) {
        homePage.clickOnSignInLink();
        signInPage.signInWithUserNameAndPassword(username, password);
        String expectedTest = message;
        String actualTest = signInPage.getVerifyAuthenticationFailedMessage();
        softAssert.assertEquals(expectedTest, actualTest);
        softAssert.assertAll();
    }

    @Test (groups = {"smoke","regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        homePage.clickOnSignInLink();
        signInPage.signInWithUserNameAndPassword("Georgesmith@gmail.com","acd1234");
        String expectedTest = "Sign out";
        String actualTest = signInPage.verifyLogOutLink();
        softAssert.assertEquals(expectedTest, actualTest);
        softAssert.assertAll();
    }

    @Test(groups = {"regression"})
    public void VerifyThatUserShouldLogOutSuccessFully(){
        homePage.clickOnSignInLink();
        signInPage.signInWithUserNameAndPassword("Georgesmith@gmail.com","acd1234");
        signInPage.clickOnSignOut();
        String expectedTest = "Sign in";
        String actualTest = homePage.signInLinkVerify();
        softAssert.assertEquals(expectedTest, actualTest);
        softAssert.assertAll();
    }
}
