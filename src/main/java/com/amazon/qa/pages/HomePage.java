package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

/**
 * @author amit.mahajan
 *
 */
public class HomePage extends TestBase {
	
	
	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	//***********************Page Factory ----OR(Object repo)*******************************************
	
	@FindBy(xpath="//div[@id='nav-logo']") 
	static WebElement Logo;
	
	
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	static WebElement SearchDropdown;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//******************************************** Page Methods***************************************
	public boolean VerifyHomePageLogo() {
		
		
		boolean amazonlogo = Logo.isDisplayed();
		
		return amazonlogo;
		
		
		
	}
	
	public static String Selectcategory() throws InterruptedException {
		
		
		Select Category = new Select(SearchDropdown);
		Category.selectByVisibleText("Kindle Store");
		Thread.sleep(2000);
		String CatVal = Category.getFirstSelectedOption().getText();
		return CatVal;
		
	}
	

}
