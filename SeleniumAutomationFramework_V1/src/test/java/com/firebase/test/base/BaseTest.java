package com.firebase.test.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.firebase.test.utility.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver = null;

	public static void loginToSalesforce() {
		CommonUtilities CU = new CommonUtilities();

		Properties applicaitonPropertiesFile = CU.loadFile("applicationProperties");

		String url = CU.getApplicationProperty("url", applicaitonPropertiesFile);
		String uname = CU.getApplicationProperty("username", applicaitonPropertiesFile);
		String password = CU.getApplicationProperty("password", applicaitonPropertiesFile);

		// HashMap HM = CU.getAllPropertiesAsSet(applicaitonPropertiesFile);
		// String url = (String)HM.get("url");
		// String uname = (String)HM.get("username");
		// String password = (String)HM.get("password");
		// System.out.println(url);
		
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, uname, "username");

		WebElement userpassword = driver.findElement(By.id("password"));
		enterText(userpassword, password, "password");

		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickElement(loginbutton, "Login");
		
	}

	public static void setDriver(String browser) {
		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
	}

	public static void enterText(WebElement element, String text, String objName) {
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
			System.out.println("Pass: Text entered in  " + objName + " field");
		} else {
			System.out.println("Fail: Element " + objName + " dosen't displayed");
		}
	}

	public static void clickElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.click();
			;
			System.out.println("Pass: Element " + objName + " Successfully click");
		} else {
			System.out.println("Fail: Element " + objName + " Dosen't displayed");
		}
	}

	public static void clearElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.clear();
			System.out.println("Pass: Element " + objName + " Successfully clear");
		} else {
			System.out.println("Fail: Element " + objName + " Dosen't displayed");
		}

	}
	
	public static void selectByValueData(WebElement element, String text) {
		Select selectdropdown = new Select(element);
		selectdropdown.selectByValue(text);
	}

	public static void closeAllBrowser() {
		driver.quit();
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static String getPageTitle() {
	
		return	driver.getTitle();
		
	}
	
	public static void gotoUrl(String Url) {
		driver.get(Url);
		driver.manage().window().maximize();
	}

	public static void waitUntilVisible()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
