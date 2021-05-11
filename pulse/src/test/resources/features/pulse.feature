@AllScenarios
Feature: Verifying Home page presented with a carousel displaying Three featured articles.

  @Scenario01
  Scenario: Verifying after clicking on the Next button on the carousel should load the next 3 featured articles.
    Given I navigate to the PwC Digital Pulse website
    When I am viewing the 'Home' page
    Then I am presented with a carousel displaying 3 featured articles
    And Clicking the 'Next' button on the carousel will load the next 3 featured articles
    And Clicking the 'Previous' button on the carousel will load the previous 3 featured articles

  @Scenario02
  Scenario: Verifying the Contact us page details
    Given I navigate to the PwC Digital Pulse website
    When I select 'Contact us' from the hamburger menu
    Then I am taken to the 'Contact us' page
    And I am presented with the below options for contacts

  @Scenario03
  Scenario: Performing a search functionality on the Home Page
    Given I navigate to the PwC Digital Pulse website
    When I click on the 'Magnifying glass' icon to perform a search
    And I enter the text 'Single page applications'
    And I submit the search
    Then I am taken to the search results page
    And I am presented with at least 1 search result