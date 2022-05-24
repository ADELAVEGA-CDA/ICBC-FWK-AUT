Feature: Validar componentes de la app de Ejemplo
  Como un usario individuo
  Quiero validar las aplicaciones y textos
  Para comprobar que la interacción funciona bien

  Background: Abrir la app de Ejemplo
    Given the example app has been launched

  @MobileApp
  Scenario: 01. Validate the PageSource string on the app screen
    Then the user sees "Save all of your photos and videos in one place" in the PageSource

  @MobileApp
  Scenario: 02. Validate existence of multiple texts in PageSource
    Then the user sees
      | Powerful    |
      | Get Started |
      | Ben Flasher |

  @MobileApp
  Scenario: 03. Validate the Current Activity of the App
    Then the user sees the current activity is ".WelcomeActivity"

  @MobileApp
  Scenario: 04. Validate the Current Context of the App
    Then the user sees the current context is "NATIVE_APP"
