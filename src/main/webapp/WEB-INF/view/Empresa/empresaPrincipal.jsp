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

    List<EmpresaEntity> listaEmpresa = (List<EmpresaEntity>) request.getAttribute("empresa");

%>

<head>
    <title>Title</title>
</head>
<body>
<a href="crearNuevaEmpresa"> NUEVA EMPRESA</a>
<a> NUEVO SOCIO</a>
<a> INCIAR SESION EMPRESA</a>
<a> INCIAR SESION SOCIO</a>

<% System.out.println("HOLA");%>

<%
    for (EmpresaEntity e:listaEmpresa) {

%>
<%=e.getNombre()%><br>
<%
    }
%>
</body>
</html>
