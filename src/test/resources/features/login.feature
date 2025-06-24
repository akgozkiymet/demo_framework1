Feature: Login Functionality

  As a user, I should be able to login

  Scenario: Display login form when user clicks Signup/Login
    Given user is on the home page
    When user clicks on Signup / Login button
    Then login form should be displayed

  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enters valid email and password
    And clicks on login button
    Then user should see "Logged in as <username>" message

  Scenario: Delete account after successful login
    Given user is logged in
    When user clicks on Delete Account button
    Then user should see "ACCOUNT DELETED!" message
