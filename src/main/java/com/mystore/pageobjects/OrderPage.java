package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {

	public WebDriver driver;
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(xpath="//td[@class='price']/span")
	WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public OrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		String uprice=unitPrice.getText();
		String unit=uprice.replaceAll("[^a-zA-Z0-9]", "");
		Double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String tprice=totalPrice.getText();
		String totalp=tprice.replaceAll("[^a-zA-Z0-9]", "");
		Double finalTotalPrice=Double.parseDouble(totalp);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() {
		proceedToCheckOut.click();
		return new LoginPage(driver);
	}
}

