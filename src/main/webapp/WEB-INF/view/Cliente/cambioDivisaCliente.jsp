<%--
Created by IntelliJ IDEA.
User: Carlos Dominguez
Date: 06/05/2023
Time: 14:00
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.CambiodivisaEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%
    UsuarioEntity cliente = (UsuarioEntity) request.getAttribute("cliente");
    List<CambiodivisaEntity> cambioDivisa = (List<CambiodivisaEntity>) request.getAttribute("cambioDivisa");
%>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        #container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        h1 {
            text-align: center;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 30px;
        }
        label {
            margin-top: 10px;
            font-size: 18px;
        }
        select {
            margin-top: 10px;
            padding: 5px;
            font-size: 16px;
        }
        button {
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 18px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0062cc;
        }
    </style>
</head>
<body>
<div id="container">
    <h1>Cambio de Divisa</h1>
    <div>La cuenta tiene un saldo de <%=cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getSaldo()%> <%=cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getTipoMoneda()%></div>
    <form method="post" action="/verificarCambioDivisa">
        <label for="cambio">Seleccione la moneda a la que desea convertir:</label>
        <input type="hidden" name="id" value="<%=cliente.getIdUsuario()%>">
        <select id="cambio" name="cambio">
            <% for(CambiodivisaEntity cd: cambioDivisa){%>
            <option value="<%=cd.getIdCambioDivisa()%>"><%=cd.getMonedaCompra()%></option>
            <%}%>
        </select>
        <button>Realizar cambio</button>
        <br><button> <a href="/">Salir</a></button><br>
    </form>
</div>
</body>
</html>

