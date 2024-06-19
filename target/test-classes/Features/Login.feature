Feature: Login feature
Scenario: Verify the login functionality with valid creds

Given user is on Home page
When user click on login button
Then user should redirect to login page
And user fill the data into email and password fields
And clicks on LOG_IN Button
Then user should nevigate to Home page
