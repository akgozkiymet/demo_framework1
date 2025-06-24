Feature: Login Functionality

  As a user, I should be able to login

  Scenario: Display login form when user clicks Signup/Login
    Given user is on the home page
    When user clicks on Signup / Login button
    Then login form should be displayed


