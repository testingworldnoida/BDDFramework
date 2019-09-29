Feature: login
@Regression
Scenario: to test the application for super admin valid credentials
Given user open the browser
When user clicks on sign in link
And user enters username "automationwithpankaj@gmail.com"
And user enters password "test@1234"
And user clicks on Sign in button
Then validate user logged in successfully
When User clicks in SignOut