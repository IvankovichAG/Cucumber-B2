Feature: Google Search Functionality Title Validation
  User Story: As a user, when I am on Google search page
  I should be able search whatever I want and see relevant information


  Scenario: Search functionality result title validation
    Given user is on Google search page
    When user types Loop Academy in the google search box and clicks enter
    Then user should see Loop Academy - Google Search in the google title


  Scenario: Search functionality result title validation
    Given user is on Google search page
    When user types "Loop Academy" in the google search box and clicks enter
    Then user should see "Loop Academy - Google Search" in the google title

  @annaI
  Scenario: Search functionality result title validation
    Given user is on Google search page
    When user types "Feyruz is Java King" in the google search box and clicks enter
    Then user should see "Feyruz is Java King - Google Search" in the google title