package com.amazon.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
			try {
				prop= new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir") +
						"/src/main/java/com/amazon/qa/config/config.properties");
				prop.load(ip);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	
	public static void initialization() {
		
		String BrowserName = prop.getProperty("browser");
		
		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ 
					"/src/main/java/com/amazon/qa/data/chromedriver");	
			driver = new ChromeDriver();			
		}
		else {	
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ 
					"\\src\\main\\java\\com\\amazon\\qa\\data\\geckodriver.exe");
			driver = new FirefoxDriver();			
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	public static void failed(String testMethodName) {
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screen"
					+ "shot\\"+testMethodName+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
