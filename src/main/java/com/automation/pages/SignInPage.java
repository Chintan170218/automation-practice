package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Utility {

    public SignInPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAddressTextField;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordTextField;

    @FindBy(xpath = "//div[@class='form_content clearfix']//p[@class='submit']//i")
    WebElement signInButton;

    @FindBy(xpath = "//button[@id='SubmitCreate']//i[@class='icon-user left']")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//h1[contains(text(),'Authentication')]")
    WebElement verifyAuthentication;

    @FindBy(xpath = "button[id='SubmitCreate'] span")
    WebElement verifyCreateAnAccount;

    @FindBy(id = "email_create")
    WebElement createNewEmail;

 //   @FindBy(xpath = "(//div[@class='alert alert-danger'])[1]")
    @FindBy(xpath = "//ol//li")
    WebElement verifyAuthenticationFailedMessage;

    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement verifyLogOutLink;


    public void signInWithUserNameAndPassword(String userName, String password) {
        waitUntilVisibilityOfElementLocated(By.xpath("//input[@id='email']"), 5);
        sendTextToElement(emailAddressTextField, userName);
        waitUntilVisibilityOfElementLocated(By.xpath("//input[@id='passwd']"), 5);
        sendTextToElement(passwordTextField, password);
        clickOnElement(signInButton);
    }

    public void clickOnCreateAnAccount(String userName) {
        sendTextToElement(createNewEmail, userName);
        clickOnElement(createAnAccountButton);
    }

    public String verifyAuthenticationText() {
        return getTextFromElement(verifyAuthentication);
    }

    public String verifyCreateAnAccountText() {
        return getTextFromElement(verifyCreateAnAccount);
    }

    public String getVerifyAuthenticationFailedMessage() {
        return getTextFromElement(verifyAuthenticationFailedMessage);
    }

    public String verifyLogOutLink() {
        return getTextFromElement(verifyLogOutLink);
    }

    public void clickOnSignOut() {
        clickOnElement(verifyLogOutLink);
    }

}
