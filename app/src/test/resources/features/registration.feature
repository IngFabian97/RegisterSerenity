Feature: Registration

  Scenario: Succesful Registration
    Given Fabian wants to register sign up in the aplication
    When Fabian send the required information to sign up
    Then Fabian should have a new account created
