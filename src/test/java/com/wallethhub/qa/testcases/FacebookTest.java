package com.wallethhub.qa.testcases;

import com.wallethhub.qa.pages.FacebookSignInScreen;
import com.wallethhub.qa.pages.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wallethhub.qa.base.TestBase;
import com.wallethhub.qa.util.TestUtil;

/**
 * This class is for testing the login of facebook and posting a status.
 */
public class FacebookTest extends TestBase {
	FacebookSignInScreen facebookSignInScreen;
	TestUtil testUtil;
	String url = "https://facebook.com";

	// you can change the username and password for the login process
	String username = "shahronak563@gmail.com";
	String password = "Ronak10591!";

	String message = "Hello World";

	public FacebookTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization(url);
		testUtil = new TestUtil();
		facebookSignInScreen = new FacebookSignInScreen(driver);
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		Assert.assertTrue(facebookSignInScreen.emailAddressTextfield.isDisplayed(),
				"Email address textfield is displayed");
		Assert.assertTrue(facebookSignInScreen.passwordTextField.isDisplayed(),
				"Password textfield is displayed");
		Assert.assertTrue(facebookSignInScreen.loginButton.isDisplayed(),
				"Login Btn is displayed");

		//login
		facebookSignInScreen.emailAddressTextfield.click();
		facebookSignInScreen.emailAddressTextfield.sendKeys(username);

		facebookSignInScreen.passwordTextField.click();
		facebookSignInScreen.passwordTextField.sendKeys(password);

		facebookSignInScreen.loginButton.click();
		waitForLoading();
		Assert.assertTrue(isFound(facebookSignInScreen.notificationBellButton),
				"Notification Bell is found");

		//add a status
		facebookSignInScreen.statusTextfield.click();
        WebElement status =driver.findElement(By.xpath(Locators.FacebookSignInPage.WRITE_POST_TEXTFIELD));
        status.sendKeys(message);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.FacebookSignInPage.POST_BTN))).click();
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
