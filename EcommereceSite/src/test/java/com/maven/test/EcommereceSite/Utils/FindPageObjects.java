package com.maven.test.EcommereceSite.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.maven.test.EcommereceSite.Base.BaseClass;

public class FindPageObjects {
	WebDriver   driver;
	BaseClass        baseclass         =    new BaseClass();

	/**
	 * @throws Exception 
	 * @constructor
	 * */
	public FindPageObjects() throws Exception {
		this.driver 		=	      baseclass.getDriver();

	}


	/**
	 *Function to get the webelement
	 */


	public WebElement getObject(String locator) {
		WebElement   element = null;
		String[] locatorvalue   =    locator.split("~");

		String locType  = locatorvalue[0];
		String locValue  =locatorvalue[1];


		if(locType.equalsIgnoreCase("ID")) {
			element = driver.findElement(By.id(locValue));

		}

		else if(locType.equalsIgnoreCase("NAME")) {
			element = 	driver.findElement(By.name(locValue));

		}

		else if(locType.equalsIgnoreCase("XPATH")) {
			element= driver.findElement(By.xpath(locValue));

		}

		else if(locType.equalsIgnoreCase("CSS")) {
			element = 	driver.findElement(By.cssSelector(locValue));

		}

		else if(locType.equalsIgnoreCase("LINKTEXT")) {
			element  = driver.findElement(By.linkText(locValue));

		}
		else if(locType.equalsIgnoreCase("PARTIALLINKTEXT")) {
			element = 	driver.findElement(By.partialLinkText(locValue));

		}

		else if(locType.equalsIgnoreCase("CLASS")) {
			element = driver.findElement(By.className(locValue));

		}

		else if(locType.equalsIgnoreCase("TAG")) {
			element = 	driver.findElement(By.tagName(locValue));

		}

		else {
			System.out.println("Invalid locator..");
		}
		return element;
	}

}


