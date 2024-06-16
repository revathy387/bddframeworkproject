#Author: Revathy
#Keywords Summary :
#Feature: Login Module scenarios.
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
@tag
Feature: Login functionality related feature
  I want to use this template for my feature file

  @tag1
  Scenario: Valid Login Functionality
    Given User launches the web page
    When User logins to the application
    And User enters valid login data
    Then Successfull login
    
 @tag1
  Scenario: Invalid Login Functionality
    Given User launches the web page
    When User logins to the application
    And User enter invalid login data
    Then Alert is displayed 
