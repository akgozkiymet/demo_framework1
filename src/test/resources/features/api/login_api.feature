@api
Feature: Login API - AutomationExercise.com

  Background:
    Given the API base URL

  Scenario: Successful login with valid credentials
    When a POST request is sent with following login info:
      | email    | validuser@example.com |
      | password | validpassword         |
    Then response status code should be 200
    And response message should be "User exists!"

  Scenario: Login with missing email parameter
    When a POST request is sent with following login info:
      | password | somepassword |
    Then response status code should be 400
    Then response message should be "Bad request, email or password parameter is missing in POST request."

  Scenario: Login with invalid email or password
    When a POST request is sent with following login info:
      | email    | fakeuser@nowhere.com |
      | password | wrongpass            |
    Then response status code should be 404
    And response message should be "User not found!"

  Scenario: Login attempt with unsupported HTTP method
    When a DELETE request is sent to "/verifyLogin"
    Then response status code should be 405
    And response message should be "This request method is not supported."
