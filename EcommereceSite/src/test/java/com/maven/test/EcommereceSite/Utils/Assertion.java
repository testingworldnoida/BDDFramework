package com.maven.test.EcommereceSite.Utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maven.test.EcommereceSite.Base.BaseClass;
import com.vimalselvam.cucumber.listener.Reporter;



public class Assertion {
	WebDriverWait    wait;
	WebDriver        driver;
	BaseClass        baseClass        =    new BaseClass();

	/**
	 * @throws Exception 
	 * @Constructor
	 * */
	public Assertion() throws Exception {
		this.driver       =   baseClass.getDriver();

	}


	/**
	 * Function to check the visibilty of webelement
	 * */

	public void isElementDisplayed(WebElement element, int timeout) {
		try {
			wait      =     new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isDisplayed());
			Reporter.addStepLog(element.toString() + " displayed on the page");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(element.toString() + " not displayed on the page");
			throw new RuntimeException(element.toString() + " not displayed on the page");
		}


	}



	/**
	 * Function to validate if element is visible or not
	 * */
	public boolean isElementPresent(WebElement element , int timeout) {
		boolean   flag     = false;

		try {
			wait      =     new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isDisplayed())
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(element.toString() + " not displayed on the page");
			throw new RuntimeException(element.toString() + " not displayed on the page");
		}
		return flag;
	}


	/**
	 * Function to check two text values
	 * */

	public void  textEqual(WebElement element, String expectedText, int timeout) {
		String actualText = null;

		try {
			wait         =  new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			actualText   =  element.getText();
			Assert.assertEquals(expectedText, actualText);
			Reporter.addStepLog(expectedText   +" matched with " +actualText);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(expectedText   +" matched with " +actualText);
			throw new RuntimeException(expectedText   +" matched with " +actualText);

		}

	}

}
