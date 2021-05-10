@runTest
Feature: As a user, I would like to order from automationpractice.com
#/**
#* webautomationexercise
#*
#* @author shanthilalsurana
#**/


  Background: Navigate to Sign in page
    Given I can navigate to the website
    And I can see the website homepage
    When I log in as customer "testexercise@gmail.com" using "123456" password
    Then I can see welcome message on the landing page

  Scenario Outline: As a user I would like to order a new "<T-Shirt name>"
//    Given I am on the account landing page
    Given I click on the "T-shirts" Tab
    And I click on "<T-Shirt name>" product
    And I choose following details in my order
      | Quantity   | Size   | Colour   |
      | <quantity> | <size> | <colour> |
    When I click on Add To Cart button
    And I can see modal confirming product being added to the cart
    And I click on Proceed To Checkout button on pop up
    And I can see "Your shopping cart" form with valid information
    And I click on Proceed To Checkout button
    And I can see "Addresses" form with valid information
    And I click on Proceed To Checkout button
    And I can see "Shipping" form with valid information
    And I choose the shipping option as "My carrier"
    And I select the Terms of Service checkbox
    And I click on Proceed To Checkout button
    And I can see "Your payment method" form with valid information
    And I choose a payment method "<payment method>"
    And I click on I Confirm My Order button
    And I can see "Order confirmation" form with valid information
    Then I click on Back To Order button
    And I can see the Order Reference of the order placed

    Examples:
      | T-Shirt name                | quantity | size | colour | payment method   |
      | Faded Short Sleeve T-shirts | 1        | S    | Orange | Pay by bank wire |