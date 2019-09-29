package com.maven.test.EcommereceSite.Pages;

import com.maven.test.EcommereceSite.Utils.Assertion;
import com.maven.test.EcommereceSite.Utils.FindPageObjects;
import com.maven.test.EcommereceSite.Utils.ReadPropertyFiles;
import com.maven.test.EcommereceSite.Utils.WebDriverUtilities;
import com.vimalselvam.cucumber.listener.Reporter;

public class MyAccount {
	
	FindPageObjects         findpageObjects            =               new     FindPageObjects();
	WebDriverUtilities      webdriverutilties          =               new     WebDriverUtilities();  
	Assertion               assertion                  =               new     Assertion();
	
	
	/**
	 * @constructor
	 * */
	public MyAccount() throws Exception {}


	public void clickSignOut() {
		try {
			webdriverutilties.click(findpageObjects.getObject
					(ReadPropertyFiles.readLocatorsFile("SIGNOUT")), 5);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to click on SignOut");
		}
		
	}


	public void validateMyAccountPage() {
		try {
			assertion.isElementDisplayed(findpageObjects.getObject(ReadPropertyFiles.readLocatorsFile("TITLE")), 5);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog("My Account page is not displayed");
		}
		
	}
	
}
