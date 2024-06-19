Feature: Register page Functionality
Scenario: user is able to regiaster

Given user is on Home page
When user click on Register button on Header
Then user should redirect to Register page 
And user fill the form
And click on REGISTER button
Then user should be register successfully

