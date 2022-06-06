@CHROME
Feature: Ingresar al homebanking personas a buscar un producto en los ofrecidos por ICBC
  Como un usario individuo
  Quiero realizar una busqueda de un producto
  Para encontrar los productos ofrecidos por ICBC

  @Home @URL @Scenario @ScenTitle1 @issue=<ISSUE-NUMBER> @tmsLink=<TEST-CASE-ID> @severity=normal
  Scenario: accedo al homebanking individuos
#    Given accedo al homebanking individuo
    When hago clic en el menu Personas de la pagina Personas
    And hago clic en la solapa Productos y Servicios de la pagina Personas
    And hago clic en la opcion Paquetes de la pagina Personas
    Then accedo a los productos y servicios de la pagina Paquetes

  @Home @Title @Scenario @ScenTitle @issue=<ISSUE-NUMBER> @tmsLink=<TEST-CASE-ID>
  Scenario: acceso al homebanking individuos y consulto paquetes
#    Given accedo al homebanking individuo
    When hago clic en el menu Personas de la pagina Personas
    And hago clic en la solapa Productos y Servicios de la pagina Personas
    And hago clic en la opcion Paquetes de la pagina Personas
    Then accedo a "Paquetes | Cuentas, Productos y Servicios a tu Medida | ICBC" de la pagina Paquetes

  @Home @Title @Scenario @ScenTitle @issue=<ISSUE-NUMBER> @tmsLink=<TEST-CASE-ID>
  Scenario: acceso al homebanking individuos y consulto paquetes
#    Given accedo al homebanking individuo
    When hago clic en el menu Personas de la pagina Personas
    And hago clic en la solapa Productos y Servicios de la pagina Personas
    And hago clic en la opcion Paquetes de la pagina Personas
    Then accedo a "Paquetes | ICBC" de la pagina Paquetes
   
   