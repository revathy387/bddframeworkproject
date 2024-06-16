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
Feature: Login functionality realted test cases
  I want to use this template for my feature file

  @tag1
  Scenario: To verify that the user enters the valid user name
    Given User opens the browser
    When User navigated to the login page
    And Enter username as "Aditi2013" and validate

  @tag2
  Scenario Outline: Successful Login to the application
    Given User opens the browser
    When User navigated to the login page
    And User enters user name as "<username>" and password as "<password>"
    And Clicks on Login button
    Then the home page is displayed

    Examples: 
      | username  | password | 
      | Aditi2013 |     ABC123 | 
      
