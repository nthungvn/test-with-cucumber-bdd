@integration-test

Feature: Trending search

  @youtube
  Scenario: Search Trending Music on Google
    Given I am on the Google Search page
    And I search with the keyword "ung qua chung loop version youtube"
    Then The search result number 1 will be the song "ưng quá chừng (loop version)"
    And I can play it on Youtube
    Then I want to close browser
