<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.entity.EmpresaEntity" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 20/04/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%

%>

<head>
    <title>CREAR NUEVA EMPRESA</title>
</head>
<body>
<% System.out.println("HOLA");%>
<h1>HOLA   PAGINA   DE   CREAR   EMPRESAS</h1>
<h1>Formulario de Registro de Empresa</h1>
<form>
    <label for="cif">CIF *</label>
    <input type="text" id="cif" name="cif" required>
    <br>
    <label for="nombreEmpresa">Nombre de la empresa *</label>
    <input type="text" id="nombreEmpresa" name="nombreEmpresa" required>
    <br>
    <label for="calle">Calle *</label>
    <input type="text" id="calle" name="calle" required>
    <br>
    <label for="numero">Número *</label>
    <input type="text" id="numero" name="numero" required>
    <br>
    <label for="planta">Planta</label>
    <input type="text" id="planta" name="planta">
    <br>
    <label for="region">Región</label>
    <input type="text" id="region" name="region">
    <br>
    <label for="ciudad">Ciudad *</label>
    <input type="text" id="ciudad" name="ciudad" required>
    <br>
    <label for="pais">País *</label>
    <input type="text" id="pais" name="pais" required>
    <br>
    <label for="cp">Código Postal *</label>
    <input type="text" id="cp" name="cp" required>
    <br>
    <label for="contrasena">Contraseña</label>
    <input type="password" id="contrasena" name="contrasena">
    <br>
    <label for="repetirContrasena">Repetir Contraseña</label>
    <input type="password" id="repetirContrasena" name="repetirContrasena">
    <br>
    <input type="submit" value="Registrarse">
</form>
</body>
</html>
