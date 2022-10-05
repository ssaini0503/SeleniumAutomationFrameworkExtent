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

public class Opportunity extends BaseTest {
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
		WebElement OptButton = driver.findElement(By.id("Opportunity_Tab"));
		clickElement(OptButton, "userNavLabel");
		logger.info("Opportunity tab open successfully");
		waitUntilVisible();
		WebElement OptPopUpbutton = driver.findElement(By.id("tryLexDialogX"));
		clickElement(OptPopUpbutton, "Popup Close");
	}

	@AfterClass
	public void afterClass() {
		 closeBrowser();
		 logger.info("Browser closed successfully");
	}

	@Test
	static void LoginTC15() {
		
		
		WebElement OpportunityView = driver.findElement(By.id("fcf"));
		clickElement(OpportunityView, "OpportunityView Dropdown");
		
		logger.info("Test Case LoginTC15 Passed");
		
	}

	@Test
	static void LoginTC16() {

		WebElement OptNewbutton = driver.findElement(By.name("new"));
		clickElement(OptNewbutton, "New Opportunity");

		WebElement OptName = driver.findElement(By.id("opp3"));
		enterText(OptName, "ShivaniOpportunity", "OptName");
	
		WebElement OptActName = driver.findElement(By.id("opp4"));
		enterText(OptActName, "ShivaniAccount", "Account Name");
		
		WebElement closeDate = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/span/a"));
		clickElement(closeDate, "Close Date");
		
		driver.findElement(By.id("opp11")).sendKeys("Qualificaiton"); // Stage
		
		driver.findElement(By.id("opp6")).sendKeys("Web"); // Lead Source

		WebElement savebutton = driver.findElement(By.name("save"));
		clickElement(savebutton, "save");
		
		logger.info("Test Case LoginTC16 Passed");
	}

	@Test
	static void LoginTC17() {

	
		WebElement OptPipelineLink = driver.findElement(
		By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));
		clickElement(OptPipelineLink, "OptPipelineLink");
		
		logger.info("Test Case LoginTC17 Passed");
	
	}
	
	@Test
	static void LoginTC18() {

		WebElement OptStuckLink = driver.findElement(
		By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
		clickElement(OptStuckLink, "OptStuckLink");
		
		logger.info("Test Case LoginTC18 Passed");
	}
	
	@Test
	static void LoginTC19() {

	    driver.findElement(By.id("quarter_q")).sendKeys("Current FQ"); // Stage
		
		driver.findElement(By.id("open")).sendKeys("All Opportunities"); // Lead Source
		
		WebElement RunReport = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/div/div/form/table/tbody/tr[3]/td/input"));
		clickElement(RunReport, "Run Report");
		
		logger.info("Test Case LoginTC19 Passed");
		
	}
				
}
