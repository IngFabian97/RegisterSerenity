Feature: Add new transaction

  Scenario: Ad new transaction
    Given Fabian is logged into the application
    When Fabian enters the required information for the new transaction
    Then Fabian should see a new transaction in the transacation list with correct details
