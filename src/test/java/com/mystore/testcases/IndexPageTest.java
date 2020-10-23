package com.mystore.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;



public class IndexPageTest extends BaseClass {
	public static Logger log =LogManager.getLogger(IndexPageTest.class.getName());

	IndexPage indexPage;
	public WebDriver driver;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() throws IOException {
		driver=initializeDriver();	
	}
		
	@Test(groups="Smoke")
	public void verifyLogo() {
		indexPage=new IndexPage(driver);
		log.info("Successfully Navigated to IndexPage");
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);	
		log.info("Validated Logo is Dislpayed");
	}
	
	@Test(groups="Smoke")
	public void verifyTitle() {
		indexPage=new IndexPage(driver);
		log.info("Successfully Navigated to IndexPage");
		String storetitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(storetitle, "My Store");
		log.info("Validated index page title");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
}
