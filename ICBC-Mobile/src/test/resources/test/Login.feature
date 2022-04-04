
@SignIn
Feature: Verificar acceso al navegador
  
  AS un cliente de la plataforma
  I WANT acceder con mis credenciales al portal
  SO THAT validar mi acceso

  @SignInTrue
  Scenario: Acceso con datos validos
    Given accedo al portal principal
    And selecciono ingreso personas
    When ingreso mi usuario y clave
    And hago click en ingresar
    Then me muestra la pagina principal de usuarios


  @SignInFalse
  Scenario Outline: Acceso con datos de identificación invalidos
    Given accedo al portal principal
    And selecciono ingreso personas
    When ingreso mis usuario <USER> y mi clave <PASS>
    And hago click en ingresar
    Then verifico el mensaje <MSG> obtenido

    Examples: 
      | USER  						| PASS 							| MSG  																		|
      | "userValido" 			| "claveInvalida"		| "Fail" 																	|
      | "userInexistente"	| "claveInvalida"		| "Fail"    															|
      | "userEnBlanco"		| "claveInvalida"		| "Fail"    															|
      | "userExistente"		| "claveEnBlanco"		| "Fail"    															|
 
 