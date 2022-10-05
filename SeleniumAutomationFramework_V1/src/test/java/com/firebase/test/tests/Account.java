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

public class Account extends BaseTest {
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
		WebElement accountbutton = driver.findElement(By.id("Account_Tab"));
		clickElement(accountbutton, "Account Tab");
		logger.info("Account tab open successfully");
		waitUntilVisible();
		WebElement accountPopUpbutton = driver.findElement(By.id("tryLexDialogX"));
		clickElement(accountPopUpbutton, "userNavLabel");
	}

	@AfterClass
	public void afterClass() {
		 closeBrowser();
		 logger.info("Browser closed successfully");
	}

	@Test
	static void LoginTC10() {
		
		WebElement NewAccountBtn = driver.findElement(By.name("new"));
		clickElement(NewAccountBtn, "userNavLabel");
		waitUntilVisible();
		
		WebElement actName = driver.findElement(By.id("acc2"));
		enterText(actName, "Global Media", "Accountname");

		driver.findElement(By.id("acc6")).sendKeys("Technology Partner");

		driver.findElement(By.id("00N4x00000WJLbu")).sendKeys("High");

		WebElement SaveBtn = driver.findElement(By.name("save"));
		clickElement(SaveBtn, "Save");
		logger.info("New Account Created Successfully");
		logger.info("Test Case LoginTC10 Passed");

	}

	@Test
	static void LoginTC11() {

	
		WebElement accountViewbutton = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[2]"));
		accountViewbutton.click();

		WebElement viewname = driver.findElement(By.id("fname"));
		enterText(viewname, "ShiActView", "ViewName");
		waitUntilVisible();

		WebElement ViewUniqueName = driver.findElement(By.id("devname"));
		enterText(ViewUniqueName, "ShiActViewName", "ViewUniqueName");

		waitUntilVisible();

		WebElement savebutton = driver.findElement(By.name("save"));
		savebutton.click();
		
		logger.info("Test Case LoginTC11 Passed");
	}

	@Test
	static void LoginTC12() {

		
		driver.findElement(By.id("fcf")).sendKeys("ShiActViewNew");

		WebElement editbutton = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[1]"));
		clickElement(editbutton, "Edit");

		WebElement ViewName = driver.findElement(By.id("fname"));
		enterText(ViewName, "ShiActView", "View Name");

		driver.findElement(By.id("fcol1")).sendKeys("Account Name");

		driver.findElement(By.id("fop1")).sendKeys("contains");

		WebElement value = driver.findElement(By.id("fval1"));
		enterText(value, "a", "Value");

		waitUntilVisible();

		WebElement savebtn = driver.findElement(By.name("save"));
		clickElement(savebtn, "Save");
		logger.info("Test Case LoginTC12 Passed");
	}

	@Test
	static void LoginTC13() {

	
		WebElement MAccounts  = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
		clickElement( MAccounts, "MergeAccounts");
		WebElement Aname = driver.findElement(By.id("srch"));
		enterText(Aname, "Shivani", "Accountname");
		WebElement Faccounts = driver.findElement(By.name("srchbutton"));
		clickElement(Faccounts, "Find Accounts");
		WebElement Next = driver.findElement(By.name("goNext"));
		clickElement(Next, "Next");
		WebElement Merge = driver.findElement(By.name("save"));
		clickElement(Merge, "Merge");
		
		driver.switchTo().alert().accept(); // Popup Ok Button
		
		logger.info("Test Case LoginTC13 Passed");
	
	}
	
	@Test
	static void LoginTC14() {

	
		WebElement Reports  = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
		clickElement(Reports, "Reports");
			
		WebElement fromdate = driver.findElement(By.id("ext-gen152"));
		clickElement(fromdate, "From Date");
		
		WebElement fromTodayDate = driver.findElement(By.id("ext-gen276"));
		clickElement(fromTodayDate, "fromTodayDate");
		
		WebElement toDate = driver.findElement(By.id("ext-gen154"));
		clickElement(toDate, "To Date");
		
		WebElement toTodayDate = driver.findElement(By.id("ext-gen292"));
		clickElement(toTodayDate, "toTodayDate");
		
		
		WebElement Save = driver.findElement(By.id("ext-gen49"));
		clickElement(Save, "Save");
			
		WebElement RepName = driver.findElement(By.id("saveReportDlg_reportNameField"));
		enterText(RepName, "ShivaniReport", "Report Name");
		
		WebElement RepUniqueName = driver.findElement(By.id("saveReportDlg_DeveloperName"));
		enterText(RepUniqueName, "ShivaniReportUnique", "Report Unique Name");
		
		WebElement SaveReport = driver.findElement(By.id("ext-gen310"));
		clickElement(SaveReport, "SaveReport");
		
		logger.info("Test Case LoginTC14 Passed");
	
	}
			
}
