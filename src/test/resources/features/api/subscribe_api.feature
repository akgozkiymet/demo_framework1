Feature: Email subscription API

  Scenario: Subscribe with valid email
    Given I have the subscription API endpoint
    When I send a POST request with email "test@example.com"
    Then the response status code should be 200
    And the response message should contain "success"
