@smokeTest
Feature: To test my cucumber test is running
  I want to run a sample feature file.

  Background:
    Given Open https://fhv-application-staging.herokuapp.com/

  Scenario: Search Pokemon Number
    Given Search for Pokemon Number '1'
    When Result Should be 'bulbasaur'
    Then Run should be successful