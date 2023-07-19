# Calculadora IMC

Este proyecto es una aplicación web para el registro de usuarios y el cálculo del Índice de Masa Corporal (IMC). Permite a los usuarios ingresar su información personal y luego muestra su IMC actual y un historial de cálculos de IMC realizado en sesiones anteriores.

## Tecnologías utilizadas

El proyecto utiliza las siguientes tecnologías:

- **Front-end:** HTML, JavaScript
- **Back-end:** Java con Servlets
- **Base de datos:** No se menciona una base de datos específica en el código proporcionado, por lo que asumiremos que no se usa ninguna base de datos y que los datos se almacenan temporalmente en la sesión del usuario.

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

## Notas adicionales

- Es importante tener en cuenta que, según el código proporcionado, el campo de peso (`peso`) no se incluye en el formulario de registro en `Registro.jsp`, pero se utiliza en el servlet para calcular el IMC. Es posible que falte este campo en el formulario.

- No se proporciona información sobre la configuración del servidor o la implementación específica del proyecto, por lo que se asume que el proyecto está destinado a ser desplegado en un contenedor de servlets compatible, como Apache Tomcat u otro servidor Java.

- En cuanto a la seguridad, se debe tener en cuenta que el almacenamiento de contraseñas en texto claro no es seguro en una aplicación real. Para un proyecto real, es recomendable utilizar técnicas de almacenamiento seguro de contraseñas, como el uso de hash y salting.

- Asegúrese de que las dependencias y bibliotecas necesarias (como JSTL) estén configuradas correctamente en su entorno de desarrollo y despliegue para que el proyecto funcione correctamente.

## Licencia

No se proporciona información sobre la licencia utilizada en el código fuente. Por lo tanto, se debe tener en cuenta que, sin una licencia explícita, el código no puede ser utilizado, modificado o distribuido sin el permiso del autor original. Se recomienda agregar una licencia adecuada al proyecto antes de compartirlo en GitHub o cualquier otro lugar público.
