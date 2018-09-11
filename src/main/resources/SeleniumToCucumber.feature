Feature: Find the cheese

  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "cheese"
    Then the page title should start with "cheese"

  Scenario Outline: find more things
    Given I am on the Google search page
    When I search for this"<searchQuery>"
    Then the page title should start with "<searchQuery>"
  Examples:
    | searchQuery |
    |apple        |
    |cucumber     |
    |cheese       |
    |rose         |
    |bears        |
    |aapje        |