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
<td>${pageContext.session.id}</td><br><br><br>
<h6> Accediendo con el siguiente sessionid: <%= session.getId() %> </h6>

<button> <a href="crearNuevaEmpresa"> NUEVA EMPRESA</a></button><br>
<button> <a href="crearUsuarioEmpresa"> NUEVO SOCIO</a></button><br>
<button> <a href=""> INCIAR SESION EMPRESA</a></button><br>
<button> <a href="loginSocio"> INCIAR SESION SOCIO</a></button><br>


</body>
</html>
