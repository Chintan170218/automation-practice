package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility{

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li//a[contains(text(),'Women')]")
    WebElement womenLink;

    @FindBy(xpath = "(//a[contains(text(),'Dresses') and @class='sf-with-ul'])[2]")
    WebElement dressesLink;

    @FindBy(xpath = "(//ul[@style='display: none;']//a[contains(text(),'T-shirts')])[1]")
    WebElement tShirtsLink;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInLink;

    @FindBy(xpath ="//img[@alt='My Store']" )
    WebElement logoLink;

    public void clickOnWomenLink(){
        clickOnElement(womenLink);
    }

    public void clickOnDressesLink(){
        clickOnElement(dressesLink);
    }

    public void clickOnTShirtsLink(){
        clickOnElement(tShirtsLink);
    }

    public void clickOnSignInLink(){
        clickOnElement(signInLink);
    }

    public String verifyLogo(){
        return getTextFromElement(logoLink);
    }

    public String signInLinkVerify(){
        return getTextFromElement(signInLink);
    }



}
