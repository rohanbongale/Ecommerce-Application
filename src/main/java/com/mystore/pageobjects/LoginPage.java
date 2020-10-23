package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	
	public WebDriver driver;
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(name="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	WebElement newAccBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage Login(String uname,String pswd) throws InterruptedException {
		username.sendKeys(uname);
		password.sendKeys(pswd);
		signInBtn.click();
		Thread.sleep(10000l);
		return new HomePage(driver);
	}
	
	public AddressPage Login1(String uname,String pswd) {
		username.sendKeys(uname);
		password.sendKeys(pswd);
		signInBtn.click();
		return new AddressPage(driver);
	}
	
	public AccountCreationPage CreateAccount(String useremail) {
		emailForNewAccount.sendKeys(useremail);
		newAccBtn.click();
		return new AccountCreationPage(driver);
	}
}
