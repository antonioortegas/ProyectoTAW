<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1>Registro de Persona</h1><br>
<form:form method="post" modelAttribute="cliente" action="/registroCliente">
    <a>Datos Personales</a><br>
    <label for="nif">NIF (*) </label>
    <input type="text" id="nif" name="nif" required><br>

    <label for="nombre">Primer Nombre (*)</label>
    <input type="text" id="nombre" name="primer-nombre" required><br>

    <label for="segundoNombre">Segundo Nombre</label>
    <input type="text" id="segundonombre" name="segundo-nombre"><br>

    <label for="primerApellido">Primer Apellido (*)</label>
    <input type="text" id="primerApellido" name="primer-apellido" required><br>

    <label for="segundoApellido">Segundo Apellido</label>
    <input type="text" id="segundoApellido" name="segundo-apellido"><br>

    <label for="fecha-nacimiento">Fecha de Nacimiento (*)</label>
    <input type="date" id="fecha-nacimiento" name="fecha-nacimiento" required><br>

    <a>Dirección</a><br>

    <label for="calle">Calle (*)</label>
    <input type="text" id="calle" name="calle" required><br>

    <label for="numero-vivienda">Número de Vivienda (*)</label>
    <input type="text" id="numero-vivienda" name="numero-vivienda" required><br>

    <label for="planta">Planta (*)</label>
    <input type="text" id="planta" name="planta" required><br>

    <label for="ciudad">Ciudad (*)</label>
    <input type="text" id="ciudad" name="ciudad" required><br>

    <label for="region">Región</label>
    <input type="text" id="region" name="region"><br>

    <label for="pais">País (*)</label>
    <input type="text" id="pais" name="pais" required><br>

    <label for="cp">Código Postal (*)</label>
    <input type="text" id="cp" name="cp" required><br>

    <label for="valida">Código Postal (*)</label>
    <input type="checkbox" id="valida" name="valida" required><br>

    <label for="contrasena">Contraseña*</label>
    <input type="password" id="contrasena" name="contrasena" required><br>

    <label for="repetir-contrasena">Repetir Contraseña*</label>
    <input type="password" id="repetir-contrasena" name="repetir-contrasena" required><br>

    <input type="submit" value="Enviar">
    <input type="reset" value="Reset">
</form:form>
<br>
<button onclick="window.location.href='index.html'">Salir</button>
</form>
</body>
