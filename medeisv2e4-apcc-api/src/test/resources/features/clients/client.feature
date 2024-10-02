@regression @client
Feature: Client
  As a user
  I want to be able to manage clients
  So that I can create, update, delete and list clients

  @testCase1
  Scenario Outline: User creates a new client
    When I send a request to POST client endpoint 'clients' with the following data
      | code         | <code>         |
      | name         | <name>         |
      | ciNit        | <ciNit>        |
      | documentType | <documentType> |
      | email        | <email>        |
    Then I should receive a response with status 200
    And I should receive a response with the following data
      | success | true                             |
      | message | Cliente registrado correctamente |
    And the response should contain the following data
      | code         | <code>         |
      | name         | <name>         |
      | ciNit        | <ciNit>        |
      | documentType | <documentType> |
      | email        | <email>        |
    Examples:
      | code   | name             | ciNit     | documentType | email               |
      | {code} | test auto name   | 123456789 | CI           | juanperez@mail.com  |
      | {code} | test auto name 1 | 123456789 | CI           | juanperez1@mail.com |
      | {code} | test auto name 2 | 123456789 | CI           | juanperez2@mail.com |
