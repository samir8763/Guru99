package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetbanking.utilities.ReadConfig;



public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	
	public String url=readconfig.getApplicationUrl();
	public String Username=readconfig.getUserName();
	public String Password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver=new ChromeDriver();
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
