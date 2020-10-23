package com.mystore.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.utility.Util;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	public static Logger log =LogManager.getLogger(IndexPageTest.class.getName());
	String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	public WebDriver driver;
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() throws IOException {
		driver=initializeDriver();
		log.info("Driver initialize successfully");

	}
	
	@DataProvider
	public Object[][] CredentialData() throws IOException{
		Object data[][]=Util.getdata("LoginCredentials");
		return data;
	}
	
	@Test(dataProvider="CredentialData",groups= {"Smoke","Sanity"})
	public void loginTest(String username,String password) throws InterruptedException {
		log.info("LoginTest");
		indexPage=new IndexPage(driver);
		log.info("Usrer is going to click on sigin");
		loginPage=indexPage.clickOnSignIn();
		log.info("Entered username and Password");
		homePage=loginPage.Login(username,password);
		String actualURL=homePage.getCurrURL();
		log.info("Verifying url of the homePage");
		Assert.assertEquals(actualURL, expectedURL);
		log.info("Login is Successfully");
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
}
