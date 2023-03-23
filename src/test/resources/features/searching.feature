@integration-test

Feature: Trending search

  @google
  Scenario: Find the abbreviation
    Given I am on the Google Search page
    When I search with the keyword "tgif stands for"
    Then I see the answer "thank God it's Friday" is highlighted
    And I want to close browser

  @youtube
  @google
  Scenario: Search Trending Music on Google
    Given I am on the Google Search page
    When I search with the keyword "ung qua chung loop version youtube"
    Then The search result number 1 will be the song "ưng quá chừng (loop version)"
    And I can play it on Youtube
    Then I want to close browser
