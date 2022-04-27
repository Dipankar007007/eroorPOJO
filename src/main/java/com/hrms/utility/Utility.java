package com.hrms.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.base.BaseClass;

public class Utility extends BaseClass{
			
		@FindBy(id="rightMenu")
		WebElement enterFrame;
		
	public void enterFrame() {
		driver.switchTo().frame(enterFrame);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	
	
	}
	
	


