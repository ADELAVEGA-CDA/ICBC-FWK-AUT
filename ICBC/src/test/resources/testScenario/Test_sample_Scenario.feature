
Feature: Ingresar al homebanking personas a buscar un producto en los ofrecidos por ICBC
	Como un usario individuo
  Quiero realizar una busqueda de un producto
  Para encontrar los productos ofrecidos por ICBC

  @Home @URL @Scenario @ScenURL
  Scenario: accedo al homebanking individuos
    Given accedo al homebanking individuo
    When hago clic en el menú Personas de la página Personas
    And hago clic en la solapa Productos y Servicios de la página Personas
    And hago clic en la opción Paquetes de la página Personas
    Then accedo a los productos y servicios de la página Paquetes

  @Home @Title @Scenario @ScenTitle
  Scenario: acceso al homebanking individuos y consulto paquetes
    Given accedo al homebanking individuo
    When hago clic en el menú Personas de la página Personas
    And hago clic en la solapa Productos y Servicios de la página Personas
    And hago clic en la opción Paquetes de la página Personas
    Then accedo a "Paquetes | Cuentas, Productos y Servicios a tu Medida | ICBC" de la página Paquetes
    