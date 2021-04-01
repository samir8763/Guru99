package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.mongodb.diagnostics.logging.Logger;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void LoginTest() {
		driver.get(url);
		logger.info("URL Entered");
		LoginPage lp = new LoginPage(driver);
		lp.setusername(Username);
		logger.info("Username Entered");
		lp.setpassword(Password);
		logger.info("Password Entered");
		lp.login();
		logger.info("Login Successful");
		if (driver.getTitle().equalsIgnoreCase("GTPL Bank Manager HomePage")) {

			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Login Test failed");
		}

	}

}
