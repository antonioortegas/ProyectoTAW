<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 20/04/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    EmpresaEntity empresa = (EmpresaEntity) request.getAttribute("empresa");
%>

<head>
    <title>CREAR NUEVA EMPRESA</title>
</head>
<body>
<% System.out.println("HOLA");%>
<h1>HOLA PAGINA DE CREAR EMPRESAS</h1>
<h1>Formulario de Registro de Empresa</h1>
<form method="post" action="/procesarFormularioEmpresa" modelAttribute="empresa">
    <label for="cif">CIF *</label>
    <input type="text" id="cif" name="cif" required>
    <br>
    <label for="nombre">Nombre de la empresa *</label>
    <input type="text" id="nombre" name="nombre" required>
    <br>

    <label for="contrasena">Contraseña</label>
    <input type="password" id="contrasena" name="contrasena">
    <br>

    <label for="repetirContrasena">Repetir Contraseña</label>
    <input type="password" id="repetirContrasena" name="repetirContrasena">
    <br>
    <input type="hidden" id="Direccion_id_direccion" name="Direccion_id_direccion">
    <input type="submit" value="Registrarse">


</form>
<form method="post" action="/procesarFormularioEmpresa" modelAttribute="direccion">
    <label for="calle">Calle *</label>
    <input type="text" id="calle" name="calle" required>
    <br>
    <label for="numero">Número *</label>
    <input type="text" id="numero" name="numero" required>
    <br>
    <label for="puerta">Puerta</label>
    <input type="text" id="puerta" name="puerta">
    <br>
    <label for="ciudad">Ciudad</label>
    <input type="text" id="ciudad" name="ciudad">
    <br>
    <label for="pais">País *</label>
    <input type="text" id="pais" name="pais" required>
    <br>
    <label for="cp">Código Postal *</label>
    <input type="text" id="cp" name="cp" required>
    <br>
</form>

</body>
</html>
