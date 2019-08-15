package com.wallethhub.qa.testcases;

import com.wallethhub.qa.base.TestBase;
import com.wallethhub.qa.pages.WalletHubScreen;
import com.wallethhub.qa.util.RandomUtils;
import com.wallethhub.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class is for testing the wallethub review and rating functionality.
 */
public class WalletHubTest extends TestBase {
	WalletHubScreen walletHubScreen;
	TestUtil testUtil;
	String url = "http://wallethub.com/profile/test_insurance_company/";

	// you can change the username and password for the login process
	String username = "shahr4731@gmail.com";
	String password = "Ronak10591!";

	String message = "Hello World";

	public WalletHubTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization(url);
		testUtil = new TestUtil();
		walletHubScreen = new WalletHubScreen(driver);
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws Exception {
		String star;
		String name;

		//Login
		walletHubScreen.loginTabButton.click();
		walletHubScreen.emailAddressTextfield.sendKeys(username);
		walletHubScreen.passwordTextField.sendKeys(password);
		walletHubScreen.loginButton.click();
		waitForLoading();

		//get the username for further use
		name=walletHubScreen.userName.getText();

		//swipe to the star element
		swipeToElement(walletHubScreen.whatsYourRatingLabel);

		//hower one by one on the star
		for(int i = 1;i <= 5;i++){
			star= ".review-action > review-star:nth-child(2) > div:nth-child(1) > svg:nth-child("+i+")";
			hoverOnStar(driver.findElement(By.cssSelector(star)));
			waitForAnElement();
			if(i == 5){
				//select the 5th star
				driver.findElement(By.cssSelector(star)).click();
			}
		}

		//select health insurance
		walletHubScreen.selectButton.click();
		walletHubScreen.healthInsuranceButton.click();

		//add review comment
		String reviewComment = RandomUtils.generateRandomString(200, RandomUtils.Mode.ALPHA);
		walletHubScreen.reviewTextField.click();
		walletHubScreen.reviewTextField.sendKeys(reviewComment);

		//submit
		walletHubScreen.submitBtn.click();
		waitForLoading();

		//navigate to the review url
		navigateTo("https://wallethub.com/profile/"+name+"/reviews/");
		waitForLoading();
		driver.navigate().refresh();
		waitForLoading();

		//get the review posted text and verify
		walletHubScreen.reviewBtn.click();
		String reviewPosted = walletHubScreen.reviewText.getText();
		Assert.assertEquals(reviewComment,reviewPosted.replace(" ",""),"Post is same which was commented");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
