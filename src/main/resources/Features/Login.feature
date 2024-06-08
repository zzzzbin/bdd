# Author: Trung
# Date: 2024
Feature: feature to test login function
  Scenario: Check login is successful with valid credentials
    Given browser is open2
    And user is on login page
    When  user enters username and password
    Then user is navigated to the home page
