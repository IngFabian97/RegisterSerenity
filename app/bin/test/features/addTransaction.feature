Feature: Add new transaction

  Scenario: Add new transaction
    Given Fabian is logged into the application
      | user | pass |
    When Fabian enters the required information for the new transaction
      | 28052025 | 500 | testing description |
    Then Fabian should see a new transaction in the transacation list with correct details
