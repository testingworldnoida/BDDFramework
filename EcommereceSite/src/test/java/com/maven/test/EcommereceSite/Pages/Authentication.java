package com.maven.test.EcommereceSite.Pages;

import com.maven.test.EcommereceSite.Utils.FindPageObjects;
import com.maven.test.EcommereceSite.Utils.ReadPropertyFiles;
import com.maven.test.EcommereceSite.Utils.WebDriverUtilities;
import com.vimalselvam.cucumber.listener.Reporter;

public class Authentication {


	FindPageObjects         findpageObjects            =               new     FindPageObjects();
	WebDriverUtilities      webdriverutilties          =               new     WebDriverUtilities(); 


	/**
	 * @constructor
	 * */
	public Authentication() throws Exception {}



	/**
	 * Function to enter username
	 * */
	public void enterUserName(String usernName) {
		try {
			webdriverutilties.sendKeys(findpageObjects.
					getObject(ReadPropertyFiles.readLocatorsFile("EMAIL")), usernName, 2);
			Reporter.addStepLog(usernName + "entered in UserName input box");

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(usernName + "not entered in UserName input box");
			throw new RuntimeException(usernName +"not entered in UserName input box");
		}

	}



	/**
	 * Function to enter password
	 * */
	public void enterPassword(String password) {
		try {
			webdriverutilties.sendKeys(findpageObjects.
					getObject(ReadPropertyFiles.readLocatorsFile("PWD")), password, 2);
			Reporter.addStepLog(password + "entered in password input box");

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(password + "not entered in password input box");
			throw new RuntimeException(password +"not entered in password input box");
		}

	}


	public void clickSubmit() {
		
		try {
			webdriverutilties.click(findpageObjects.getObject
					(ReadPropertyFiles.readLocatorsFile("SUBMIT")), 3);
			Reporter.addStepLog("Click Performed on Submit button");
			
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog("Unable to click on Submit button");
			throw new RuntimeException("Unable to click on Submit button");
		}
	}

}
