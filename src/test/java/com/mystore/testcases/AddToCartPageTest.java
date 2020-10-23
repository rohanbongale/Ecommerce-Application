package com.mystore.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
	public static Logger log =LogManager.getLogger(IndexPageTest.class.getName());

	public WebDriver driver;
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() throws IOException {
		driver=initializeDriver();
		
	}
	
	@Test(groups={"Regression","Sanity"})
	public void addToCartTest() throws InterruptedException {
		indexPage=new IndexPage(driver);
		log.info("Successfully Navigated to IndexPage");
		searchResultPage=indexPage.searchProduct("t-shirt");
		log.info("Enterde Product Name in Search Box");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.selectQty(2);
		log.info("Selected");
		addToCartPage.selectSize("M");
		Thread.sleep(5000L);
		addToCartPage.clickOnAddToCartBtn();
		boolean result=addToCartPage.validatecartMsg();
		Assert.assertTrue(result);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
}
 