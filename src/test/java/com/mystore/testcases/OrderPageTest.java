package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	public WebDriver driver;
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() throws IOException {
		driver=initializeDriver();
	}
	
	@Test(groups="Regression")
	public void verifyTotalPrice()throws InterruptedException {
		indexPage=new IndexPage(driver);
		searchResultPage=indexPage.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.selectQty(2);
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCartBtn();
		orderPage=addToCartPage.clickOnCheckOutBtn();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*2)+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}
	
	
//	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
//	public void teardown() {
//		driver.quit();
//	}
	
	
	
}
