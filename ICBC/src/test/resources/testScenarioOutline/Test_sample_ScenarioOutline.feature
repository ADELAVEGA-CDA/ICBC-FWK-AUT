
Feature: Prueba de compra
	Como un usario
  Quiero realizar una busqueda y encontrar un producto
  Para agregarlo a mi cesta de compra
	
	  @Home @Outline @URL @OutURL
	  Scenario Outline: accedo al homebanking individuos a realizar una busqueda
    Given accedo al homebanking individuo
    When hago clic en el menu Personas de la pagina Persona
    And hago clic en la solapa Productos y Servicios de la pagina Personas
    And hago clic en la opcion Paquetes de la pagina Personas
    And hago clic en el icono Lupa de la pagina Paquetes
    And ingreso la opcion <opcion> para la busqueda
    Then obtengo <resultados> coincidencias como resultado de la busqueda
    Examples:
    |opcion			|resultados	|
    |"premium"	|"518"			|
    |"premium"	|"526"			|   
    |"classic"	|"18"				|   
    |"classic"	|"14"				|   
   
   
   
   
    	
	  @Home2 @Outline2 @Title @OutTitle
	  Scenario Outline: accedo al homebanking individuos para contactarme con un asesor
    Given accedo al homebanking individuo
    And hago clic en la opcion Contactanos de la pagina Personas
    And hago clic en la sopala Internet de la pagina Contactanos
    And hago clic en el link Formulario Web de la pagina Contactanos
    When hago clic en el boton "Servicios" de la pagina Gestion de reclamos
    And hago clic en el boton "Otros reclamos" de la pagina Gestion de reclamos
    When ingreso <detalle> como detalle de contacto de la pagina Gestion de reclamos
    And hago clic en el boton "Continuar" de la pagina Gestion de reclamos
    And completo <nombre>, mi <DNI>, mi <email>, mi <Telefono> como datos de contacto
    And hago clic en el boton "Enviar" de la pagina Gestion de reclamos
    Then obtengo un mensaje de confirmacion
    Examples:
    |detalle						|nombre					|DNI				|email								|Telefono			|
    |"Consultas varias"	|"Anibal"				|"5000000"	|"anibal@prueba.com"	|"1143214321"	|
    
    