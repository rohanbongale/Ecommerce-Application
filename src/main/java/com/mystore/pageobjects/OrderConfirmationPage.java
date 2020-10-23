package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	public WebDriver driver;
	@FindBy(xpath="//strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement confirmationMsg;
	
	public OrderConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String validateConfirmMessage() {
		String confirmMsge=confirmationMsg.getText();
		return confirmMsge;
		
	}
}
