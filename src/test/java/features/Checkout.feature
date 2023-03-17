#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Place order for products
	
	@Order
  Scenario Outline: Search experience
    Given User is in GreenKart landing page
    When User searches with shortname <Item> and extract the actual name of product
    And User added "3" itemes of the selected products to cart
    Then User proceeds to Checkout and validate <Item> items in checkout page
    And User verify has ability to enter promo code and place the order
				
	Examples:
	|Item|
	|Tom|
	|Stra|