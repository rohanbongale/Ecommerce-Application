package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass {
	public WebDriver driver;
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	public OrderSummaryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrderBtn() {
		confirmOrderBtn.click();
		return new OrderConfirmationPage(driver);
	}
}
