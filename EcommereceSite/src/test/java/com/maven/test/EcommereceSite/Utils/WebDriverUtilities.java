package com.maven.test.EcommereceSite.Utils;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maven.test.EcommereceSite.Base.BaseClass;

public class WebDriverUtilities {
	WebDriverWait     wait;
	WebDriver        driver;
	BaseClass       baseclass      =     new BaseClass();
	
	
	/**
	 * @throws Exception 
	 * @constructor
	 * */
	public WebDriverUtilities() throws Exception {
		this.driver   =  baseclass.getDriver();
	}
	
	
	/**
	 * 
	 * */
	public void click(WebElement element, int timeout) {
		try {
			wait      =     new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			if(element.isDisplayed())
				element.click();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(element.toString() + "not clicked");
			
		}
		
		
	}
	       
	
	
	/**
	 * 
	 * Function to enter value in input boxes
	 * */
	
	public void sendKeys(WebElement element, String valueToEnter, int timeout) {
		try {
			wait       =       new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			
			if(element.isDisplayed()) 
				element.sendKeys(valueToEnter);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(valueToEnter + " not entered in " +element.toString());
		}
	}
	
}
