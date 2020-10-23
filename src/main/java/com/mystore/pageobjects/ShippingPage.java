package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {

	public WebDriver driver;
	@FindBy(id="cgv")
	WebElement termsCheckBox;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	WebElement checkOutBtn;
	
	public ShippingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void CheckOnTerms() {
		termsCheckBox.click();
	}
	
	public PaymentPage proccedToCheckOut() {
		checkOutBtn.click();
		return new PaymentPage(driver);
	}
	
}
