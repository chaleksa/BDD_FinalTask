Feature: Cart
  As a user
  I want to to be able to use cart
  So that I can manage products that I want to order

  Scenario Outline: Check adding certain product quantity to cart
    Given User opens '<homePage>' page
    And User clicks on top sellers product
    When User changes product quantity to <productQuantity>
    And User clicks add to cart button
    Then User checks that sidebar appears
    And User clicks Cart button on side bar
    And User checks that products quantity in cart is '<productQuantity>'

    Examples:
      | homePage                | productQuantity |
      | https://www.amazon.com/ | 3               |


  Scenario Outline: Check remove all products from cart
    Given User opens '<homePage>' page
    And User clicks on top sellers product
    And User clicks add to cart button
    And User checks that sidebar appears
    And User adds all additional products from side bar
    And User clicks Cart button on side bar
    When User clicks Delete on all products in cart
    Then User checks that products quantity in cart is '<productQuantity>'

    Examples:
      | homePage                | productQuantity |
      | https://www.amazon.com/ | 0               |

