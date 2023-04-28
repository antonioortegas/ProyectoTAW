<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.entity.EmpresaEntity" %><%--
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
Cambio de divisas <br>
Historial de operaciones <br>
</body>
</html>
