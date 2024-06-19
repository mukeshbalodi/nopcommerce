Feature: verify the cart functionality
Scenario: To verify that User is able to add items into cart

Given user is on Home page
When user select any product from the items
And click on add to cart button
Then user see a message item added into the cart
And user can verify it by clicking on Shopping_cart icon 