package com.mystore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	public WebDriver driver;
	@FindBy(css="[class='btn btn-default button-plus product_quantity_up']")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//i[@class='icon-ok']")
	WebElement cartMsg;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement checkOutBtn;
	
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectQty(int qty) throws InterruptedException {
		WebDriverWait w=new WebDriverWait(driver,30);
	//	w.until(ExpectedConditions.elementToBeClickable(quantity));
		Thread.sleep(10000l);
		for(int i=2;i<=qty;i++)
		{
			quantity.click();
		}
	}
	
	public void selectSize(String sizes) {
		Select s=new Select(size);
		s.selectByVisibleText(sizes);			
	}
	
	public void clickOnAddToCartBtn() throws InterruptedException {
		addToCartBtn.click();
		Thread.sleep(10000l);

	}
	
	public boolean validatecartMsg() throws InterruptedException {
		return cartMsg.isDisplayed();
	}
	
	public OrderPage clickOnCheckOutBtn() {
		checkOutBtn.click();
		return new OrderPage(driver);
	}
	
}
