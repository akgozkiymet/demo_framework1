@search
Feature: As a user I should be able to search products and see relevant results

  Background:
    Given user is on the home page
    And user navigate to Products page

  Scenario: Verify ability to search for product without user login
    And user searches for "shirt"
    Then user should see "shirt" related products in the resulting page


  Scenario: Verify ability to search for product after user login
    When user is logged in
    And user searches for "shirt"
    Then user should see "shirt" related products in the resulting page

  Scenario: Verify search bar visibility and usability
    Then user should see a search input field with the placeholder text "Search Product"
    Then user should see a search button next to the input field
    And user searches for "shirt"
    Then user should see "shirt" related products in the resulting page

  Scenario: Search for an existing product
    And user searches for "Dress"
    Then user should see the heading "SEARCHED PRODUCTS"
    Then user should see products that contain "Dress" in their name or description

  Scenario: Search for a non-existing product
    And user searches for "test"
    Then I should see no products are displayed

  Scenario: Verify search persistence when navigating back
    And user searches for "Dress"
    And I have clicked on a product detail page
    When I navigate back using the browser back button
    Then the search term "Dress" should still be in the search bar
    And I should see the same searched products displayed



