package com.mystore.testcases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	public static Logger log =LogManager.getLogger(IndexPageTest.class.getName());

	public WebDriver driver;
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() throws IOException {
		driver=initializeDriver();
	}
	
	@Test(groups="Smoke")
	public void productAvialabilityTest() {
		indexPage=new IndexPage(driver);
		log.info("Successfully Navigated to IndexPage");
		searchResultPage=indexPage.searchProduct("t-shirt");
		log.info("Entered t-shirt in Search Box");
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		log.info("Validating Product is Avaliable");
	}
		
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
}
