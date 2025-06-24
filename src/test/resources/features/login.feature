Feature: Login Functionality

  As a user, I should be able to login

  Scenario: Valid Login
    Given the user clicks Signup / Login from the home page
    When the user enters valid credentials and clicks Login
    Then "Logged in as <username>" message should be displayed
    And the user clicks Delete Account
    Then "ACCOUNT DELETED!" message should be displayed

  Scenario: Invalid Login
    Given the user clicks Signup / Login from the home page
    When the user enters invalid credentials and clicks Login
    Then "Your email or password is incorrect!" error message should be displayed