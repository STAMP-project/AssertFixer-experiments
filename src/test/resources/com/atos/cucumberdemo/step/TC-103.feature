Feature: TC-103

  TC -103
  To check if error is reported if check-out date field is in the past
  1. Launch hotel reservation application using URL as in test data.
  2. Login to the application using username and password as in test data.
  3. Select location as in test data.
  4. Select hotel as in test data.
  5. Select room type as in test data.
  6. Select no-of-rooms as in test data.
  7. Enter check-out-date as in test data.
  8. Verify that application throws error message
  URL: http://adactin.com/HotelApp/index.php
  User:{test username}
  Password:{test password}
  Location: Sydney
  Hotel: Hotel Sunshine
  Room type: Double
  No-of-rooms:2
  Check-in-date: today's -5 date
  Check-out date: today's -3 date
  System should report an error message 'Enter Valid dates'

  Scenario: check if error is reported if check-out date field is in the past
    Given I am on the adactin site
    And I log in with my credentials
    And I am logged in
    When I set the location to "Sydney"
    And I select Hotel "Hotel Sunshine"
    And I select Room type "Double"
    And I select the number of rooms "2"
    And I select the amount of adults "1"
    And the day that I check in is "-5" days from now
    And the day that I check out is "-3" days from now
    Then The system should report an error message 'Enter Valid dates'
