@purchase @smoke

Feature: Checkout and Complete Purchase
  As a shopper I want to checkout and complete my purchase, whether I'm registered or not so that I can finalize my order

  Background:
    Given user is on the home page

  Scenario: Complete purchase by registering during checkout
    When user navigate to Products page
    And the user hovers over a product and clicks "Add to cart"
    When the user clicks on View Cart link
    And user clicks Proceed To Checkout button
    And user clicks RegisterLogin on the Checkout modal
    And user creates a new account
    When the user clicks on Cart on homepage
    And user clicks Proceed To Checkout button
    And user clicks Place Order button
    And user enters valid payment information
    And user clicks Pay and Confirm Order button
    Then user should see  "ORDER PLACED!" header
    Then user should see Download Invoice and Continue buttons

 Scenario: Complete purchase after logging in before checkout
   Given user is on the login page
   When user enters valid email and password
   And clicks on login button
   And the user hovers over a product and clicks "Add to cart"
   When the user clicks on View Cart link
   And user clicks Proceed To Checkout button
   And user clicks Place Order button
   And user enters valid payment information
   And user clicks Pay and Confirm Order button
   Then user should see  "ORDER PLACED!" header
   Then user should see Download Invoice and Continue buttons

