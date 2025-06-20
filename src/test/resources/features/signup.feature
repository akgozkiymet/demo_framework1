Feature: As a new user I want to sign up for an account, so that I can access my account

  Background:
    Given user is on the home page
    And user click Signup/Login page

  Scenario: verify New User Signup! visible on the Signup/Login page
    Then user should see New User Signup! title

  Scenario: verify user able to input name and email to signup
    And user enters name under New User Signup!
    And user enters email under New User Signup!
    And user clicks Signup button
    Then user should land on signup form page

    #TODO implement negative scenario for signup

    Scenario: user signup flow
      And user enters name under New User Signup!
      And user enters email under New User Signup!
      And user clicks Signup button
      And user fills valid account info and address and click create account
      Then user sees "ACCOUNT CREATED!" text in header
      Then user sees "Congratulations! Your new account has been successfully created!" message
      And user clicks continue button
      Then user should land on home page and see their name beside Logged in as <name>




