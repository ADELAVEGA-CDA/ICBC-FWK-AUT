Feature: Ingresar al sitio de pruebas de selenium
  Como un tester QA
  Quiero realizar tests en una web de pruebas
  Para probar diversos casos en la automatización

  Scenario: Probar subida de archivos
#    Given accedo a la url de pruebas
    When me dirijo a la sección de elementos
    And hago click en el apartado de Upload and Download
    And subo un archivo de la dirección: "\configs\test.txt"
    Then el archivo "test.txt" está subido en el servidor
