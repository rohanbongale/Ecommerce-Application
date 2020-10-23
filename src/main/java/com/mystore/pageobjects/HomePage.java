package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {

	public WebDriver driver;
	@FindBy(xpath="//span[contains(text(),'My wishlists')]")
	WebElement myWishList;
	
	@FindBy(xpath="//span[contains(text(),'Order history and details')]")
	WebElement orderHistory;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyWhishList() {
		return myWishList.isDisplayed();
	}
	
	public boolean validateOrderHistory() {
		return orderHistory.isDisplayed();
	}
	public String getCurrURL() {
		String homePageURL=driver.getCurrentUrl();
		return homePageURL;
		}
	
}
