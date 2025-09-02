@addToCart
Feature: Add items to shopping cart

  Scenario: Add product to cart from Products page
    Given the user is on the Products page
    When the user hovers over a product and clicks "Add to cart"
    Then the product should be added to the cart
    And the user should see options to "Continue Shopping" or "View Cart"

  Scenario: View cart with added items
    When user is on the home page
    And user navigate to Products page
    And the user hovers over a product and clicks "Add to cart"
    When the user clicks on View Cart link
    Then the cart should display each item with name, price, quantity, and total price

  Scenario: Add product with custom quantity
    Given user navigate to Products page
    And user click view product on an item
    And user is on the product detail page
    When the user sets the quantity to 3 and clicks "Add to cart"
    Then the cart should reflect the quantity as 3 for that product

  Scenario: User removes item from the cart
    Given the user has added items to the cart
    When the user clicks on "Cart"
    And the user removes the item from the cart
    Then the cart should be empty