Feature: Book cheaspter hotel
  As an Administrador
  I want to find cheapest hotels
  for my clients

  Scenario: Inquiry cheapest hotel
    Given that I am on DX HOTELS website
    When I verify the fees of the client with reservation
      | location  | checkIn   | checkOut  |
      | Las Vegas | 7/10/2019 | 7/12/2019 |
    And I choose cheapest hotel
    Then I should see how much I have to pay for the hotel
