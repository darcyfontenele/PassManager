Feature: Buy a ticket
  As a user
  I want to buy a ticket to travel in metro
  As a system
  I need to return a status to user request

  Scenario Outline: Buy a <type> ticket with R$ <num> in my bank
    Given I have <num> in my bank
    When I buy a <type> ticket
    Then System return success or fail <status>

  Examples:
    | type | num | status |
    | "BZONEDAILY" | 100 | true |
    | "AZONEUNIQUE" | 4 | false |
