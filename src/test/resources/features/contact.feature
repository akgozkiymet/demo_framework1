@contact
Feature: Contact Us form functionality

  Scenario: Visitor sends a message via Contact Us form
    Given the user is on the homepage
    When the user clicks on Contact Us
    Then the user should see "GET IN TOUCH"
    When the user enters name, email, subject, and message
    And the user uploads a file
    And clicks Submit
    Then an alert should appear with "Success! Your details have been submitted successfully."
    When the user clicks Home
    Then the user should be redirected to the homepage
