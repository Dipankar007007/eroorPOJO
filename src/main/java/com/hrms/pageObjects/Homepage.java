package com.hrms.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hrms.base.BaseClass;

public class Homepage extends BaseClass {
		
	By link_Admin = By.id("admin");
	By link_Pim   = By.id("pim");
	By link_Leave = By.id("leave");

	
      public void verifyTile() {
    	  if (driver.getTitle().equals("OrangeHRM - New Level of HR Management")){
         
    	                      Reporter.log("Verification of Title is successful");
    	                      }else {
    		                     Reporter.log("Verification of Title is Failed");
    		                     Assert.assertEquals(false,true);  		  
}
}
}
