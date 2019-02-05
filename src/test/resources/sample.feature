@smokeTest
Feature: To test my cucumber test is running
  I want to run a sample feature file.

  Background:
    Given Open https://fhv-application-staging.herokuapp.com/

  Scenario: cucumber setup
    Given Sample feature file is ready
    When I run the feature file
    Then Run should be successful