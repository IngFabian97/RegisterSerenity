Feature: Registration

  Scenario: Succesful Registration
    Given Fabian wants to register sign up in the aplication
    When Fabian send the required information to sign up
    Then Fabian should have a new account created

  Scenario: Missing required fields for Registration
    Given Fabian wants to register sign up in the aplication
    When Fabian does not send the required information
    Then Fabian should be told all fields are required
