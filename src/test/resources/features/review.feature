@review
Feature: As a user I want to submit reviews, so that I can share feedback

  Background:
    Given user navigate to Products page
    And user click view product on an item
    And user is on the product detail page

  Scenario: Display review submission form
    Then user should see form with fields for name, email and review
    Then user should see submit button

  Scenario Outline: Successfully submit a product review
    When user enters name "<name>"
    And user enters email "<email>"
    And user enters review "<review>"
    And user submits the review
    Then user should see confirmation message "Thank you for your review."

    Examples:
      | name | email            | review              |
      | Sora | sora@email.com   | Thank you           |
      | Nina | nina20@email.com | The fit is not good |