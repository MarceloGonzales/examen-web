Feature: Inicio de Sesión en la plataforma Store

  @iniciarSesion
  Scenario Outline: Iniciar Sesión
    When hago click en el boton iniciar sesión
    Then inicio sesión con email: "<email>" y contraseña: "<pass>"
    And hago click en el boton Ingresar
    Examples:
      | email                   | pass            |
      | mmgonzalesq@outlook.com | mar36470592     |
