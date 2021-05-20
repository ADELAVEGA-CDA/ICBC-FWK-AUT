
Feature: Prueba de API

  @api
  Scenario Outline: Se realiza una consulta a una API sin certificado
		Given accedo a la url <url>
		And tengo el path de la api <api>
		When ingreso los datos de usuario <user> y contraseña <pass> del body
		And ingreso los paramatros <parametros>
		And indico la cabecera <header1> y <header2>
		Then obtengo el codigo <codigo> como respuesta
    Examples: 
    |url 	 														|api 												 |user					|pass				 |parametros  	|header1  			|header2  					|codigo |
    |"https://bookstore.toolsqa.com"  |"/Account/v1/GenerateToken" |"TOOLSQA-Test"|"Test@@123" |"parameters" 	|"Content-Type" |"application/json" |302		|


  @api
  Scenario Outline: Se realiza una consulta a una API sin certificado con dos cabeceras
		Given accedo a la url <url>
		And tengo el path de la api <api>
		When ingreso los datos del body
			|"userId"|"9b5f49ab-eea9-45f4-9d66-bcf56a531b85"|"collectionOfIsbns"|"isbn"|"9b5f49ab-eea9-45f4-9d66-bcf56a531b85"|
		And ingreso los datos de los paramatros
		And indico los datos de la cabecera api
			|"Content-Type"|"application/json"|
			|"Authorization"|"Bearer"|
		Then obtengo el codigo <codigo> como respuesta
    Examples: 
    |url 	 														|api 									 |codigo 	|
    |"https://bookstore.toolsqa.com"  |"/BookStore/v1/Books" |504			|

