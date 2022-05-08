Feature:Detect the Limit


  Scenario: The User Converts more amount than what's in his account.
    Given the User enters "1000" as amount
    And the user picks the "EUR" currency as selling type
    And the User picks the "USD" currency as receiving type
    When the User clicks Submit Button
    And the User should be able to see insufficient funds error shown
    Then the Currency Balance isn't affected and not below the zero
