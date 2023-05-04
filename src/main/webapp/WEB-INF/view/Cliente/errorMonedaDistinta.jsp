<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Title</title>
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
    <p>La cuenta a la que intenta hacer un pago no utiliza el mismo tipo de moneda que usted.
        Si lo desea puede realizar un cambio de divisa desde el menú principal.<br> <a href="Cliente/clientePrincipal">Volver al menú principal.</a></p>
</div>
</body>

</html>
