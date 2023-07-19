<!DOCTYPE html>
<html>
<head>
    <title>Registro de Usuario</title>
</head>
<body>
    <h2>Registro de Usuario</h2>
    <form action="RegistroServlet" method="post">
        <label>Nombre Completo:</label>
        <input type="text" name="nombreCompleto" required>
        <br>
        <label>Edad:</label>
        <input type="number" name="edad" min="15" required>
        <br>
        <label>Sexo:</label>
        <input type="radio" name="sexo" value="M" required> Masculino
        <input type="radio" name="sexo" value="F" required> Femenino
        <br>
        <label>Estatura (metros):</label>
        <input type="number" name="estatura" step="0.01" min="1" max="2.5" required>
        <br>
        <label>Nombre de Usuario:</label>
        <input type="text" name="usuario" required>
        <br>
        <label>Contraseña:</label>
        <input type="password" name="contrasena" required>
        <br>
        <input type="submit" value="Registrarse">
    </form>
</body>
</html>
