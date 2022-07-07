@CHROME
Feature: Casos de prueba de Tosca en el sitio de ICBC
  Como un usario individuo
  Quiero ejecutar los casos de prueba de TOSCA
  Para comprobar la exportación del archivo .side

  Background: Abrir la url en el navegador
    Given accedo a la url "https://multipay-qat.intranet.local/"

  @Tosca @issue=<ISSUE-NUMBER> @tmsLink=<TEST-CASE-ID> @severity=normal
  Scenario: Me logueo correctamente en el sitio
    When ingreso por empresa con el CUIT "30522982225"
    And el nombre de usuario "AgusConsSC01"
    And la contraseña "Banco237"
    Then me logueo en el sitio correctamente

  @Tosca @issue=<ISSUE-NUMBER> @tmsLink=<TEST-CASE-ID> @severity=normal
  Scenario: Mostrar correctamente la pantalla de Esquema de Firmas
    When ingreso por empresa con el CUIT "30591116017"
    And el nombre de usuario "RegToscaAgus05"
    And la contraseña "Banco240"
    And me dirijo a Adminitración de usuarios con el código "509790"
    And me dirijo a Administración de empresas y Esquema de firmas
    Then me muestra la pantalla de Esquema de firmas
