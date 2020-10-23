package com.mystore.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public  WebDriver driver;
	public static Properties prop;
	public WebDriver initializeDriver() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\1234\\TestNGProject\\MyStoreProject\\Configuration\\config.properties");
		prop.load(fis);
		
		String browsername=prop.getProperty("browser");
		if(browsername.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\work83\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\work1\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("IE"))
		{	
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}	
}
