@regression @client
Feature: Client
  As a user
  I want to be able to manage clients
  So that I can create, update, delete and list clients

  @testCase1
  Scenario: User creates a new client
    When I send a request to POST client endpoint 'clients' with the following data
      | code         | {code}             |
      | name         | test auto name     |
      | ciNit        | 123456789          |
      | documentType | CI                 |
      | email        | juanperez@mail.com |
    Then I should receive a response with status 200
    And I should receive a response with the following data
      | success | true                             |
      | message | Cliente registrado correctamente |