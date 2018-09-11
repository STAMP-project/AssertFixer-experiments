Feature: TC-101

  TC-101
  To verify valid login
  Details
  1. Launch hotel reservation application using URL as in test data.
  2. Login to the application using username and password as in test data.
  URL:http://adactin.com/HotelApp/index.php
  User:{test username}
  Password:{test password}
  User should login to the application

  Scenario: verify valid login
    Given I am on the adactin site
    When I log in with my credentials
    Then I am logged in

  Scenario: Log in with wrong credentials
    Given I am on the adactin site
    When I log in with the wrong credentials
    Then I should get a message