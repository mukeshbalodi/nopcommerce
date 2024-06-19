Feature: order flow functionality
Scenario: User is able to book an item

Given user is on Home page
When user select any product from the items
And click on add to cart button
Then user see a message item added into the cart
And user can verify it by clicking on Shopping_cart icon 
And fill the entries before clicking on checkout button
And click on checkout button 
And fill the Fill address form on Billing Address page
Then select shipping method
And click on continue button on shipping method page
Then select payment method 
And click on continue button on payment method page
Then click on continue on payment information page
Then click on confirm  button on confirm order page
Then order will place successfully

