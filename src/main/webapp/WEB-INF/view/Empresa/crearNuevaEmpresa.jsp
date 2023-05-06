<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>
<%@ page import="es.taw.proyectotaw.ui.CrearNuevaEmpresa" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 20/04/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    CrearNuevaEmpresa crearNuevaEmpresa = (CrearNuevaEmpresa) request.getAttribute("crearNuevaEmpresa");
%>

<head>
    <title>CREAR NUEVA EMPRESA</title>
    <style type="text/css">
        h1 {
            color: #4CAF50;
            font-size: 28px;
            font-weight: bold;
            margin-top: 40px;
            margin-bottom: 20px;
            text-align: center;
        }

        label {
            color: #333;
            font-size: 18px;
            font-weight: bold;
            margin-top: 10px;
            display: block;
        }

        input[type="text"], input[type="password"] {
            font-size: 16px;
            padding: 8px;
            border: 2px solid #ccc;
            border-radius: 4px;
            margin-top: 5px;
            margin-bottom: 20px;
            width: 100%;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 12px 24px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 20px;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #3e8e41;
        }
    </style>



</head>

<body>
<% System.out.println("HOLA");%>
<h1>HOLA PAGINA DE CREAR EMPRESAS</h1>
<h1>Formulario de Registro de Empresa</h1>
<%--@elvariable id="crearNuevaEmpresa" type=""--%>
<form:form method="post" action="/procesarFormularioEmpresa" modelAttribute="crearNuevaEmpresa">
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
    <form:hidden  path="valida" value="1"/>
    <input type="submit" value="Registrarse">

</form:form>

</body>
</html>
