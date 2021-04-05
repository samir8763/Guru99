package com.inetbanking.testcases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddNewCustomerTest_003 extends BaseClass{
@Test
public void Addnewcustomer() throws InterruptedException
{
	LoginPage lp= new LoginPage(driver);
	lp.setusername(Username);
	logger.info("Username Provided Successfully");
	lp.setpassword(Password);
	logger.info("Password Provided Successfully");
	lp.login();
	logger.info("Login Successfull");
	Thread.sleep(3000);
	AddCustomerPage addcust=new AddCustomerPage(driver);
	logger.info("Customer Details");
	addcust.NewCustomer();
	addcust.CustName("Samir Kumar Behera");
	addcust.custdob("26", "03", "1995");		
	addcust.custAddress("Brm");
	addcust.custState("Odisha");
	addcust.custpin(461121);
	addcust.custMob("1234567890");
	String emaill=randomString()+"gmail.com";
	addcust.custemail(emaill);
	addcust.submit();
	logger.info("Customer Added Successfully");
}
}