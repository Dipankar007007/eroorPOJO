package com.hrms.pageObjects;
import com.hrms.base.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BaseClass {
	
//	public LoginPage(){
//	
//		PageFactory.initElements(driver,this);
//	}
    
	
//	@FindBy(xpath="//input[@name='txtUserName']")
//	WebElement txt_Name;
//	
//	@FindBy(xpath="//input[@name='txtPassword']")
//	WebElement txt_Password;
//	
//	@FindBy(xpath="//input[@name='Submit']")
//	WebElement btn_Login;
//	
//	@FindBy(xpath="//input[@name='clear']")
//	WebElement btn_Clear;
	
	
	By txt_Name=By.xpath("//input[@name='txtUserName']");
	
	By txt_Password=By.xpath("//input[@name='txtPassword']");
	
	By btn_Login=By.xpath("//input[@name='Submit']");
	
	public  void login(String Username, String Password) {
		
//		txt_Name.sendKeys(Username);
////		txt_Password.sendKeys(Password);
////	 	btn_Login.click();
		driver.findElement(txt_Name).sendKeys(Username);
		driver.findElement(txt_Password).sendKeys(Password);
	 	driver.findElement(btn_Login).click();
	 	}


	public String getTitle() {
		String actualTitle =driver.getTitle();		
		return actualTitle;
		}
	}
	
