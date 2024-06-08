Feature: Check google search function
  Scenario: Validate google search is working
    Given browser is open
    And user is on googlge search page
    When user entersma text in google search box
    And hits Enter
    Then user is navigated to the Search Result page

