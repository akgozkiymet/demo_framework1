Feature: As a user I should be able to search products and see relevant results

  Background:
    Given user is on the home page

  Scenario: Verify ability to search for product without user login
    And user searches for "shirt"
    Then user should see "shirt" related products in the resulting page

  Scenario: Verify ability to search for product after user login
    When user is logged in
    And user searches for "shirt"
    Then user should see "shirt" related products in the resulting page