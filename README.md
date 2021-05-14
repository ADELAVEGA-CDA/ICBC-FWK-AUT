

# ICBC FRAMEWORK #
Proyecto de Automatización Framework ICBC

## Resumen de la herramienta ##
* Infraestructura para QA Automation Cucumber para Java
* Incluye pruebas web, pruebas de apis y de apps mobile
* Versión: 0.1.1


#### Requerido: JDK 1.8 - MAVEN - Eclipse ####
* Descargar, Instalar y agregar variables de entorno para JDK 1.8.0_192
* Descagar e Instalar Maven
* Descagar y disponibilizar en directorio con permisos, ultima versión Eclipse
* Descargar e instalar GIT (puede usar además, un GUI como Sourcetree)


### Clonar repositorio ###
* Clonar el repositorio en directorio local con permisos de escritura
* Abrir Eclipse
* Seleccionar directorio de Workspace
* Luego Importar -> Proyecto Maven
* Si no actualiza o no baja las dependencias, hacer clic con el botón secundario del mouse sobre el proyecto y seleccionar Maven -> Update


# Estructura de archivos para ejecución de tests #

## /test/java/runners ##

Contiene la clase ejecutora. En el se usa la opción "tags"
 como filtro para las pruebas que se ejecutan, 
 por ejemplo "tags={@Regresion}". 
Para ejecutarlo, se corre como "JUnit Test". 


## /test/resources/features ##

Aquí se colocan los archivos .features, escritas en Gherkin.  
 Estos contienen los pasos y variables que usaran las pruebas.

## /test/java/stepsDefinitions ##

Aquí se colocan las definiciones de los steps del .feature.  
 Estas contienen las funciones invocadas en cada paso de cada feature.

## /main/java/pageObjects ##

Aquí se colocan los localizadores de los elementos con su clave:valor, usando PageFactory.  
 Estas contienen las funciones y selectores utilizadas para interactuar con el browser.

## /target/reportesCucumber ##

Aquí se guarda un reporte en html de la última ejecución.


# API TESTING #

### Clonar certificado para sitios https ###

#### Proceso con el navegador ####

* En el navegador hacer click en " consulta de la informacion del sitio"
* En el menu que se despliega hacle click en la opcion " certidicados "
* En la ventana "Certificado" hacer click en la solapa " Ruta de certificado "
* Seleccionar el certidficado y hacer click en el boton " Ver certificado "
* En la nueva ventana seleccionar la solapa "Detalles"
* Hacer click en el boton " Copiar en archivo..." , esto abre el asistente para explortar certificado
* Seleccionar la opcion " DER binario codificado X.509 (.CER)" y hacer click en siguiente
* Darle un nombre al archivo y especificar la ruta en donde se guardara para finalizar este proceso

#### Proceder en una ventana de comado ####

* Ubicarse en la carpeta donde se guardo el certificado
* Ejecutar la siguiente linea de comando: 
" keytool -import -trustcacerts -alias certalias -file <nombre_certificado.cer> -keystore trustStorecertificadoJava"
y presionar enter
* Te va solicitar "Introduzca la contraseña del almacén de claves:"
* Ingresar un clave que pueda recordar, o anotar en algun sitio que se pueda recordar
* Te va a solicitar de nuevo "Volver a escribir la contraseña nueva:", ingresar de nuevo la misma clave
* te va aa preguntar si ¿Confiar en este certificado?, escribir si y presionar enter

#### Proceso en eclipse ####

* Sobre el scrip hacer click con el boton secundario del mouse y seleccionar " Run As " >> " Run configuration "
* Ubicado en el scrip seleccionar la solapa " Arguments " 
* En la seccion " VM arguments " ingresar la siguiente instruccion : 
-Djavax.net.ssl.trustStore=<ruta_al_certificado> -Djavax.net.ssl.trustStorePassword=<contraseña_creada>
* Hacer click en " Apply" y luego en " Close "



# Estructura de archivos para ejecución de tests #

## En construcción ##


## En Construcción ##
