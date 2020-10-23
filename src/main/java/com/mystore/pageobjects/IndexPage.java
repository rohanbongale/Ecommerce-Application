package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	public WebDriver driver;
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	public IndexPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn() {
		signInBtn.click();
		return new LoginPage(driver);
	}
	
	public boolean validateLogo() {
		return myStoreLogo.isDisplayed();
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle=driver.getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		searchProductBox.sendKeys(productName);
		searchButton.click();
		return new SearchResultPage(driver);
	}
	
}
