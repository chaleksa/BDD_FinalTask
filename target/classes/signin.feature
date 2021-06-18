Feature: Sign In
  As a user
  I want to test sign-in functionality
  So that I can be sure that I can login

  Scenario Outline: Check sign-in flow (up to captcha) with valid email and password
    Given User opens '<homePage>' page
    And User opens Sigh-in page
    When User types '<email>' to email input field
    And User clicks continue button
    And User checks password field visibility
    And User types '<password>' to password input field
    And User checks Sign-In button visibility
    And User checks Remember me checkbox visibility
    And User clicks Remember me checkbox
    And User clicks Sign-In button
    Then User checks that captcha is on the page

    Examples:
      | homePage                | email               | password  |
      | https://www.amazon.com/ | vv8241832@gmail.com | vv8241832 |


  Scenario Outline: Check sign-in with not registered email
    Given User opens '<homePage>' page
    And User opens Sigh-in page
    When User types '<email>' to email input field
    And User clicks continue button
    Then User checks that auth error message is visible

    Examples:
      | homePage                | email                  |
      | https://www.amazon.com/ | vasyatest646@gmail.com |