Feature: Convert the currency


  Scenario: The User Converts Euro to Dollar
    Given the User enters "100" as amount
    And the user picks the "EUR" currency as selling type
    And the User picks the "USD" currency as receiving type
    When the User clicks Submit Button
    And the User Clicks ok when an alert seen
    And the "EUR" balance reduced to "900.00"
    Then the "USD" balance should be "1105.50"


  Scenario: The User Converts Euro to Swiss Franc
    Given the User enters "100" as amount
    And the user picks the "EUR" currency as selling type
    And the User picks the "CHF" currency as receiving type
    When the User clicks Submit Button
    And the User Clicks ok when an alert seen
    And the "EUR" balance reduced to "900.00"
    Then the "CHF" balance should be "104.27"


  Scenario: The User Converts Dollar to GBP
    Given the User enters "100" as amount
    And the user picks the "USD" currency as selling type
    And the User picks the "GBP" currency as receiving type
    When the User clicks Submit Button
    And the User Clicks ok when an alert seen
    And the "USD" balance reduced to "900.00"
    Then the "GBP" balance should be "81.06"

    @wip
  Scenario: The User Converts Euro to CAD
    Given the User enters "100" as amount
    And the user picks the "EUR" currency as selling type
    And the User picks the "CAD" currency as receiving type
    When the User clicks Submit Button
    And the User Clicks ok when an alert seen
    And the "EUR" balance reduced to "900.00"
    Then the "CAD" balance should be "136.19"


  Scenario: The User Converts Euro to JPY
    Given the User enters "100" as amount
    And the user picks the "EUR" currency as selling type
    And the User picks the "JPY" currency as receiving type
    When the User clicks Submit Button
    And the User Clicks ok when an alert seen
    And the "EUR" balance reduced to "900.00"
    Then the "JPY" balance should be "13768"