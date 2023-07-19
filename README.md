# Calculadora IMC

Este proyecto es una aplicación web para el registro de usuarios y el cálculo del Índice de Masa Corporal (IMC). Permite a los usuarios ingresar su información personal y luego muestra su IMC actual y un historial de cálculos de IMC realizado en sesiones anteriores.

## Tecnologías utilizadas

El proyecto utiliza las siguientes tecnologías:

- **Front-end:** HTML, JavaScript
- **Back-end:** Java con Servlets


## Estructura de archivos

El proyecto consta de los siguientes archivos:

1. `index.html`: Es la página inicial donde los usuarios pueden completar el formulario de registro.

2. `script.js`: Es un archivo JavaScript que contiene una función para calcular el IMC de un usuario.

3. `Registro.jsp`: Es una página JSP (JavaServer Pages) que muestra el formulario de registro de usuarios y envía los datos al servlet.

4. `RegistroServlet.java`: Es el servlet Java que recibe los datos del formulario, calcula el IMC y almacena la información en la sesión del usuario.

5. `IMCData.java`: Es una clase Java que define la estructura para almacenar los datos del cálculo de IMC en el historial.

6. `calculadora.html`: Es una página JSP que muestra el IMC actual del usuario y su historial de cálculos de IMC.

## Funcionamiento

1. Cuando un usuario accede a la página `index.html`, encontrará un formulario de registro donde debe ingresar su nombre completo, edad, sexo, estatura, nombre de usuario y contraseña.

2. Al enviar el formulario, los datos ingresados se envían al servlet `RegistroServlet.java` para su procesamiento.

3. El servlet valida la estatura y la edad del usuario. Si no cumplen con los requisitos, redirecciona al usuario nuevamente a `index.html` para corregir los datos.

4. Si la estatura y la edad son válidas, se calcula el IMC del usuario y se almacena en la sesión. También se agrega el cálculo del IMC al historial de cálculos, que se almacena en la sesión.

5. Luego, el servlet redirecciona al usuario a la página `calculadora.jsp`, donde se muestra su IMC actual y el historial de cálculos de IMC.

## Uso de JSTL (JavaServer Pages Standard Tag Library)

En el archivo `calculadora.html`, se utiliza JSTL para iterar sobre el historial de cálculos de IMC almacenado en la sesión y mostrar los datos en una tabla.
