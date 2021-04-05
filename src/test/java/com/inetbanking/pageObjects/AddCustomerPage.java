package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	 WebDriver driver;
	
@FindBy(xpath="//a[.='New Customer']")
WebElement newCustLink;

@FindBy(xpath="//input[@name='name']")
WebElement custnametxtField;

@FindBy(xpath="//input[@name='rad1']")
WebElement genRadiobut;

@FindBy(xpath="//input[@name='dob']")
WebElement dobTextField;

@FindBy(name="addr")
WebElement AddressTxtField;

@FindBy(name="city")
WebElement CityTxtField;

@FindBy(name="state")
WebElement stateTxtField;

@FindBy(name="pinno")
WebElement pinTxtField;

@FindBy(name="telephoneno")
WebElement phnoTxtField;

@FindBy(name="emailid")
WebElement emailTxtField;

@FindBy(name="sub")
WebElement submitbtn;

public AddCustomerPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
public void NewCustomer() 
{
	newCustLink.click();
	
}
public void CustName(String name) {
custnametxtField.sendKeys(name);	
}
public void custGender() {
genRadiobut.click();	
}
public void custdob(String dd, String mm,String yyyy) {
	dobTextField.sendKeys(dd);
	dobTextField.sendKeys(mm);
	dobTextField.sendKeys(yyyy);
}
public void custAddress(String addr) 
{
	
	AddressTxtField.sendKeys(addr);
}
public void custCity(String city) {
	CityTxtField.sendKeys(city);
}
public void custState(String st) 
{
	stateTxtField.sendKeys(st);
}
public void custpin(int pin) {
	pinTxtField.sendKeys(String.valueOf(pin));
	
}
public void custMob(String mob)
{
	phnoTxtField.sendKeys(mob);
}
public void custemail(String email)
{
	emailTxtField.sendKeys(email);
}
public void submit() {
	submitbtn.click();
	
}
}
