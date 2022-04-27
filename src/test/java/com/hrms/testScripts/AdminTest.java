

package com.hrms.testScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.base.BaseClass;
import com.hrms.pageObjects.Admin;



public class AdminTest {
	BaseClass b=new BaseClass();
	Admin a;
	@BeforeMethod()
	public void setUp() {
		b.openApplication();			
	}
	
	@Test
	public void verifyPageTitle() {
		
		
	}
	
	@AfterMethod()
	public void tearDown()
	{
		b.closeApplication();
		
	}

}
