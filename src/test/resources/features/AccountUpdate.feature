@runTest
Feature: As a user, I would like to update account information on automationpractice.com
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

  Scenario Outline: As a user I would like to change first name
    Given I am on the account landing page
    And I click on the My Personal info link
    And I change first name to "<First Name>"
    And I enter current password as "123456"
    When I click on Save button
    Then I can see "Your personal information has been successfully updated."
    And I click on the My Personal info link
    And I can see that first name is changed to "<First Name>"

    Examples:
      | First Name |
      | Test       |