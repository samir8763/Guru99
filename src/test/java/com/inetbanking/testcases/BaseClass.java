package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();

	public String url = readconfig.getApplicationUrl();
	public String Username = readconfig.getUserName();
	public String Password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		if (br.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());

			// ChromeOptions options=new ChromeOptions();
			// options.setHeadless(true);
			// driver=new ChromeDriver(options);
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			// FirefoxOptions options=new FirefoxOptions();
			// options.setHeadless(true);
			// driver=new FirefoxDriver(options);
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	

}
