package com.hrms.testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.base.BaseClass;
import com.hrms.pageObjects.LoginPage;

public class LoginTest{
	
	BaseClass b;
    LoginPage l;
    
	@BeforeMethod
	public void setUp() {
	b=new BaseClass();	
	l=new LoginPage();
	b.openApplication();
	
	
	}
	
	@Test
	public void loginTest() throws Exception {
       l.login("nareshit", "nareshit");	
       Thread.sleep(3000);
       if (l.getTitle().equals("OrangeHRM")) {
	 		Reporter.log("Login Successfull");
       }else {
    	   Reporter.log("Login Failed");
       }
       
       
	}
	
	@Test
	public void verifyTitleTest() {
		l.login("nareshit", "nareshit");
		Assert.assertEquals(l.getTitle(), "OrangeHRM");
		
	}
	
	@AfterMethod()
	public void tearDown() {
		
		b.closeApplication();

	}
}

