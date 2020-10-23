package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
	public WebDriver driver;
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement payByBank;
	
	@FindBy(xpath="//a[@class='cheque']")
	WebElement payByCheck;
	
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage clickOnPayByBank() {
		payByBank.click();
		return new OrderSummaryPage(driver);	
	}
	
	public OrderSummaryPage clickOnPayByCheck() {
		payByCheck.click();
		return new OrderSummaryPage(driver);
		
	}
}
