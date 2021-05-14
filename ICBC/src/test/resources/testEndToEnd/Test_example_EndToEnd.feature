
Feature: Prueba de compra
	Como un usario
  Quiero realizar una busqueda y encontrar un producto
  Para agregarlo a mi cesta de compra
	
	  @tag1 @e2e @e2e_1
	  Scenario: realizar una compra
	    Given accedo a la pagina principal
	    And busco un producto por "white" como descripción
	    And hago clic en el boton aceptar
	    When selecciono la ficha 1 de la lista
	    And selecciono la opcion 1 del dropdown "color"
	    And selecciono la opcion 1 del dropdown "talle"
	    And hago clic en el boton "agregar"
	    Then se agrega al carrito de compra un producto
	
	  @tag1 @e2e @e2e_2
	  Scenario Outline: realizar una compra
	    Given accedo a la pagina principal
	    And busco un producto por <descripcion> como descripción
	    And hago clic en el boton aceptar
	    When selecciono la ficha <ficha> de la lista
	    And selecciono la opcion <dropOption1> del dropdown <dropName1>
	    And selecciono la opcion <dropOption2> del dropdown <dropName2>
	    And hago clic en el boton <boton>
	    Then se agrega al carrito de compra un producto
	    Examples:
	    |descripcion	|ficha	|dropOption1	|dropName1	|dropOption2	|dropName2	|boton			|
	    |"white"			|1			|1						|"color"		|1						|"talle"		|"agregar"	|
    