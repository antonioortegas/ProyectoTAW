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
    <title>Title</title>
</head>
<body>
<hi>Bienvenido <%=cliente.getNombre()%></hi><br>

<a href="/editarUsuario?id=<%= cliente.getIdUsuario() %>">Modificar mis datos</a><br>
Realizar una transferencia <br>
<a href="/cambioDeDivisaCliente?id=<%= cliente.getIdUsuario() %>">Realizar un cambio de divisa</a><br>
<a href="/historialOperaciones?id=<%= cliente.getIdUsuario() %>">Historial de operaciones</a><br>
Su cuenta se encuentra en estado: <%=cliente.getEstadoUsuario()%>.<br>
<% if(cliente.getEstadoUsuario().equals("inactivo")){%>
<a href="/nuevaPeticionInactivo?idUsuario=<%=cliente.getIdUsuario()%>">Solicitar activación.</a>
<%} else if(cliente.getEstadoUsuario().equals("bloqueado")){%>
<a href="/nuevaPeticionBloqueado?idUsuario=<%=cliente.getIdUsuario()%>">Solicitar desbloqueo.</a>
<%} else if(cliente.getEstadoUsuario().equals("pendiente")){%>
<a href="/nuevaPeticionAlta?idUsuario=<%=cliente.getIdUsuario()%>">Solicitar desbloqueo.</a>
<%}%>

    </body>
</html>
