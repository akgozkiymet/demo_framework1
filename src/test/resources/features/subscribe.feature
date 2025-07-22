@subscribe
Feature: User should be able to subscribe

  Background:
    Given user is on the home page

  Scenario Outline: verify guest user subscription from homepage
    And user enters valid email "<email>" to subscribe to email updates
    Then user should see the subscription success message "You have been successfully subscribed!"
    Examples:
      | email          |
      | abc@abc.com    |
      | coffee@abc.com |
      | mocha@abc.com  |

  Scenario: verify guest user subscription from cart page
    And user navigates to cart
    And user enters valid email "cortado@abc.com" to subscribe to email updates
    Then user should see the subscription success message "You have been successfully subscribed!"

  Scenario: verify authenticated user subscription from homepage
    When user is logged in
    And user enters valid email "latte@abc.com" to subscribe to email updates
    Then user should see the subscription success message "You have been successfully subscribed!"

  Scenario: verify authenticated user subscription from cart page
    When user is logged in
    And user navigates to cart
    And user enters valid email "frappucino@abc.com" to subscribe to email updates
    Then user should see the subscription success message "You have been successfully subscribed!"


#    Scenario: verify user receive error message when incomplete email entered
#    Scenario: verify user receive error message when partial email entered
