package com.amazon.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Actionclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ 
				"/src/main/java/com/amazon/qa/data/chromedriver");
		WebDriver driver =new ChromeDriver();
		
		String baseUrl = "http://www.facebook.com/"; 

		 driver= new ChromeDriver();

		driver.get(baseUrl);
		
		WebElement txtUsername = driver.findElement(By.id("email"));

		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT)
			.sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT)
			.doubleClick(txtUsername)
			.contextClick()
			.build();
			
		seriesOfActions.perform() ;

		
		

	}

}
