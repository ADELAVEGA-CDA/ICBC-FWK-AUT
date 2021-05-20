
Feature: Prueba de compra
	Como un usario
  Quiero realizar una busqueda y encontrar un producto
  Para agregarlo a mi cesta de compra
	
	  @Home @Outline @URL @OutURL
	  Scenario Outline: accedo al homebanking individuos a realizar una busqueda
    Given accedo al homebanking individuo
    When hago clic en el menú Personas de la página Personas
    And hago clic en la solapa Productos y Servicios de la página Personas
    And hago clic en la opción Paquetes de la página Personas
    And accedo a los productos y servicios de la página Paquetes
    And hago clic en el icono Lupa de la página Paquetes
    And ingreso la opción <opcion> para la búsqueda
    Then obtengo <resultados> coincidencias como resultado de la búsqueda
    Examples:
    |opcion			|resultados	|
    |"premium"	|"518"			|
	
	  @Home @Outline @Title @OutTitle
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
    