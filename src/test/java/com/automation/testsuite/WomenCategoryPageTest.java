package com.automation.testsuite;

import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.pages.WomenCategoryPage;
import com.automation.testbase.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;

public class WomenCategoryPageTest extends TestBase {

    HomePage homePage;
    SignInPage signInPage;
    SoftAssert softAssert;
    WomenCategoryPage womenCategoryPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){

        homePage = new HomePage();
        signInPage = new SignInPage();
        softAssert = new SoftAssert();
        womenCategoryPage = new WomenCategoryPage();
        PageFactory.initElements(driver, this);
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully(){
        homePage.clickOnWomenLink();
        String expectedText = "WOMEN";
        String actualText = womenCategoryPage.verifyWomenText();
        softAssert.assertEquals(actualText,expectedText);
        softAssert.assertAll();
    }

    @Test (groups = {"sanity", "smoke", "regression"}, dataProvider = "dataSet", dataProviderClass = TestData.class)
    public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String size, String colour)
            throws InterruptedException {

        homePage.clickOnWomenLink();
        womenCategoryPage.setSelectProduct(product);
        womenCategoryPage.enterQty(qty);
        womenCategoryPage.setSelectSize(size);
        womenCategoryPage.setSelectColour(colour);
        womenCategoryPage.setAddToCartButton();
        Thread.sleep(2000);
        String expectedText = "Product successfully added to your shopping cart";
        String actualText =womenCategoryPage.setConfirmationText();
        System.out.println(actualText);
        softAssert.assertEquals(actualText,expectedText);
        softAssert.assertAll();
        womenCategoryPage.setCloseWindow();
    }
}
