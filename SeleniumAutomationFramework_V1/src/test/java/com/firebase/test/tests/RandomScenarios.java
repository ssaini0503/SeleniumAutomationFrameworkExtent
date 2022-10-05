package com.firebase.test.tests;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class RandomScenarios extends BaseTest {
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
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
		logger.info("Browser closed successfully");
	}

	@Test
	static void LoginTC33() {

		WebElement HomeButton = driver.findElement(By.id("home_Tab"));
		clickElement(HomeButton, "HomeButton");
		waitUntilVisible();
		WebElement OptPopUpbutton = driver.findElement(By.id("tryLexDialogX"));
		clickElement(OptPopUpbutton, "Popup Close");
		WebElement Firstlastname = driver.findElement(By.linkText("Shiva Saini"));
		clickElement(Firstlastname, "Firstlastname");
		logger.info("Test Case LoginTC33 Passed");
	}

	@Test
	static void LoginTC34() {
		WebElement HomeButton = driver.findElement(By.id("home_Tab"));
		clickElement(HomeButton, "HomeButton");
		waitUntilVisible();
		WebElement OptPopUpbutton = driver.findElement(By.id("tryLexDialogX"));
		clickElement(OptPopUpbutton, "Popup Close");
		WebElement Firstlastname = driver.findElement(By.linkText("Shiva Saini"));
		clickElement(Firstlastname, "Firstlastname");

		WebElement UserMenu = driver.findElement(By.id("moderatorMutton"));
		clickElement(UserMenu, "UserMenu");
		waitUntilVisible();
		WebElement EditProfileLink = driver.findElement(By.linkText("Edit Profile"));
		clickElement(EditProfileLink, "EditProfile");

		waitUntilVisible();

		WebElement firstName = driver
				.findElement(By.xpath("/html/body/div/div/div/div[2]/form/ul/li[1]/div[1]/div[1]/input"));
		enterText(firstName, "Shivani", "firstName");

		WebElement lastName = driver
				.findElement(By.id("/html/body/div/div/div/div[2]/form/ul/li[1]/div[1]/div[2]/input"));
		enterText(lastName, "ARNAV ANVI", "last Name");
		waitUntilVisible();

		WebElement SaveProfile = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]"));
		clickElement(SaveProfile, "SaveProfile");

		logger.info("Test Case LoginTC34 Passed");
	}

	@Test
	static void LoginTC35() {

		WebElement EditProfileLink = driver.findElement(By.className("allTabsArrow"));
		clickElement(EditProfileLink, "EditProfile");
		waitUntilVisible();
		WebElement CustomizeMyTab = driver.findElement(By.name("customize"));
		clickElement(CustomizeMyTab, "CustomizeMyTab");

		driver.findElement(By.id("duel_select_1")).sendKeys("Chatter");

		WebElement removetab = driver.findElement(By.id("duel_select_0_left"));
		clickElement(removetab, "Remove tab");
		waitUntilVisible();
		WebElement savebutton = driver.findElement(By.name("save"));
		clickElement(savebutton, "save");

		logger.info("Test Case LoginTC35 Passed");
	}

	@Test
	static void LoginTC36() {

		WebElement HomeButton = driver.findElement(By.id("home_Tab"));
		clickElement(HomeButton, "HomeButton");
		waitUntilVisible();
		WebElement OptPopUpbutton = driver.findElement(By.id("tryLexDialogX"));
		clickElement(OptPopUpbutton, "Popup Close");
		WebElement datelink = driver.findElement(By.linkText("Sunday October 2, 2022"));
		clickElement(datelink, "datelink");
		WebElement time = driver.findElement(By.linkText("8:00 PM"));
		clickElement(time, "Time");
		waitUntilVisible();
		WebElement subjectcombo = driver.findElement(By.id("evt5"));
		enterText(subjectcombo, "Other", "subjectcombo");

		WebElement enddate = driver.findElement(By.id("EndDateTime_time"));
		enterText(enddate, "10:00 PM", "subjectcombo");

		waitUntilVisible();

		WebElement savebutton = driver.findElement(By.name("save"));
		clickElement(savebutton, "save");

		logger.info("Test Case LoginTC36 Passed");
	}

	@Test
	static void LoginTC37() {

		WebElement HomeButton = driver.findElement(By.id("home_Tab"));
		clickElement(HomeButton, "HomeButton");
		waitUntilVisible();
		WebElement OptPopUpbutton = driver.findElement(By.id("tryLexDialogX"));
		clickElement(OptPopUpbutton, "Popup Close");
		waitUntilVisible();
		WebElement datelink = driver.findElement(By.linkText("Sunday October 2, 2022"));
		clickElement(datelink, "datelink");
		WebElement time = driver.findElement(By.linkText("4:00 PM"));
		clickElement(time, "Time");
		waitUntilVisible();
		WebElement subjectcombo = driver.findElement(By.id("evt5"));
		enterText(subjectcombo, "Other", "subjectcombo");

		WebElement enddate = driver.findElement(By.id("EndDateTime_time"));
		enterText(enddate, "7:00 PM", "subjectcombo");

		waitUntilVisible();

		WebElement IsRecurrence = driver.findElement(By.id("IsRecurrence"));
		clickElement(IsRecurrence, "Time");

		WebElement Weekly = driver.findElement(By.id("rectypeftw"));
		clickElement(Weekly, "Time");

		int noOfDays = 14;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, noOfDays);
		Date date = cal.getTime();

		Format f = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = f.format(date);
		System.out.println("Current Date = " + strDate);

		System.out.println("Day after two weeks: " + date + "\n");
		WebElement Enddate = driver.findElement(By.id("RecurrenceEndDateOnly"));
		enterText(Enddate, strDate, "Enddate");

		WebElement savebutton = driver.findElement(By.name("save"));
		clickElement(savebutton, "save");

		WebElement monthview = driver.findElement(By.className("monthViewIcon"));
		clickElement(monthview, "monthview");

		logger.info("Test Case LoginTC37 Passed");
	}
}
