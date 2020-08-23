package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	static HomePage home;
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[@id='nav-flyout-ya-signin']/a")
	static WebElement Signin;
	
	@FindBy(xpath = "//input[@id='ap_email']")
	static WebElement useremail;
	
	@FindBy(xpath = "//input[@id='ap_password']")
	static WebElement userpassword;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	static WebElement Login;
	
	@FindBy(xpath = "//a[@id='nav-orders']")
	static WebElement Orders;
	
	
	public static String Loginapp(String username ,String password) throws InterruptedException {
		//driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		Thread.sleep(1000);
		useremail.sendKeys(username);
		userpassword.sendKeys(password);
		Login.click();	
		Thread.sleep(1000);
		Orders.click();
		String title =driver.getTitle();
		Thread.sleep(1000);
		return title;
		
		
	}
	
	
	
	

}
