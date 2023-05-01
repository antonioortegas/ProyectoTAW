<%@ page import="es.taw.proyectotaw.ui.FormularioRegistroCliente" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 20/04/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%
    FormularioRegistroCliente formularioRegistroCliente =  new FormularioRegistroCliente();
    %>
<head>
    <title>Formulario de Registro</title>
</head>
<body>
<h1>Registro de Persona</h1><br>
<%--@elvariable id="FormularioRegistroCliente" type=""--%>
<form method="post" th:object="${formularioRegistroCliente}" action="/registroCliente">
    <a>Datos Personales</a><br>

    NIF*:<input type="text" th:field="*{usuario.nif}" required/><br>
    Nombre*:<input type="text" th:field="*{usuario.nombre}" required/><br>
    Segundo Nombre:<input type="text" th:field="*{usuario.segundoNombre}"/><br>
    Primer Apellido*:<input type="text" th:field="*{usuario.primerApellido}" required/><br>
    Segundo Apellido:<input type="text" th:field="*{usuario.segundoApellido}" /><br>
    Fecha Nacimiento*:<input type="date" th:field="*{usuario.fechaNacimiento}" required/><br>

    <a>Dirección</a><br>

    Calle (*):<input type="text" th:field="*{direccion.calle}" required/><br>
    Número de Vivienda (*):<input type="text" th:field="*{direccion.numero}" required/><br>
    Planta (*):<input type="text" th:field="*{direccion.puerta}" required/><br>
    Ciudad (*):<input type="text" th:field="*{direccion.ciudad}" required/><br>
    Región:<input type="text" th:field="*{direccion.region}" /><br>
    País (*):<input type="text" th:field="*{direccion.pais}" required/><br>
    CP (*):<input type="text" th:field="*{direccion.cp}" required/><br>
    Valida (*): <input type="checkbox" th:field="*{direccion.valida}" required><br>

    Contraseña (*):<input type="password" th:field="*{usuario.contrasena}" required/><br>

    <input type="submit" value="Enviar">
    <input type="reset" value="Reset">
</form>
<br>
<button onclick="window.location.href='index.html'">Salir</button>
</form>
</body>
