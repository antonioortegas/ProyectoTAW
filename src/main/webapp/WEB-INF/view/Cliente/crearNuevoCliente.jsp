<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
Created by IntelliJ IDEA.
User: Carlos Dominguez
Date: 06/05/2023
Time: 14:00
--%>
<html>
<style>
    /* Estilos para la página */
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
    }
    h1 {
        text-align: center;
        margin-top: 20px;
    }
    form {
        margin: 20px auto;
        width: 80%;
        max-width: 600px;
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }
    label {
        display: inline-block;
        width: 130px;
        margin-bottom: 10px;
    }
    input[type="text"],
    input[type="password"],
    input[type="date"],
    input[type="email"] {
        padding: 5px;
        font-size: 16px;
        border-radius: 5px;
        border: none;
        width: 80%;
        max-width: 400px;
        box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }
    input[type="checkbox"] {
        margin-left: 5px;
    }
    input[type="submit"],
    input[type="reset"] {
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #4CAF50;
        color: #fff;
        font-size: 16px;
        border-radius: 5px;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    input[type="submit"]:hover,
    input[type="reset"]:hover {
        background-color: #3e8e41;
    }
    button {
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #f44336;
        color: #fff;
        font-size: 16px;
        border-radius: 5px;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s ease;
        text-decoration: none;
        display: inline-block;
    }
    button:hover {
        background-color: #d32f2f;
    }
    a {
        color: #fff;
        text-decoration: none;
    }
</style>
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
    <label for="contrasena">Repetir contraseña*:</label>
    <input type="password" id="repcontrasena" name="repcontrasena" required>
    <br>
    <input type="submit" value="Registrar">
    <input type="reset" value="Limpiar">
</form>
<br>
<br><button> <a href="/">Salir</a></button><br>
</body>
</html>
