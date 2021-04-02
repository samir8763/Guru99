package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	 WebDriver driver;
@FindBy(xpath="//input[@name='uid']")
WebElement txtUserNameField;
@FindBy(name="password")
WebElement txtPasswordField;
@FindBy(name="btnLogin")
WebElement LoginBtn;
@FindBy(xpath="//a[.='Log out']")
WebElement Logoutlink;
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
public void setusername(String uname)
{
txtUserNameField.sendKeys(uname);	
}
public void setpassword(String pwd)
{
	txtPasswordField.sendKeys(pwd);
}
public void login() {
	LoginBtn.click();
}
public void logout() 
{
Logoutlink.click();	
}
}
