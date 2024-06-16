#Author: Revathy
#Keywords Summary :
#Feature: Home Page scenarios.
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
Feature: Home Page related features
  I want to use this template for my feature file

  @tag1
  Scenario: Successfully move to DemoBlaze Home Page
    Given User launches the browser
    When User launches the home page
    Then Succesfully navigate to home page
    And shut down the Browser
