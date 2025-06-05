Feature: Registration

  Scenario Outline: Succesful Registration
    Given Fabian wants to register sign up in the aplication
    When Fabian send the required information to sign up
      | <name> | <lastname> | <age> | <country> | <email> |
    Then Fabian should have a new account created

    Examples:
      | name   | lastname | age | country  | email            |
      | Fabian | Guarin   |  28 | Colombia | fabian@email.com |
      | Andres | Fuentes  |  27 | Colombia | fabian@email.com |

  Scenario: Missing required fields for Registration
    Given Fabian wants to register sign up in the aplication
    When Fabian does not send the required information
    Then Fabian should be told all fields are required
