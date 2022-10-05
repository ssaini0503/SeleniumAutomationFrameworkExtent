package com.firebase.test.tests;

import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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

public class Leads extends BaseTest {
	// public static WebDriver driver = null;
	 static Logger logger = Logger.getLogger(Account.class);
	
	@BeforeClass
	public void beforeClass() {
		PropertyConfigurator.configure("C:\\Users\\asehgal\\eclipse-workspace\\SeleniumAutomationFrameworkExtent\\src\\test\\resources\\Logs.properties");
		
		CommonUtilities CU = new CommonUtilities();
		Properties applicaitonPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicaitonPropertiesFile);
		setDriver("chrome");
		gotoUrl(url);
		
		loginToSalesforce();
		logger.info("Login Successfully");
		WebElement LeadButton = driver.findElement(By.id("Lead_Tab"));
		clickElement(LeadButton, "userNavLabel");
		logger.info("Lead tab open successfully");

		waitUntilVisible();
	
		WebElement LeadPopUpbutton = driver.findElement(By.id("tryLexDialogX"));
		clickElement(LeadPopUpbutton, "Popup Close");
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
		logger.info("Browser closed successfully");
	}

	@Test
	static void LoginTC20() {
		
		logger.info("Test Case LoginTC20 Passed");
	
	}
	
	@Test
	static void LoginTC21() {
				
		WebElement LeadViewDropdown = driver.findElement(By.id("fcf"));
		clickElement(LeadViewDropdown, "Lead View Dropdown");
		logger.info("Test Case LoginTC21 Passed");
	}

	@Test
	static void LoginTC22() {
		
		
		WebElement gobutton = driver.findElement(By.name("go"));
		clickElement(gobutton, "go");
		logger.info("Test Case LoginTC22 Passed");
		
		
	}
	
	@Test
	static void LoginTC23() {
						
		driver.findElement(By.id("fcf")).sendKeys("Today's Leads"); 
		logger.info("Test Case LoginTC23 Passed");
	}
	
	@Test
	static void LoginTC24() {
		
		
		WebElement newLead = driver.findElement(By.name("new"));
		clickElement(newLead, "New Lead");
					
		WebElement LastName = driver.findElement(By.id("name_lastlea2"));
		enterText(LastName, "ABCD", "Last Name");
	
		WebElement Company = driver.findElement(By.id("lea3"));
		enterText(Company, "ABCD", "Company");
		
		WebElement savebutton = driver.findElement(By.name("save"));
		clickElement(savebutton, "save");
		logger.info("Test Case LoginTC24 Passed");		
	}

}

