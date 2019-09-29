package com.maven.test.EcommereceSite.StepDefs;


import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.maven.test.EcommereceSite.Base.BaseClass;
import com.maven.test.EcommereceSite.Pages.Authentication;
import com.maven.test.EcommereceSite.Pages.HomePage;
import com.maven.test.EcommereceSite.Pages.MyAccount;
import com.maven.test.EcommereceSite.Utils.ReadPropertyFiles;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {
	WebDriver  			driver;
	BaseClass       	baseclass          =     new      BaseClass();
	HomePage        	homepage           =     new      HomePage();
	Authentication      authenticatio      =     new      Authentication();
	MyAccount           myAccount          =     new      MyAccount();



	@Before
	public void init() {
		// Before Hooks

	}


	public StepDefs() throws Exception {
		this.driver     =     baseclass.getDriver();
	}


	@Given("^user open the browser$")
	public void user_open_the_browser() throws Throwable {
		driver.get(ReadPropertyFiles.readConfigFile("URL"));
		driver.manage().window().maximize();
		
	}

	@When("^user clicks on sign in link$")
	public void user_clicks_on_sign_in_link() throws Throwable {
		homepage.ClickSignIn();
	}

	@When("^user enters username \"(.*?)\"$")
	public void user_enters_username(String username) throws Throwable {
		authenticatio.enterUserName(username);
	}

	@When("^user enters password \"(.*?)\"$")
	public void user_enters_password(String password) throws Throwable {
		authenticatio.enterPassword(password);

	}

	@When("^user clicks on Sign in button$")
	public void user_clicks_on_Sign_in_button() throws Throwable {
		authenticatio.clickSubmit();
	}



	@Then("^validate user logged in successfully$")
	public void validate_user_logged_in_successfully() throws Throwable {
		myAccount.validateMyAccountPage();
	}

	@When("^User clicks in SignOut$")
	public void user_clicks_in_SignOut() throws Throwable {
		myAccount.clickSignOut();
	}

	
	@Then("^Validate home page URl is \"(.*?)\" displaying$")
	public void validate_home_page_URl_is_displaying(String expURL) throws Throwable {
	    homepage.validateHomePage(expURL);
	}
	

	

	@After
	public void tearDown(Scenario  scenario) {
     if(scenario.isFailed()) {
			byte[]    screenshot  =      ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}

		if(driver!=null) {
			driver.close();
			baseclass.setDriver();
		}
	}


}
