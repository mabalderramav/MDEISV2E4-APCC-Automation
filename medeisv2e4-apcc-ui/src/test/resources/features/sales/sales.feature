@regression @sales
Feature: Sales
  As a user
  I want to register a sale
  So that I can keep track of my sales

  Scenario Outline: Register a sale
    Given I go to home page
    And I am on the sales page
    When I fill in the client section
      | Codigo Cliente | <code>         |
      | Tipo Pago      | <payCondition> |
    And I fill on the details product section
      | Codigo Producto | Producto   | Precio |
      | 1               | Producto 1 | 1000   |
      | 2               | Producto 2 | 2000   |
      | 3               | Producto 3 | 3000   |
    And I click on 'Registrar Factura' button
    Then I should display a "Guardado correctamente" message on sales page
    Examples:
      | code | payCondition |
      | 1    | Efectivo     |
      | 8    | Tarjeta      |
      | 9    | Efectivo     |


