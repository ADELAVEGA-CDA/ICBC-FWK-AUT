# CDA FRAMEWORK

CDA Framework es una herramienta construida en Cucumber con Java y JUnit para poder crear y ejecutar test en lenguaje
coloquial.

Este Framework nace con la necesidad de disminuir el tiempo de ejecución de pruebas manuales, así como tener una
herramienta en donde ya se tiene la estructura para agregar más features a probar, y que dichas pruebas se escriban de
tal manera que cuándo se estén ejecutando se vayan describiendo de una manera clara a lo que está sucediendo.

## Resumen de la herramienta

* Estructura para automatizaciones de pruebas en Cucumber
* Permite escribir las pruebas en lenguaje natural, Gherkin
* Cubre pruebas basadas en web, pruebas de APIs y pruebas mobile
* Para localizar los elementos se incluye Page Factory que simplifica la construcción

## CONTENIDO

- [Configuración](#configuración)
- [BDD (Behavior Driven Development)](#bdd)
- [Estructura del Framework](#estructura)
- [License](#license)

## CONFIGURACIÓN

### Prerrequisitos

##### Java SE Development Kit (JDK).

• Instalar JDK 15 y comprobar su correcta instalación ejecutando el siguiente comando en la consola:
java –version El comando debería mostrar la versión de Java, por ejemplo:
java version "15"

• Agregar la variable de entorno JAVA_HOME. En Windows: ir a Este equipo > Propiedades > Configuración avanzada del
sistema > Variables de entorno. En la sección de “Variables del sistema” seleccionar la opción de “Nueva…” y agregar la
nueva variable con nombre de "JAVA_HOME" y el valor con la ruta de instalación de java, por ejemplo: “C:\Program
Files\Java\jdk-15”

Para verificar que la variable se haya agregado sin problemas, en la consola, escribir: echo %JAVA_HOME%, y como
resultado deberíamos de ver el valor de la variable.

• Agregar a la variable de entorno Path la ruta del bin de java. En Windows: ir a Este equipo > Propiedades >
Configuración avanzada del sistema > Variables de entorno > Variables del sistema > Path > Editar > Nuevo. Y agregamos
la ruta de Java hasta la carpeta Bin, ocupando la variable JAVA_HOME.
"%JAVA_HOME%\bin\"

##### Maven

• Descargar Maven de su página oficial, luego descomprimir el archivo .zip en un directorio de nuestra preferencia, por
ejemplo: “C:\Maven”, para que nos quede algo así: “C:\Maven\apache-maven-3.8.5”. • Agregar a la variable PATH un nuevo
valor con la ruta de en donde se encuentra Maven. • En Windows: ir a Este equipo > Propiedades > Configuración avanzada
del sistema > Variables de entorno > Variables del sistema > Path > Editar > Nuevo. Y agregamos la ruta de Maven hasta
la carpeta Bin.

##### IDE

• Opción 1:
Descargar e instalar IntelliJ IDEA en su página oficial

• Opción 2:
Descargar e instalar Eclipse en su versión for Java Developers

##### Gherkin

• IntelliJ IDEA Hacer clic en File > Setting Buscar en Plugins: Gherkin para trabajar con archivos “.feature”. Instalar
también Cucumber for Java

• Eclipse Hacer clic en Help > MarketPlace Buscar por Gherkin para trabajar con archivos “.feature”. Instalar Cucumber
Eclipse Plugin, aceptando los términos.

## BDD (Behavior Driven Development)

BDD o Desarrollo Dirigido por Comportamiento: Es una metodología de equipo que se enfoca en porque se debe escribir el
código y como se debería comportar ese código. • Evita múltiples repositorios (documentación vs código) y reduce la
redundancia de documentos (o falta de ellos). • Mejora los tiempos de prueba. • Incrementa la cobertura de las pruebas.
• Disminuye la curva de aprendizaje. • Reduce la ambigüedad o interpretaciones erróneas. • Unifica las diversas maneras
de armar la automatización.

### Historias de usuario y features

• Para los fines de la metodología, la historia de usuario es una “feature” con cierta estructura. • Un feature cubre
una funcionalidad o requerimiento específico. • Si la historia de usuario es extensa o abarca más de una funcionalidad,
esta pasa a ser una épica. • La épica se dividirá en tantas feature como funcionalidades requiera.

### Escenarios

• Un escenario podría considerarse como un caso de prueba pero que permite múltiples escenarios. • Según la descripción
y los criterios de aceptación en el feature, se generan los escenarios. • Cada escenario cumple con una validación. • Un
escenario puede cubrir más de una variante para la misma validación.

### Features y escenario

Si bien el feature contiene información que lo describa y mencione los criterios de aceptación, para los fines de la
metodología debe respetar cierta estructura y usar determinadas palabras para que la misma documentación genere los
casos de prueba automatizados.

## ESTRUCTURA DE ARCHIVOS

### .feature

/test/resources/features En esta ruta se ubican los archivos '.feature' que es donde se escriben las pruebas. Estos
contienen los pasos y variables que usaran las pruebas. Las pruebas se escriben en lenguaje coloquial siguiendo cierta
estructura con palabras reservadas: Gherkin. Se deben crear carpetas, que cumplirán la función de agrupadoras para
identificar las especificaciones, las aplicaciones, los canales, los tipos, etc.

### stepsDefinitions

/test/java/stepsDefinitions Es donde se ubican las clases de definición de pasos del archivo '.feature' y se les
relaciona con las acciones definidas para los elementos de la página.  
Se debe crear una clase stepsDefinition por cada página web, por funcionalidad, por comportamiento, por flujo, etc.,
según el criterio que se adopte.

### pageObjects

/main/java/pageObjects Es donde se construye los localizadores para los elementos, con su respectivo clave:valor de CSS
o su XPATH.  
Se utiliza la librería Page Factory para simplificar la definición de los elementos. Además se dan las acciones sobre
los elementos definidos (click, sendKey, select, etc.).

### runnersClass (Ejecución)

/test/java/runnersClass Corresponde a la clase ejecutora. En él se usa la opción "tags"  como filtro para las pruebas
que se ejecutan, por ejemplo "tags={@Regresion}". Para ejecutarlo, se hace clic con el botón secundario del mouse y
seleccionar Run As -> JUnit Test.

### Target

•/target/allure-results En este directorio es donde se guardan los resultados de los reportes de allure. •/target/logs
En este directorio se guardan los logs de errores. •/target/reportesCucumber En este directorio es donde se guardan los
reportes de las ejecuciones del extent report en html y pdf •/target/screen-records En este directorio es donde se
guardan las grabaciones de pantalla si es que se habilitan en el config. •/target/screenshots En este directorio es
donde se guardan las capturas de pantalla de los errores en los test.

### Config

/configs/config.properties En este archivo va la configuración del framework, intercambiando entre las distintas
opciones que ofrece:

```
# Ambiente en el que se está probando
environment=
# El navegador se lee através del tag del feature, en caso de no encontrarlo se ejecuta este navegador por default  
browser=
# En caso de ser android o ios, se verifica si es web mobile (Chrome o Safari) o una app 
deviceApp=
# Para maximizar la pantalla del navegador
maxWin=
# Directorio a los drivers
driverPath=
# Tiempo de espera
waitTime=
# En caso que se use algún usuario o contraseña en el suite test
loginUsername=
loginPassword=
# Información de la base de datos
dbUrl=
dbUser=
dbPassword=
# Información del dispositivo y de la aplicación a probar
deviceId=
applicationId=
appPackage=
appMainActivity=
appNameAndroid=
deviceNameAndroid=
deviceVersionAndroid=
appNameIphone=
deviceNameIphone=
deviceVersionIphone=
# Direcciones en los distintos ambientes
URL_DEMO=
URL=
URL_HOMO=
URL_QA=
URL_DEV=
URL_UAT=
# IP del servidor de APPIUM
appiumURL=
# Información del extentReport
reportConfigPath:
reportPath:
# Directorio de las capturas de pantalla
screenshotPath:
# Directorio a los POJO
testDataPath=
# Habilitar para grabaciones de pantalla
screenRecord=
```

## API TESTING

Se utiliza la librería de Rest Assured para el testing de APIs.

Se sigue la misma estructura que en pruebas funcionales. Esto es, se crea un archivo feature en lenguaje Gherkin donde
se pasan los argumentos a la clase stepsFedinition, esta clase almacena los argumentos en variables globales, y desde el
pageObject se crean las acciones utilizando la librería RestAssured. En el caso particular que se tenga que utilizar
certificados, realizar los siguientes pasos.

### Clonar certificado para sitios https ###

##### Proceso con el navegador ####

```
* En el navegador hacer click en "consulta de la información del sitio"
* En el menú que se despliega hacle click en la opción "certificados"
* En la ventana "Certificados" hacer click en la solapa "Ruta de certificado"
* Seleccionarlo y hacer click en el boton "Ver certificado"
* En la nueva ventana seleccionar la solapa "Detalles"
* Hacer click en el botón "Copiar en archivo..." , esto abre el asistente para explortar certificado
* Seleccionar la opción "DER binario codificado X.509 (.CER)" y hacer click en siguiente
* Darle un nombre al archivo y especificar la ruta en donde se guardará para finalizar este proceso
```

##### Proceder en una ventana de comado ####

```
* Ubicarse en la carpeta donde se guardó el certificado
* Ejecutar la siguiente linea de comando: 
" keytool -import -trustcacerts -alias certalias -file <nombre_certificado.cer> -keystore trustStorecertificadoJava"
y presionar enter
* Te va solicitar "Introduzca la contraseña del almacén de claves:"
* Ingresar un clave que pueda recordar, o anotar en algún sitio que se pueda recordar
* Te va a solicitar de nuevo "Volver a escribir la contraseña nueva:", ingresar de nuevo la misma clave
* Te va a preguntar ¿Confiar en este certificado?, escribir si y presionar enter
```

##### Proceso en eclipse ####

```
* Sobre el script hacer click con el botón secundario del mouse y seleccionar "Run As" >> "Run configuration"
* Ubicado en el script seleccionar la solapa "Arguments" 
* En la sección "VM arguments" ingresar la siguiente instrucción: 
-Djavax.net.ssl.trustStore=<ruta_al_certificado> -Djavax.net.ssl.trustStorePassword=<contraseña_creada>
* Hacer click en "Apply y luego en "Close"
 ```
