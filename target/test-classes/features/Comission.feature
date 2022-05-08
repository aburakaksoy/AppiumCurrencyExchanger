Feature: Detect the commission

  Scenario:The User does more than five currency exchanges
    Given the User enters "100" as amount
    And the user picks the "EUR" currency as selling type
    And the User picks the "USD" currency as receiving type
    When the User clicks Submit Button
    And the User Clicks ok when an alert seen
    And the "EUR" balance reduced to "900.00"
    Then the "USD" balance should be "1105.50"
    When the User clicks Submit Button
    And the "EUR" balance reduced to "800.00"
    Then the "USD" balance should be "1211.00"
    When the User clicks Submit Button
    And the "EUR" balance reduced to "700.00"
    Then the "USD" balance should be "1316.5"
    When the User clicks Submit Button
    And the "EUR" balance reduced to "600.00"
    Then the "USD" balance should be "1422.00"
    When the User clicks Submit Button
    And the "EUR" balance reduced to "500.00"
    Then the "USD" balance should be "1527.5"
    When the User clicks Submit Button
    Then the commission fee should be displayed in the message
    And the "EUR" balance reduced to "399.65"
    Then the "USD" balance should be "1633.00"





