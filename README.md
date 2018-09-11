# CucumberDemo
Cucumber demo bij Atos test competence

Build status: [![Circle CI](https://circleci.com/gh/vincentfree/TreeAPI.svg?style=svg)](https://circleci.com/gh/vincentfree/TreeAPI)

# Benodigdheden voor de demo zijn
- Java IDE met cucumber plugin. 
- Selenium wordt aan de hand van de pom geimporteerd.
- Firefox (wordt als webdriver gebruikt)

---
voorbeeld stukje Gerkin, hier wordt een Scenario outline gebruikt:
```cucumber
Scenario Outline: verify whether the check-out date field accepts a later date than check-in date
  Given I am on the adactin site
  When I set the location to "<Location>"
  And I select Hotel "<Hotels>"
  And I select Room type "<Roomtype>"
  Then the search results in an error message
Examples:
  |Location  |Hotels        |Roomtype  |
  |Sydney    |Hotel Creek   |Standard  |
  |London    |Hotel Sunshine|Double    |
```
Voorbeeld van een normaal Scenario:
```cucumber
Scenario: verify whether locations in Select Hotel page are displayed
    Given I am on the adactin site
    And I log in with my credentials
    And I am logged in
    When I set the location to "Sydney"
    And I select Hotel "Hotel Creek"
    And I select Room type "Standard"
    And I select the number of rooms "1"
    And I select the amount of adults "1"
    And I select the amount of children "0"
    And the day that I check in is "0" days from now
    And the day that I check out is "1" days from now
    Then The right hotel should be shown
```

