package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	public WebDriver driver;
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement productResult;
	
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() {
		return productResult.isDisplayed();
	}
	
	public AddToCartPage clickOnProduct() {
		productResult.click();
		return new AddToCartPage(driver);
	}
}
