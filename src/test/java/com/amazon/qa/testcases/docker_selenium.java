package com.amazon.qa.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class docker_selenium {
	
	
	@Test
	
	public void testapp() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"),cap);
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
	}
	
	
	

}
