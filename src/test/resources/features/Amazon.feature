@Amazon
Feature: Probar la funcionalidad de búsqueda en Amazon

  @Cart
  Scenario Outline: Como cliente, cuando busco <Producto>, quiero verificar si la tercera opción en la segunda página está disponible y puede ser agregada al carrito.
    Given el usuario navega a www.amazon.com
    And busca <Producto>
    And navega a la segunda página
    And selecciona el tercer artículo
    Then el usuario puede agregarlo al carrito

    Examples:
      | Producto  |
      | Alexa     |
