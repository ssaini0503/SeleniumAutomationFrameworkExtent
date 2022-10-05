package com.firebase.test.tests;


import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.firebase.test.base.BaseTest;
import com.firebase.test.utility.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCLogin extends BaseTest
{
	//public static WebDriver driver = null;

	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before class");
	}
	
	@AfterClass
	public void afterClass()
	{
		//closeBrowser();
	}
	
	@Test
	public static void LoginTC1() throws InterruptedException
	{
	    String ExpectedTitle ="Home Page ~ Salesforce - Developer Edition";
		CommonUtilities CU = new CommonUtilities();
		Properties applicaitonPropertiesFile = CU.loadFile("applicationProperties");

		String url = CU.getApplicationProperty("url", applicaitonPropertiesFile);
		String uname = CU.getApplicationProperty("username", applicaitonPropertiesFile);
		String password =  CU.getApplicationProperty("password", applicaitonPropertiesFile);
		setDriver("chrome");
		gotoUrl(url);
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, uname, "username");

		WebElement userpassword = driver.findElement(By.id("password"));
		enterText(userpassword, "", "password");

		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickElement(loginbutton, "Login");

		String ActualTitle = getPageTitle();
				
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Assert passed");

	}

	@Test
	static void LoginTC2()
	{
		String expected ="Home Page ~ Salesforce - Developer Edition";
		CommonUtilities CU = new CommonUtilities();
		Properties applicaitonPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicaitonPropertiesFile);
		setDriver("chrome");
		gotoUrl(url);
		loginToSalesforce();
		
		String actual = getPageTitle();
	
		if(actual.equals(expected))
		{
			System.out.println("Testcase Passed");
		}
		else
		{
			System.out.println("Testcase Failed");
		}
	
	}
	
	@Test
	static void LoginTC3()
	{
		CommonUtilities CU = new CommonUtilities();
		Properties applicaitonPropertiesFile = CU.loadFile("applicationProperties");

		String url = CU.getApplicationProperty("url", applicaitonPropertiesFile);
		String uname = CU.getApplicationProperty("username", applicaitonPropertiesFile);
		String password = CU.getApplicationProperty("password", applicaitonPropertiesFile);
		setDriver("chrome");
		gotoUrl(url);
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, uname, "username");

		WebElement userpassword = driver.findElement(By.id("password"));
		enterText(userpassword, password, "password");
		
		WebElement remember=driver.findElement(By.id("rememberUn"));
		remember.click();

		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickElement(loginbutton, "Login");
		
		waitUntilVisible();

		WebElement userNavLabel=driver.findElement(By.id("userNavLabel"));
		clickElement(userNavLabel, "userNavLabel");
			
		WebElement logoutbutton=driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]"));
		clickElement(logoutbutton, "Logout");
			
	}

	@Test
	static void LoginTC4A()
	{
		CommonUtilities CU = new CommonUtilities();
		Properties applicaitonPropertiesFile = CU.loadFile("applicationProperties");

		String url = CU.getApplicationProperty("url", applicaitonPropertiesFile);
		String uname = CU.getApplicationProperty("username", applicaitonPropertiesFile);
	
		setDriver("chrome");
		gotoUrl(url);
		
		WebElement forgot_password_link=driver.findElement(By.id("forgot_password_link"));
		clickElement(forgot_password_link, "Forgot");
			
		waitUntilVisible();
		
		WebElement username = driver.findElement(By.id("un"));
		enterText(username, uname, "username");
	
		WebElement continuebtn=driver.findElement(By.id("continue"));
		clickElement(continuebtn, "continue");
	
	}
	
	@Test
	static void LoginTC4B()
	{
		CommonUtilities CU = new CommonUtilities();
		Properties applicaitonPropertiesFile = CU.loadFile("applicationProperties");

		String url = CU.getApplicationProperty("url", applicaitonPropertiesFile);
		String uname = CU.getApplicationProperty("username", applicaitonPropertiesFile);
		String password = CU.getApplicationProperty("password", applicaitonPropertiesFile);
	
		setDriver("chrome");
		gotoUrl(url);
		
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "123", "username");

		WebElement userpassword = driver.findElement(By.id("password"));
		enterText(userpassword, "22131", "password");

		WebElement loginbutton = driver.findElement(By.id("Login"));
		clickElement(loginbutton, "Login");
		}
	
}