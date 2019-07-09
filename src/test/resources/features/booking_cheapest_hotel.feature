Feature: Book cheaspter hotel
  As an Administrador
  I want to find cheapest hotels
  for my clients

  Scenario: Inquiry cheapest hotel
    Given that I am on DX HOTELS website
    When I verify the fees of the client with reservation
      | location      | checkIn  | checkOut |
      | San Francisco | 7/8/2019 | 7/9/2019 |
    And I choose cheapste hotel
