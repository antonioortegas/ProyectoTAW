<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Iniciar Sesión</title>
</head>
<body>
<h1>Iniciar Sesión</h1>
<form action="/loginCliente" method="post">
    <label for="nif">NIF:</label>
    <input type="text" id="nif" name="nif" required>
    <br>
    <label for="contrasena">Contraseña:</label>
    <input type="password" id="contrasena" name="contrasena" required>
    <br>
    <input type="submit" value="Iniciar Sesión">
    <input type="reset" value="Limpiar">
</form>
<br>
</body>
</html>
