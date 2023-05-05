<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%
    UsuarioEntity cliente = (UsuarioEntity) request.getAttribute("cliente");
%>

<head>
    <title>PETICION</title>
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
    <h1>Petición recibida</h1>
    <p>Nuestros gestores están trabajando para solucionar su incidencia lo antes posible.</p>
</div>
</body>

</html>
