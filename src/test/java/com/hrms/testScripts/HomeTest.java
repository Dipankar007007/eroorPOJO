package com.hrms.testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.base.Base;
import com.hrms.base.BaseClass;
import com.hrms.pageObjects.Homepage;
import com.hrms.pageObjects.Login;
import com.hrms.utility.Utility;

public class HomeTest extends BaseClass {

	Login l= new Login();
	Utility u = new Utility();
	public WebDriver driver;
	
@BeforeMethod
public void setUp() throws Exception {
	//driver=openApplication();
	Thread.sleep(2000);
//	l.login();
}

@Test
public void varifyTitle() {
	
	Assert.assertEquals(u.getPageTitle(), "homepage");
	
}


@AfterMethod
public void tearDown(){
	closeApplication();
}
	
}
