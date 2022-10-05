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

public class Contacts extends BaseTest {
	// public static WebDriver driver = null;
	static Logger logger = Logger.getLogger(Account.class);

	@BeforeClass
	public void beforeClass() {
		PropertyConfigurator.configure(
				"C:\\Users\\asehgal\\eclipse-workspace\\SeleniumAutomationFrameworkExtent\\src\\test\\resources\\Logs.properties");

		CommonUtilities CU = new CommonUtilities();
		Properties applicaitonPropertiesFile = CU.loadFile("applicationProperties");
		String url = CU.getApplicationProperty("url", applicaitonPropertiesFile);
		setDriver("chrome");
		gotoUrl(url);
		loginToSalesforce();
		logger.info("Login Successfully");

		WebElement ContactButton = driver.findElement(By.id("Contact_Tab"));
		clickElement(ContactButton, "userNavLabel");

		logger.info("Contact tab open successfully");

		waitUntilVisible();

		WebElement ContactPopUpbutton = driver.findElement(By.id("tryLexDialogX"));
		clickElement(ContactPopUpbutton, "Popup Close");
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
		logger.info("Browser closed successfully");
	}

	@Test
	static void LoginTC25() {

		WebElement newContact = driver.findElement(By.name("new"));
		clickElement(newContact, "New Contact");

		WebElement LastName = driver.findElement(By.id("name_lastcon2"));
		enterText(LastName, "Saini", "Last Name");

		WebElement Company = driver.findElement(By.id("con4"));
		enterText(Company, "ShivaniAccount", "Company");

		WebElement savebutton = driver.findElement(By.name("save"));
		clickElement(savebutton, "save");

		logger.info("New Contact Created Successfully");
		logger.info("Test Case LoginTC25 Passed");

	}

	@Test
	static void LoginTC26() {

		WebElement contactViewbutton = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[2]"));
		contactViewbutton.click();

		WebElement viewname = driver.findElement(By.id("fname"));
		enterText(viewname, "ShiContactView", "ViewName");
		waitUntilVisible();

		WebElement ViewUniqueName = driver.findElement(By.id("devname"));
		enterText(ViewUniqueName, "ShiContactViewName", "ViewUniqueName");

		waitUntilVisible();

		WebElement savebutton = driver.findElement(By.name("save"));
		clickElement(savebutton, "Save");
		logger.info("Test Case LoginTC26 Passed");

	}

	@Test
	static void LoginTC27() {

		driver.findElement(By.id("hotlist_mode")).sendKeys("Recently Created");
		logger.info("Test Case LoginTC27 Passed");
	}

	@Test
	static void LoginTC28() {

		driver.findElement(By.id("fcf")).sendKeys("My Contacts");
		logger.info("Test Case LoginTC28 Passed");

	}

	@Test
	static void LoginTC29() {

		WebElement Contactname = driver.findElement(By.linkText("Gonzalez, Rose"));
		clickElement(Contactname, "ContactName");
		logger.info("Test Case LoginTC29 Passed");
	}

	@Test
	static void LoginTC30() {

		WebElement Createnewview = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[2]"));
		clickElement(Createnewview, "Createnewview");
		WebElement ViewUniqueName = driver.findElement(By.id("devname"));
		enterText(ViewUniqueName, "EFGH", "ViewUniqueName");

		WebElement savebutton = driver.findElement(By.name("save"));
		clickElement(savebutton, "Save");
		logger.info("Test Case LoginTC30 Passed");

	}

	@Test
	static void LoginTC31() {

		WebElement Createnewview = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[2]"));
		clickElement(Createnewview, "Createnewview");

		WebElement ViewName = driver.findElement(By.id("fname"));
		enterText(ViewName, "ABCD", "ViewName");

		WebElement ViewUniqueName = driver.findElement(By.id("devname"));
		enterText(ViewUniqueName, "EFGH", "ViewUniqueName");

		WebElement Cancelbutton = driver.findElement(By.name("cancel"));
		clickElement(Cancelbutton, "Cancel");
		logger.info("Test Case LoginTC31 Passed");

	}

	@Test
	static void LoginTC32() {

		WebElement newbutton = driver.findElement(By.name("new"));
		clickElement(newbutton, "newButton");

		WebElement lastname = driver.findElement(By.id("name_lastcon2"));
		enterText(lastname, "Indian", "lastName");

		WebElement Accountname = driver.findElement(By.id("con4"));
		enterText(Accountname, "Global Media", "AccountName");
		WebElement newnsavebutton = driver.findElement(By.name("save_new"));
		clickElement(newnsavebutton, "newnsaveButton");

		logger.info("Test Case LoginTC32 Passed");

	}
}