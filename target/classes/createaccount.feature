Feature: Create Account
  As a user
  I want to to be able to register
  So that I can create my account

  Scenario Outline: Check 'Create account' error alerts for empty fields
    Given User opens '<homePage>' page
    And User opens Sigh-in page
    And User clicks Create account button
    When User clicks Continue button
    Then User checks that Name, Email and Password fields have an alerts
    And User checks text for Name field alert is '<empty name alert>'
    And User checks text for Email field alert is '<empty email alert>'
    And User checks text for Password field alert is '<empty password alert>'
    And User checks that Re-enter password field has no alerts

    Examples:
      | homePage                | empty name alert | empty email alert | empty password alert |
      | https://www.amazon.com/ | Enter your name  | Enter your email  | Enter your password  |
