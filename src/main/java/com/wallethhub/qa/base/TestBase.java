package com.wallethhub.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.wallethhub.qa.util.TestUtil;
import com.wallethhub.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/wallethhub"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(String url){
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome") || browserName.equals("Chrome")){
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-geolocation");
			option.addArguments("disable-notifications");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/resources/chromedriver");
			driver = new ChromeDriver(option);
		}
		else if(browserName.equals("FF") || browserName.equals("firefox") || browserName.equals("Firefox")){
			FirefoxOptions option = new FirefoxOptions();
			option.addPreference("dom.webnotifications.enabled", false);
			option.addPreference("app.update.enabled", false);
			option.addPreference("geo.enabled", false);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/resources/geckodriver");
			driver = new FirefoxDriver(option);
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(url);
	}

	public boolean isFound(WebElement element) {
		Long timeOut = TestUtil.IMPLICIT_WAIT;
		try {
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
				if (element.isDisplayed()) {
					driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
					return true;
				} else {
					return false;
				}
			}catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			return false;
		}
	}

	public void swipeToElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}

	public void hoverOnStar(WebElement element){
		Actions action= new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void navigateTo(String url){
		driver.navigate().to(url);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void getUrl(String url){
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void waitForAnElement() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void waitForLoading() {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
