
Feature: API de Extracción de ATM
	Como cliente de Bancard
	quiero verificar que las api funcionen correctamente
	para la operación de retiro en ATM

  	@Api @CP01
  	Scenario: Se hará un retiro en ATM de manera exitosa
	  Given al acceder al swagger
	  When cargo una extracción con el cliente con RNN "0986401202"
	  And posee un monto disponible de "500000"
	  And confirmo la extracción con el RNN de la operación anterior
	  Then la extracción es exitosa

	@Api @CP02
	Scenario: Provocar un error de retiro por falta de fondos
		Given al acceder al swagger
		When cargo una extracción con el cliente con RNN "0986401202"
		And posee un monto disponible de "1"
		Then la extracción provoca un error por falta de fondos

	@Api @CP03
	Scenario: Provocar un error de retiro por falta de fondos al límite
		Given al acceder al swagger
		When cargo una extracción con el cliente con RNN "0986401202"
		And posee un monto disponible de "199999"
		Then la extracción provoca un error por falta de fondos

	@Api @CP04
	Scenario: Se hará un retiro de manera exitosa
		Given al acceder al swagger
		When cargo una extracción con el cliente con RNN "0986401202"
		And posee un monto disponible de "200001"
		And confirmo la compra con el RNN de la operación anterior
		Then la extracción es exitosa

#	@Api @CP05
#	Scenario: Realizar reverso de una extracción aprobada
#		Given Cumplo una precondición
#		When Ejecuto una acción
#		Then Observo este resultado
#		But No debería poder observar este otro resultado

	@Api @CP06
	Scenario: Cancelar operación antes de confirmar la extracción
		Given al acceder al swagger
		When cargo una extracción con el cliente con RNN "0986401202"
		And posee un monto disponible de "200000"
		But al no validar la extracción con el RNN de la operación anterior
		Then la extracción se cancela