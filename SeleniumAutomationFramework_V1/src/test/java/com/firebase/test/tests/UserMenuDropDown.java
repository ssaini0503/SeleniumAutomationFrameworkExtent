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

public class UserMenuDropDown extends BaseTest
{
	//public static WebDriver driver = null;
	static Logger logger = Logger.getLogger(Account.class);
	@BeforeClass
	public void beforeClass()
	{
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
	public void afterClass()
	{
		closeBrowser();
		logger.info("Browser closed successfully");
	}
	
		
	@Test
	static void LoginTC05()
	{		
    	WebElement usermenu=driver.findElement(By.id("userNavLabel"));
		clickElement(usermenu, "userNavLabel");
		
		logger.info("Test Case LoginTC05 Passed");
	}
	
	@Test (enabled = false)
	static void LoginTC06() // Not Completed
	{
				
		WebElement usermenu=driver.findElement(By.id("userNavLabel"));
		clickElement(usermenu, "userNavLabel");
		WebElement usermyprofile=driver.findElement(By.className("menuButtonMenuLink"));
		clickElement(usermyprofile, "usermyprofile");
	
		waitUntilVisible();
		WebElement usereditprofiletab=driver.findElement(By.id("moderatorMutton"));
		clickElement(usereditprofiletab, "usereditprofiletab");
		
		WebElement usereditprofile=driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[1]/div/div[1]/div[1]/div/ul/li[2]/a"));
		clickElement(usereditprofile, "usereditprofile");
		
		waitUntilVisible();
		WebElement about=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/ul/li[1]/a"));
		clickElement(about, "about");
		
		WebElement lastname=driver.findElement(By.id("lastName"));
		enterText(lastname,"Saini New" , "LastName");
		
		WebElement saveall=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]"));
		clickElement(saveall, "Save");
		
		}
	
    @Test
	static void LoginTC08()
	{
    		
		WebElement usermenu=driver.findElement(By.id("userNavLabel"));
		clickElement(usermenu, "userNavLabel");
	
	    WebElement developerconsole=driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[3]"));	
	    clickElement(developerconsole, "developerconsole");
	    
		logger.info("Test Case LoginTC08 Passed");

	}
		
    @Test
	static void LoginTC09()
	{
				
		WebElement usermenu=driver.findElement(By.id("userNavLabel"));
		clickElement(usermenu, "userNavLabel");
		
		WebElement logoutbutton=driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]"));
		clickElement(logoutbutton, "logout");
		
		logger.info("Test Case LoginTC09 Passed");
	
	}
	
    @Test
    static void LoginTC10()
	{
    
		WebElement accountbutton=driver.findElement(By.id("Account_Tab"));
		clickElement(accountbutton, "userNavLabel");
		
		waitUntilVisible();
		
		WebElement PopupClose=driver.findElement(By.id("tryLexDialogX"));
		clickElement(PopupClose, "userNavLabel");

		WebElement NewAccountBtn=driver.findElement(By.name("new"));
		clickElement(NewAccountBtn, "userNavLabel");
		waitUntilVisible();
			
		
		WebElement actName = driver.findElement(By.id("acc2"));
		enterText(actName, "ShivaniAccount", "Accountname");
		
		
		//driver.findElement(By.id("acc6")).sendKeys("Technology Partner");
		WebElement act = driver.findElement(By.id("acc6"));
		selectByValueData(act, "Technology Partner");

		//driver.findElement(By.id("00N4x00000WJLbu")).sendKeys("High");
		WebElement priority = driver.findElement(By.id("00N4x00000WJLbu"));
		selectByValueData(priority, "High");
		
		WebElement SaveBtn=driver.findElement(By.name("save"));
		clickElement(SaveBtn, "Save");
		
		logger.info("Test Case LoginTC10 Passed");
	}
    
    @Test
    static void LoginTC11()
	{
    
		WebElement accountbutton=driver.findElement(By.id("Account_Tab"));
		clickElement(accountbutton, "Account Tab");
		
			
		waitUntilVisible();
		WebElement accountPopUpbutton=driver.findElement(By.id("tryLexDialogX"));
		clickElement(accountPopUpbutton, "Save");
			
			
		WebElement accountViewbutton=driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[2]"));
		clickElement(accountViewbutton, "Save");
		

		WebElement viewname = driver.findElement(By.id("fname"));
		enterText(viewname, "ShiActView", "ViewName");
		waitUntilVisible();
		
		WebElement ViewUniqueName = driver.findElement(By.id("devname"));
		enterText(ViewUniqueName, "ShiActViewName", "ViewUniqueName");
		

		waitUntilVisible();

		WebElement savebutton=driver.findElement(By.name("save"));
		clickElement(savebutton, "Save");
		
		logger.info("Test Case LoginTC11 Passed");
		
	}
    
}
