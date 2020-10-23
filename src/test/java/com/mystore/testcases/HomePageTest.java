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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	public static Logger log =LogManager.getLogger(HomePageTest.class.getName());
	public WebDriver driver;
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() throws IOException {
		driver=initializeDriver();
	}
	
	@Test(groups="Smoke")
	public void wishListTest() throws InterruptedException {
		indexPage=new IndexPage(driver);
		loginPage=indexPage.clickOnSignIn();
		log.debug("clicked on signInBtn");
		homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		log.debug("Entered username and Password");
		log.debug("clicked ong LoginBtn");
		boolean result=homePage.validateMyWhishList();
		Assert.assertTrue(result);	
		log.info("Successfully validated text");
		log.info("-------------TestEnded-----------");

	}
	
	@Test(groups="Smoke")
	public void orderHistoryTest() throws InterruptedException {
		indexPage=new IndexPage(driver);
		loginPage=indexPage.clickOnSignIn();
		log.debug("clicked on signInBtn");
		homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		log.debug("Entered username and Password");
		log.debug("clicked ong LoginBtn");
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(result);
		log.info("Successfully validated text");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
}
