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
<%
    UsuarioEntity cliente = (UsuarioEntity) request.getAttribute("cliente");
%>

<head>
    <title>Banco ABC</title>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            font-size: 16px;
            color: #333;
        }

        h1 {
            color: #0072c6;
        }

        .mensaje {
            border: 2px solid #0072c6;
            padding: 20px;
            margin: 20px auto;
            width: 60%;
            text-align: center;
            border-radius: 10px;
        }
    </style>
</head>

<body>
<div class="mensaje">
    <h1>Bienvenido <%=cliente.getNombre()%></h1>
    <p>Su cuenta está inactiva. Si quiere solicitar su activacion pulse <a href="/nuevaPeticionActivacion?idUsuario=<%=cliente.getIdUsuario()%>">aquí</a>.</p>
</div>
</body>

</html>
