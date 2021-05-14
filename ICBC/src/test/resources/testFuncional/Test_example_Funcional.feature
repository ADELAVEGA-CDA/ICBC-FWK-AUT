
Feature: Probar página principal del sitio
	Como un usario
  Quiero realizar una busqueda
  Para encontrar un producto

  @tag1 @funcional
  Scenario: Acceso página principal y busqueda de producto
    Given accedo a la pagina principal
    When busco un producto por "black" como descripción
    And hago clic en el boton aceptar
    Then veo la lista de los productos
