Feature: WALK London Homepage

  Scenario: Verify homepage is loaded
    Given I am on www.walklondonshoes.co.uk homepage
    Then I verify that the title contains WALK London Shoes

    Scenario: Verify the shop now link is working
      Given I am on www.walklondonshoes.co.uk homepage
      When I click on the "Shop Now" link
      Then I verify that the Shop Now page is displayed