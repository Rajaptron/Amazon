package com.amazon.qa.testcases;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.qa.base.CustomListener;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.utils.TestUtill;



@Listeners(CustomListener.class)
public class LoginPageTest extends TestBase {
	
	static LoginPage login;
	
	public LoginPageTest() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@BeforeMethod 
	  public static void Setup() throws IOException, InterruptedException {
		initialization();
		Thread.sleep(1000);
		login =new 	LoginPage();
				}
		
	@DataProvider(name="credential")
	public Object[][] Addcategorydata() {
		Object[][] arrayObject = TestUtill.getExcelData(System.getProperty("user.dir")
				+ "/src/main/java/com/amazon/qa/data/LoginData.xls","Sheet1");
		return arrayObject;
	}
	
	@Test(dataProvider="credential")
   public static void LoginAppTest(String username,String password) throws InterruptedException {
	   String title = LoginPage.Loginapp(username, password);
	  Assert.assertEquals(title, "Your Orders");
   }
	
	
	
	
	
	
	
	@AfterMethod
	  public void teardown() {
	         driver.quit();
	  	
	  		}
	
}
