#Author: Revathy
#Keywords Summary :
#Feature: Registration scenarios.
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
Feature: Registration related feature
  I want to use this template for my feature file

  @tag1
  Scenario: Registration functionality
    Given User navigates to home page
    When User clicks on sign up link
    And User enters the required details to signup
    Then User has successfully registered
