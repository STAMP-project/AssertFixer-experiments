Feature: TC-104

  TC-104/105/106/107

  checks voor 104 t/m 107 worden hier gedaan

  To verify whether locations in Select Hotel page are displayed according to the location selected in Search Hotel
  1. Launch hotel reservation application using URL as in test data.
  2. Login to the application using username and password as in test data.
  3. Select location as in test data.
  4. Select hotel as in test data.
  5. Select room type as in test data.
  6. Select no-of-rooms as in test data.
  7. Enter check-out-date as in test data.
  8. Select No-of-adults as in test data.
  9. Select No-of-children as in test data.
  10. Click on Search button.
  11. Verify that hotel displayed is the same as selected in search Hotel form.
  URL: http://adactin.com/HotelApp/index.php
  User:{test username}
  Password:{test password}
  Location: Sydney
  Hotel: Hotel Creek
  Room type: standard
  No-of-rooms:1
  Check-in-date: today's date
  Check-out-date:today+1 date
  No-of-adults:1
  No-of-children: 0
  Location displayed in Select Hotel should be the same as location selected in search hotel form.

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