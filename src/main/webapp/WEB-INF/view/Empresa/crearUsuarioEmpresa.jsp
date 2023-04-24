<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 20/04/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de Registro</title>
</head>
<body>
<h1>Formulario de Registro</h1>
<form action="/procesar-formulario" method="post">
    <label for="nif">NIF*</label>
    <input type="text" id="nif" name="nif" required><br>

    <label for="primer-nombre">Primer Nombre*</label>
    <input type="text" id="primer-nombre" name="primer-nombre" required><br>

    <label for="segundo-nombre">Segundo Nombre</label>
    <input type="text" id="segundo-nombre" name="segundo-nombre"><br>

    <label for="primer-apellido">Primer Apellido*</label>
    <input type="text" id="primer-apellido" name="primer-apellido" required><br>

    <label for="segundo-apellido">Segundo Apellido</label>
    <input type="text" id="segundo-apellido" name="segundo-apellido"><br>

    <label for="fecha-nacimiento">Fecha de Nacimiento*</label>
    <input type="date" id="fecha-nacimiento" name="fecha-nacimiento" required><br>

    <label for="calle">Calle*</label>
    <input type="text" id="calle" name="calle" required><br>

    <label for="numero-vivienda">Número de Vivienda*</label>
    <input type="text" id="numero-vivienda" name="numero-vivienda" required><br>

    <label for="planta">Planta</label>
    <input type="text" id="planta" name="planta"><br>

    <label for="ciudad">Ciudad*</label>
    <input type="text" id="ciudad" name="ciudad" required><br>

    <label for="pais">País*</label>
    <input type="text" id="pais" name="pais" required><br>

    <label for="region">Región</label>
    <input type="text" id="region" name="region"><br>

    <label for="cp">Código Postal*</label>
    <input type="text" id="cp" name="cp" required><br>

    <label for="contrasena">Contraseña*</label>
    <input type="password" id="contrasena" name="contrasena" required><br>

    <label for="repetir-contrasena">Repetir Contraseña*</label>
    <input type="password" id="repetir-contrasena" name="repetir-contrasena" required><br>

    <h2>Tabla de Usuarios</h2>
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>NIF</th>
            <th>Tipo</th>
            <th>Checkbox</th>
        </tr>
        <tr>
            <td>Juan Pérez</td>
            <td>12345678A</td>
            <td>Admin</td>
            <td><input type="checkbox" name="usuario1" value="1"></td>
        </tr>
        <tr>
            <td>María Gómez</td>
            <td>98765432B</td>
            <td>-</td>
            <td>-</td>
    </table>
    <input type="submit" value="Enviar">
    <input type="reset" value="Reset">
</form>
<br>
<button onclick="window.location.href='index.html'">Salir</button>
</form>
</body>
