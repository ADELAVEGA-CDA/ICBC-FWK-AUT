
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
    And hago clic en el icono Lupa de la página Paquetes
    And ingreso la opción <opcion> para la búsqueda
    Then obtengo <resultados> coincidencias como resultado de la búsqueda
    Examples:
    |opcion			|resultados	|
    |"premium"	|"518"			|
   
   
   
   
   
   
   
    	
	  @Home2 @Outline2 @Title @OutTitle
	  Scenario Outline: accedo al homebanking individuos para contactarme con un asesor
    Given accedo al homebanking individuo
    And hago clic en la opción Contactanos de la página Personas
    And hago clic en la sopala Internet de la página Contactanos
    And hago clic en el link Formulario Web de la página Contactanos
    When hago clic en el botón "Servicios" de la página Gestión de reclamos
    And hago clic en el botón "Otros reclamos" de la página Gestión de reclamos
    When ingreso <detalle> como detalle de contacto de la página Gestión de reclamos
    And hago clic en el botón "Continuar" de la página Gestión de reclamos
    And completo <nombre>, mi <DNI>, mi <email>, mi <Teléfono> como datos de contacto
    And hago clic en el botón "Enviar" de la página Gestión de reclamos
    Then obtengo un mensaje de confirmación
    Examples:
    |detalle						|nombre					|DNI				|email								|Teléfono			|
    |"Consultas varias"	|"Anibal"				|"5000000"	|"anibal@prueba.com"	|"1143214321"	|
    
    