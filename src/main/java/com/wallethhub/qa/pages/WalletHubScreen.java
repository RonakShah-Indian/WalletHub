package com.wallethhub.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Facebook Sign In Screen locators
 */
public class WalletHubScreen {

    public WalletHubScreen(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.LOGIN_TAB_BUTTON)
    public WebElement loginTabButton;

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.EMAIL_TEXTFILED)
    public WebElement emailAddressTextfield;

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.PASSWORD_TEXTFILED)
    public WebElement passwordTextField;

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.LOGIN_BUTTON)
    public WebElement loginButton;

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.USERNAME)
    public WebElement userName;

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.WHATS_YOUR_RATING_LABEL)
    public WebElement whatsYourRatingLabel;

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.STAR_BUTTON)
    public WebElement starButton;

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.SELECT_BUTTON)
    public WebElement selectButton;

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.HEALTH_INSURANCES_BUTTON)
    public WebElement healthInsuranceButton;

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.REVIEW_TEXTFIELD)
    public WebElement reviewTextField;

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.SUBMIT_BUTTON)
    public WebElement submitBtn;

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.ACTIVITY_BTN)
    public WebElement reviewBtn;

    @FindBy(how = How.XPATH, using = Locators.WalletHubPage.REVIEW_TEXT)
    public WebElement reviewText;

}
