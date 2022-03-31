@SceOutline
Feature: Acceder al sitio para adquirir un producto y realizar la compra, completando el formulario.
  COMO un usuario final
  QUIERO acceder al sitio y agregar un producto al carrito
  PARA proceder con la compra del mismo
  
	  @Smoke @Compras
	  Scenario Outline: Se realiza la seleccion y la compra del producto
	  	Given accedo al Store del sitio de demoblaze
	    And ingreso a la categoria Phones del home page
	    And selecciono el primer telefono de la lista
	    And lo agrego al carro de compra
	    And accedo al carro de compra
	    When selecciono realizar pedido
	    And completo <nombre>, <country>, <city>, <card>, <month> y <year> del formulario
	    And hago clic en comprar
	    Then obtengo la confirmacion de la compra
	
	    Examples: 
	      | nombre  				| country 		| city  	| card  							| month 	| year  	| 
	      | "Usuario Uno"  	| "Argentina" | "Caba"  | "1234123412341234"  | "11" 		| "26"	  | 

	      
	  @Regression @CompaDatos
	  Scenario Outline: Se accede a finalizar la compra y obtener la orden
	  	Given accedo al Store del sitio de demoblaze
	    And ingreso a la categoria Phones del home page
	    And selecciono el primer telefono de la lista
	    And lo agrego al carro de compra
	    And accedo al carro de compra
	    When selecciono realizar pedido
	    And completo los datos del formulario para el <cliente>
	    And hago clic en comprar
	    Then obtengo el numero de orden
	    Then se agrego el producto a la grilla
	
	    Examples: 
	      | cliente  		| 
	      | "Usuario"  	| 
	     	| "User"  		| 
	      
	  @Regression @CompraIndice
	  Scenario Outline: Se accede a finalizar la compra y obtener la orden
	  	Given accedo al Store del sitio de demoblaze
	    And ingreso a la categoria Phones del home page
	    And selecciono el primer telefono de la lista
	    And lo agrego al carro de compra
	    And accedo al carro de compra
	    When selecciono realizar pedido
	    And completo los datos del cliente con ID <ID>
	    And hago clic en comprar
	    Then obtengo el numero de orden
	    Then se agrego el producto a la grilla
	
	    Examples: 
	      | ID  		| 
	      | 1  			| 
	     	| 2  			|  
 
 