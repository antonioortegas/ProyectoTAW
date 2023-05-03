<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registrar Cliente</title>
</head>
<body>
<h1>Registrar Cliente</h1>
<form action="/registrarCliente" method="post">
    <label for="nif">NIF*:</label>
    <input type="text" id="nif" name="nif" required>
    <br>
    <label for="nombre">Nombre*:</label>
    <input type="text" id="nombre" name="nombre" required>
    <br>
    <label for="segundoNombre">Segundo Nombre:</label>
    <input type="text" id="segundoNombre" name="segundoNombre">
    <br>
    <label for="apellido1">Primer Apellido*:</label>
    <input type="text" id="apellido1" name="apellido1" required>
    <br>
    <label for="apellido2">Segundo Apellido:</label>
    <input type="text" id="apellido2" name="apellido2">
    <br>
    <label for="fechaNacimiento">Fecha Nacimiento*:</label>
    <input type="date" id="fechaNacimiento" name="fechaNacimiento" required>
    <br>
    <label>Dirección:</label><br>
    <label for="calle">Calle*:</label>
    <input type="text" id="calle" name="calle" required>
    <br>
    <label for="numeroVivienda">Número de Vivienda*:</label>
    <input type="text" id="numeroVivienda" name="numeroVivienda" required>
    <br>
    <label for="planta">Planta*:</label>
    <input type="text" id="planta" name="planta" required>
    <br>
    <label for="ciudad">Ciudad*:</label>
    <input type="text" id="ciudad" name="ciudad" required>
    <br>
    <label for="region">Región:</label>
    <input type="text" id="region" name="region">
    <br>
    <label for="pais">País*:</label>
    <input type="text" id="pais" name="pais" required>
    <br>
    <label for="cp">CP*:</label>
    <input type="text" id="cp" name="cp" required>
    <br>
    <label for="valida">Valida*:</label>
    <input type="checkbox" id="valida" name="valida" value="1" required>
    <br>
    <label for="contrasena">Contraseña*:</label>
    <input type="password" id="contrasena" name="contrasena" required>
    <br>
    <input type="submit" value="Registrar">
    <input type="reset" value="Limpiar">
</form>
<br>
</body>
</html>
