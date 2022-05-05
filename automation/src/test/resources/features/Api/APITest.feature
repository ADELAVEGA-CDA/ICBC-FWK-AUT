Feature: Prueba de API

  @Api
  Scenario: Prueba de un endpoint GET
    Given el sitio: "asd"
    When envío un GET request a la URI "asd"
    Then obtengo 200 como respuesta

  @Api
  Scenario: Valida cantidad de entradas en la respuesta
    Given el sitio: "asd"
    When envío un GET request a la URI "asd"
    Then valido que hay 10 items

  @Api
  Scenario: Token con un POST request
    Given el sitio: "bravenewcoin.p.rapidapi.com"
    When envío un POST request a la URI "/oauth/token"
    Then obtengo un token válido en la respuesta

  @Api
  Scenario: Token inválido con un POST request
    Given el sitio: "bravenewcoin.p.rapidapi.com"
    When envío un POST request a la URI "/oauth/token"
    Then obtengo un token inválido en la respuesta