Feature: Filtering
  As a user
  I want to to be able to filter products
  So that I can choose products easier

  Scenario: Apply Brand filter to products
    Given User opens 'https://www.amazon.com/' page
    And User clicks on menu button
    And User clicks on Electronics menu element
    And User clicks on HeadPhones menu element
    When User chooses filter by Sony brand
    Then User checks that all products belong to Sony brand


  Scenario Outline: Apply Price filter to products
    Given User opens '<homePage>' page
    And User clicks on menu button
    And User clicks on Electronics menu element
    And User clicks on HeadPhones menu element
    When User chooses filter by price from '<minPrice>' to '<maxPrice>'
    Then User checks that all products have price from '<minPrice>' to '<maxPrice>'

    Examples:
      | homePage                | minPrice | maxPrice |
      | https://www.amazon.com/ | 0        | 400      |


  Scenario Outline: Apply Price filters with negative values
    Given User opens '<homePage>' page
    And User clicks on menu button
    And User clicks on Electronics menu element
    And User clicks on HeadPhones menu element
    When User chooses filter by price from '<minPrice>' to '<maxPrice>'
    Then User checks that price filters were not applied

    Examples:
      | homePage                | minPrice | maxPrice |
      | https://www.amazon.com/ | -20      | -600     |



