Feature: Search
  As a user
  I want to test search field functionality
  So that I can be sure that search works correctly

  Scenario Outline: Check search by keyword
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User clicks search button
    Then User checks that current url contains '<request>'

    Examples:
      | homePage                | keyword | request |
      | https://www.amazon.com/ | lego    | k=lego  |


  Scenario Outline: Check search by mistyped keyword
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by '<mistyped keyword>'
    And User clicks search button
    Then User checks word suggestion banner visibility
    And User checks that message contains '<corrected keyword>' suggestion

    Examples:
      | homePage                | mistyped keyword | corrected keyword |
      | https://www.amazon.com/ | puzle            | puzzle            |
      | https://www.amazon.com/ | leggo            | lego              |