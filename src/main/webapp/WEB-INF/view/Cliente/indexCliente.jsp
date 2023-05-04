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
    UsuarioEntity cliente = (UsuarioEntity) request.getAttribute("cliente");
%>

<head>
    <title>Bienvenido <%=cliente.getNombre()%></title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
        }

        h1 {
            text-align: center;
            margin-top: 50px;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .container {
            width: 80%;
            max-width: 800px;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        .links {
            display: flex;
            justify-content: space-between;
            margin-top: 30px;
        }

        .button {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.2s ease;
        }

        .button:hover {
            background-color: #0062cc;
        }

        .status {
            text-align: center;
            font-weight: bold;
            margin-top: 30px;
        }

        .status.inactivo {
            color: #ff0000;
        }

        .status.bloqueado {
            color: #ffc107;
        }

        .status.pendiente {
            color: #007bff;
        }
    </style>
</head>

<body>
<div class="container">
    <h1>Bienvenido <%=cliente.getNombre()%></h1>

    <div class="links">
        <a href="/editarUsuario?id=<%= cliente.getIdUsuario() %>">Modificar mis datos</a>
        <a href="/pagoCliente?id=<%= cliente.getIdUsuario() %>">Realizar un pago</a>
        <a href="/cambioDeDivisaCliente?id=<%= cliente.getIdUsuario() %>">Realizar un cambio de divisa</a>
        <a href="/historialOperaciones?id=<%= cliente.getIdUsuario() %>">Historial de operaciones</a>
    </div>

    <div class="status <%=cliente.getEstadoUsuario()%>">
        Su cuenta se encuentra en estado: <%=cliente.getEstadoUsuario()%>.
            <% if(cliente.getEstadoUsuario().equals("inactivo")){%>
        <br><a href="/nuevaPeticionInactivo?idUsuario=<%=cliente.getIdUsuario()%>" class="button">Solicitar activación</a>
            <%} else if(cliente.getEstadoUsuario().equals("bloqueado")){%>
        <br><a href="/nuevaPeticionBloqueado?idUsuario=<%=cliente.getIdUsuario()%>">Solicitar desbloqueo.</a>
            <%} else if(cliente.getEstadoUsuario().equals("pendiente")){%>
        <a href="/nuevaPeticionAlta?idUsuario=<%=cliente.getIdUsuario()%>">Solicitar desbloqueo.</a>
            <%}%>
    </div>
</div>
</body>
</html>