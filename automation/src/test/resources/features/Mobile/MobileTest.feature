Feature: Ingresar al homebanking personas a buscar un producto en los ofrecidos por ICBC
  Como un usario individuo
  Quiero realizar una busqueda de un producto
  Para encontrar los productos ofrecidos por ICBC

  @Mobile
  Scenario: accedo al homebanking individuos
    When hago clic en el menu Personas de la pagina Personas
    And hago clic en la solapa Productos y Servicios de la pagina Personas
    And hago clic en la opcion Paquetes de la pagina Personas
    Then accedo a los productos y servicios de la pagina Paquetes