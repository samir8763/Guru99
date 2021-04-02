package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider = "LoginData")
	public void loginDDT(String usnm ,String pwd)
	{
		LoginPage lp=new LoginPage(driver);
		lp.setusername(usnm);
		logger.info("User name is provided");
		lp.setpassword(pwd);
		logger.info("Password is provided");
		lp.login();
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.logout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
	}
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
			return true;	
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
		
	}
	
@DataProvider(name="LoginData")
String [][] getData() throws IOException{
	String path="./src\\test\\java\\com\\inetbanking\\testdata\\LoginData.xlsx";
	int rownum=XLUtils.getRowCount(path, "sheet1");
	int colnum=XLUtils.getCellCount(path, "sheet1", 1);
	String logindata [][]=new String[rownum][colnum];
	for(int i=1;i<=rownum;i++)
	{
		for(int j=0;j<colnum;j++)
		{
			logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			
		}
	}
	return logindata;
	
	
	
	
}
}
