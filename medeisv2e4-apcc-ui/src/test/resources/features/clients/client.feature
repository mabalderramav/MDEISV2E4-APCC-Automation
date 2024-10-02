@regression @client
Feature: Client

  Scenario Outline: Create a new client
    Given I am go to home page
    And I am on the client page
    Given I fill in the client form
      | name         | <name>         |
      | ciNit        | <ciNit>        |
      | documentType | <documentType> |
      | email        | <email>        |
    And I click on the save button
    Then I should display a "Guardado correctamente" message
    Examples:
      | name                 | ciNit     | documentType | email                 |
      | test auto ui name    | 123456789 | CI           | juanperez@mail.com    |
      | test auto ui name 1  | 123456789 | CI           | juanperezui1@mail.com |
      | test auto ui name  2 | 123456789 | CI           | juanperezui2@mail.com |