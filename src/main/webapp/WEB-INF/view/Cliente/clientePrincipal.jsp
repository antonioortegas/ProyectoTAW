<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
Created by IntelliJ IDEA.
User: Carlos Dominguez
Date: 06/05/2023
Time: 14:00
--%>
<html>
<head>
    <title>Inicio</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #f1f1f1;
        }

        .header {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
        }

        .header h1 {
            margin: 0;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            margin-top: 20px;
            margin-bottom: 20px;
            border-radius: 5px;
        }

        .container a {
            display: block;
            margin-bottom: 10px;
            text-decoration: none;
            color: #333;
            font-weight: bold;
            font-size: 20px;
        }

        .container a:hover {
            background-color: #f1f1f1;
            color: #000;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Bienvenido</h1>
</div>
<div class="container">
    <a href="crearNuevoCliente">Crear nuevo cliente</a>
    <a href="loginCliente">Iniciar sesión como cliente</a>
    <br><button> <a href="/">Salir</a></button><br>
</div>
</body>
</html>

