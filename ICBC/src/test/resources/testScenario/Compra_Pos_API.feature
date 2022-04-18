
Feature: API de Compra de POS
	Como cliente de Bancard
	quiero verificar que las api funcionen correctamente
	para la compra de servicios

  	@Api @CP01
  	Scenario: Se hará una compra en POS de manera exitosa
	  Given al acceder al swagger
	  When cargo una compra con el cliente con RNN "0986401202"
	  And posee un monto disponible de "500000"
	  And confirmo la compra con el RNN de la operación anterior
	  Then la compra es exitosa

	@Api @CP02
	Scenario: Provocar un error de pago por falta de fondos
		Given al acceder al swagger
		When cargo una compra con el cliente con RNN "0986401202"
		And posee un monto disponible de "1"
		Then la compra provoca un error por falta de fondos

	@Api @CP03
	Scenario: Provocar un error de pago por falta de fondos al límite
		Given al acceder al swagger
		When cargo una compra con el cliente con RNN "0986401202"
		And posee un monto disponible de "199999"
		Then la compra provoca un error por falta de fondos

	@Api @CP04
	Scenario: Se hará un pago de servicio de manera exitosa
		Given al acceder al swagger
		When cargo una compra con el cliente con RNN "0986401202"
		And posee un monto disponible de "200001"
		And confirmo la compra con el RNN de la operación anterior
		Then la compra es exitosa

#	@Api @CP05
#	Scenario: Realizar reverso de un pago aprobado
#		Given Cumplo una precondición
#		When Ejecuto una acción
#		Then Observo este resultado
#		But No debería poder observar este otro resultado

	@Api @CP06
	Scenario: Cancelar operación antes de confirmar el pago
		Given al acceder al swagger
		When cargo una compra con el cliente con RNN "0986401202"
		And posee un monto disponible de "200000"
		But al no validar la compra con el RNN de la operación anterior
		Then la compra se cancela