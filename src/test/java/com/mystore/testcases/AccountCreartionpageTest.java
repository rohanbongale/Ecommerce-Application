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
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreartionpageTest extends BaseClass {
	public static Logger log =LogManager.getLogger(IndexPageTest.class.getName());

	public WebDriver driver;
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() throws IOException {
		driver=initializeDriver();
	}
	
	@Test(groups="Sanity")
	public void verifyCreateAccountPageTest() {
		indexPage=new IndexPage(driver);
		log.info("Successfully Navigated to IndexPage");
		loginPage=indexPage.clickOnSignIn();
		log.info("clicked on Signin Button");
		accountCreationPage=loginPage.CreateAccount("admin@xyz.com");
		log.info("Entered Email Address & Clicked on Create an Account Button");
		boolean result=accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(result);
		log.info("Vliadated Account Creation Page");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
}
