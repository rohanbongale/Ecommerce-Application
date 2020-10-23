package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {
	public WebDriver driver;
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public AddressPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ShippingPage clickOnCheckOut() {
		proceedToCheckOut.click();
		return new ShippingPage(driver);
	}
}
