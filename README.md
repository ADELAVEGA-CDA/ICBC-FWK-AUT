

ICBC FRAMEWORK
===================
Proyecto de Automatización Framework ICBC
Basado en Cucumber con Java y JUnit

## Resumen de la herramienta ##
* Estructura para automatizaciones de pruebas en Cucumber
* Permite escribir las pruebas en lenguaje natural, Gherkin
* Cubre pruebas basadas en web, pruebas de APIs y pruebas mobile
* Para localizar los elementos se incluye Page Factory que simplifica la construcción
* Versión: 1.0.0


#### Requerido: JDK 1.8 - MAVEN - Eclipse ####
* Descargar e Instalar JDK 1.8 y agregar variables de entorno JAVA_HOME.
* Descagar e Instalar Maven
* Descagar e instalar Eclipse for Java Developers
* Descargar e instalar GIT 


#### Eclipse y Gherkin ####
* En el IDE Eclipse, hacer clic en Help ➜ Marketplace.
* Buscar por Gherkin para trabajar con archivos '.feature'
* Instalar Cucumber Eclipse Plugin, aceptando los terminos 


### Clonar repositorio ###
#### desde Git Bash
* Clonar el repositorio en directorio local con permisos de escritura: git clone <url_repo_proy>
* Moverse a la rama en la cual se ira a trabajar o crear una rama nueva 
#### desde Eclipse
* Seleccionar directorio de Workspace, el que corresponde a donde se clono el proyecto
* Luego importar el proyecto Maven, desde File ➜ Import ➜ Maven ➜ Existing Maven Projects
* Si no actualiza o no baja las dependencias, hacer clic con el botón secundario del mouse sobre el proyecto y seleccionar Maven ➜ Update Project


# Estructura de archivos para ejecución de tests #

## /test/resources/... ##
```
En esta ruta se ubican los archivos '.feature' que es donde se escriben las pruebas. Estos contienen los pasos y variables que usaran las pruebas. 
Las pruebas se escriben en lenguaje coloquial siguiendo cierta estructura con palabras reservadas: Gherkin. 
Se deben crear carpetas, que cumpliran la función de agrupadoras para identificar las especificaciones, las aplicaciones, los canales, los tipos, etc. 
```

## /test/java/runnersClass ##
```
Corresponde a la clase ejecutora. En el se usa la opción "tags"
 como filtro para las pruebas que se ejecutan, 
 por ejemplo "tags={@Regresion}". 
Para ejecutarlo, se hace clic con el botón secundario del mouse y seleccionar Run As -> JUnit Test. 
```

## /test/java/stepsDefinitions ##
```
Es donde se ubican las clases de definición de pasos del archivo '.feature' y se les relaciona con las acciones definidas para los elementos de la página.  
 Se debe crear una clase stepsDefinition por cada página web, por funcionalidad, por comportamiento, por flujo, etc., según el criterio que se adopte.
```

## /main/java/pageObjects ##
```
Es donde se construye los localizadores para los elementos, con su respectivo clave:valor de CSS o su XPATH.  
Se utiliza la librería Page Factory para simplifar la definición de los elementos. 
Además se dan las acciones sobre los elementos definidos (click, sendKey, select, etc.). 
```

## /target/reportesCucumber ##
```
En este directorio es donde se guardan los reportes de las ejecuciones.
```

# API Testing #

Para las pruebas de APIs se sigue la misma estructura que en pruebas funcionales. 
Esto es, se crea un archivo feature en lenguaje Gherkin donde se pasan los argumentos
 a la clase stepsFedinition, esta clase almacena los argumentos en variables globales,
 y desde el pageObject se crean las acciones utilizando la librería RestAssured.
En el caso particular que se tenga que utilizar certificados, realizar los siguientes pasos.

### Clonar certificado para sitios https ###

#### Proceso con el navegador ####
```
* En el navegador hacer click en " consulta de la informacion del sitio"
* En el menu que se despliega hacle click en la opcion " certidicados "
* En la ventana "Certificado" hacer click en la solapa " Ruta de certificado "
* Seleccionar el certidficado y hacer click en el boton " Ver certificado "
* En la nueva ventana seleccionar la solapa "Detalles"
* Hacer click en el boton " Copiar en archivo..." , esto abre el asistente para explortar certificado
* Seleccionar la opcion " DER binario codificado X.509 (.CER)" y hacer click en siguiente
* Darle un nombre al archivo y especificar la ruta en donde se guardara para finalizar este proceso
```

#### Proceder en una ventana de comado ####
```
* Ubicarse en la carpeta donde se guardo el certificado
* Ejecutar la siguiente linea de comando: 
" keytool -import -trustcacerts -alias certalias -file <nombre_certificado.cer> -keystore trustStorecertificadoJava"
y presionar enter
* Te va solicitar "Introduzca la contraseña del almacén de claves:"
* Ingresar un clave que pueda recordar, o anotar en algun sitio que se pueda recordar
* Te va a solicitar de nuevo "Volver a escribir la contraseña nueva:", ingresar de nuevo la misma clave
* te va aa preguntar si ¿Confiar en este certificado?, escribir si y presionar enter
```

#### Proceso en eclipse ####
```
* Sobre el scrip hacer click con el boton secundario del mouse y seleccionar " Run As " >> " Run configuration "
* Ubicado en el scrip seleccionar la solapa " Arguments " 
* En la seccion " VM arguments " ingresar la siguiente instruccion : 
-Djavax.net.ssl.trustStore=<ruta_al_certificado> -Djavax.net.ssl.trustStorePassword=<contraseña_creada>
* Hacer click en " Apply" y luego en " Close "
```


# Estructura de archivos para ejecución de tests #

## En construcción ##

