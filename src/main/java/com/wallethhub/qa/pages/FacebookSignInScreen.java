package com.wallethhub.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Facebook Sign In Screen locators
 */
public class FacebookSignInScreen {

    public FacebookSignInScreen(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = Locators.FacebookSignInPage.EMAIL_ADDRESS_TEXTFIELD)
    public WebElement emailAddressTextfield;

    @FindBy(how = How.ID, using = Locators.FacebookSignInPage.PASSWORD_TEXTFILED)
    public WebElement passwordTextField;

    @FindBy(how = How.ID, using = Locators.FacebookSignInPage.LOGIN_BUTTON)
    public WebElement loginButton;

    @FindBy(how = How.ID, using = Locators.FacebookSignInPage.NOTIFICATION_BELL_BUTTON)
    public WebElement notificationBellButton;

    @FindBy(how = How.XPATH, using = Locators.FacebookSignInPage.STATUS_TEXTFIELD)
    public WebElement statusTextfield;

    @FindBy(how = How.XPATH, using = Locators.FacebookSignInPage.WRITE_POST_TEXTFIELD)
    public WebElement writePostTextfield;

    @FindBy(how = How.XPATH, using = Locators.FacebookSignInPage.POST_BTN)
    public WebElement postButton;

}
