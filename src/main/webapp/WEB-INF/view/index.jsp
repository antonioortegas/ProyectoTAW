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


<head>
    <title>Title</title>
</head>
<body>
<td>${pageContext.session.id}</td><br>
<button> <a href="Empresa/empresaPrincipal">Empresa</a>  </button> <br>
<button> <a href="Cliente/clientePrincipal">Cliente</a></button> <br>
<button> <a href="" >Gestor </a></button><br>
<button> <a href="" >Asistente </a></button><br>
</body>
</html>
