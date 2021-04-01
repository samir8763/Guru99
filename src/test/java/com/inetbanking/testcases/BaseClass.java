package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseClass {
	public String url="http://demo.guru99.com/V1/index.php";
	public String Username="mngr317601";
	public String Password="sanEzUv";
	public static WebDriver driver;
	public static Logger logger;
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
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
