@search
Feature: As a user I should be able to search products and see relevant results

  Background:
    Given user is on the home page

  Scenario: Verify ability to search for product without user login
    And user navigate to Products page
    And user searches for "shirt"
    Then user should see "shirt" related products in the resulting page

  Scenario: Verify ability to search for product after user login
    When user is logged in
    And user navigate to Products page
    And user searches for "jeans"
    Then user should see "jeans" related products in the resulting page

  Scenario: Verify search bar visibility and usability
    And user navigate to Products page
    Then user should see a search input field with the placeholder text "Search Product"
    And user searches for "Top"
    Then user should see "Top" related products in the resulting page

  Scenario: Search for an existing product
    And user navigate to Products page
    And user searches for "Dress"
    Then user should see the heading "SEARCHED PRODUCTS"
    Then user should see "Dress" related products in the resulting page

  Scenario: Search for a non-existing product
    And user navigate to Products page
    And user searches for "test"
    Then user should see no products are displayed

  Scenario: Verify search persistence when navigating back
    And user navigate to Products page
    And user searches for "Dress"
    And user click view product on an item
    When user navigate back using the browser back button
    Then the search term "Dress" should still be in the search bar
    Then user should see "Dress" related products in the resulting page
    Then user should see the same searched "Dress" products displayed



