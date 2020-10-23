package com.mystore.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass {
	public static Logger log =LogManager.getLogger(HomePageTest.class.getName());
	public WebDriver driver;
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() throws IOException {
		driver=initializeDriver();
	}
	
	@Test(groups="Regression")
	public void endToEndTest()throws InterruptedException {
		log.info("-------------Teststarted-----------");
		log.info("Successfully Navigated To indexPage");
		indexPage=new IndexPage(driver);
		searchResultPage=indexPage.searchProduct("t-shirt");
		log.debug("Entered text in search Box");
		addToCartPage=searchResultPage.clickOnProduct();
		log.debug("Clicked On Search Button");
		addToCartPage.selectQty(2);
		log.debug("selected quantity");
		addToCartPage.selectSize("M");
		log.debug("selected Size");
		addToCartPage.clickOnAddToCartBtn();
		log.debug("clicked on AddCatr Button");
		orderPage=addToCartPage.clickOnCheckOutBtn();
		log.info("Sucessfully Navigated To OrderPage");
		log.debug("clicked on Checkout Button");
		loginPage=orderPage.clickOnCheckOut();
		log.debug("clicked on Checkout Button");
		log.debug("Entered username and Password");
		addressPage=loginPage.Login1(prop.getProperty("username"), prop.getProperty("password"));
		log.debug("clicked on Login Button");
		shippingPage=addressPage.clickOnCheckOut();
		log.info("Successfully validated Address");
		log.debug("clicked on Checkout");
		shippingPage.CheckOnTerms();
		log.debug("clicked on Terms & Condition check box");
		paymentPage=shippingPage.proccedToCheckOut();
		log.debug("clicked on Procced To Checkout Button");
		orderSummaryPage=paymentPage.clickOnPayByBank();
		log.info("Navigated to OrderSummary Page");
		log.debug("Clicked on Pay By Bank link");
		orderConfirmationPage=orderSummaryPage.clickOnConfirmOrderBtn();
		log.info("Navigated to Order Confirmation Page");
		log.debug("Clicked on Confirmorder Button");
		String actualMsg=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMsg, expectedMsg);
		log.info("Valiadted Order Successfully Confirmation Message");
		log.info("---------------TestEnded--------------");

	}
		
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		driver.quit();
	}
	
}
