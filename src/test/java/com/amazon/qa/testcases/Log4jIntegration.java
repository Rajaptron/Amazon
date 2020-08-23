package com.amazon.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Log4jIntegration {

	//What is log? : capturing info/activities at the time of program execution. 
		
	// types of logs:
			//1. info
			//2. warn
	        //3. Alert
			//4. debug
			//5. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
	
	
	
	
	WebDriver driver;
	Logger log = Logger.getLogger(Log4jIntegration.class);
	
	
	@BeforeMethod
	public void setup(){
		log.info("****************************** Starting test cases execution  *****************************************");

		System.setProperty("webdriver.chrome.driver", "/Users/raj/Documents/Projects/Amazon/src/main/java/com/amazon/qa/data/chromedriver");	
		driver = new ChromeDriver(); 
		log.info("launching chrome broswer");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.automationtesting.in/Register.html");
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	
	
	@Test(priority=1)
	public void flipkartTitleTest(){
		log.info("****************************** starting test case for flipkartTitleTest *****************************************");
		
		String title = driver.getTitle();
		System.out.println(title);
		log.info("login page title is--->"+title);
		Assert.assertEquals(title,"Register");
		
		log.info("****************************** ending test case *****************************************");
		

	}
	
	@Test(priority=2)
	public void freemCRMLogoTest(){
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");

		boolean b = driver.findElement(By.xpath("//a[@class='navbar-brand']")).isDisplayed();
		Assert.assertTrue(b);
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");

	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");

		
	}
	
	
	
}
