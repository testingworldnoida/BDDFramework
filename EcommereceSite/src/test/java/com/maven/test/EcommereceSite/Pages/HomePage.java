package com.maven.test.EcommereceSite.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.maven.test.EcommereceSite.Base.BaseClass;
import com.maven.test.EcommereceSite.Utils.Assertion;
import com.maven.test.EcommereceSite.Utils.FindPageObjects;
import com.maven.test.EcommereceSite.Utils.ReadPropertyFiles;
import com.maven.test.EcommereceSite.Utils.WebDriverUtilities;
import com.vimalselvam.cucumber.listener.Reporter;



public class HomePage {
	FindPageObjects         findpageObjects            =               new     FindPageObjects();
	WebDriverUtilities      webdriverutilties          =               new     WebDriverUtilities(); 
	Assertion               assertion                  =               new     Assertion();
   BaseClass                baseclass                  =               new     BaseClass();
   WebDriver               driver;

	/**
	 * @constructor
	 * */
	public HomePage() throws Exception{
		  this.driver    =  baseclass.getDriver();
	}



	/**
	 * 
	 * Function to click on Sign In Link
	 * */
	public void ClickSignIn() {
		try {
			webdriverutilties.click(findpageObjects.getObject(ReadPropertyFiles.readLocatorsFile("SIGNIN")), 5);
			Reporter.addStepLog("Click Performed on Sign In Link");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog("Unable to Click on Sign In Link");
			throw new RuntimeException("Unable to Click on Sign In Link");
		}
	}

	
	
	public void validateHomePage(String expectedURL) {
     	String actualURl   = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURl);
		
	}
}
