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
    UsuarioEntity empresa = (UsuarioEntity) request.getAttribute("empresa");
%>

<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="socio" type=""--%>
<%--@elvariable id="empresa" type=""--%>
<form:form method="post" modelAttribute="empresa" action="/editarDatosEmpresa" >
    Nombre: <form:input path="nombreEmpresa" size="30" maxlength="30"  /><br/>

    CIF <form:input path="cif" size="30" maxlength="30"  /><br/>
    <form:hidden path="calle"/>
    <form:hidden path="numero"/>
    <form:hidden path="planta"/>
    <form:hidden path="region"/>
    <form:hidden path="ciudad"/>
    <form:hidden path="pais"/>
    <form:hidden path="cp"/>
    <form:hidden path="contrasena"/>
    <form:hidden path="direccionByDireccionIdDireccion"/>
    <form:button>Submit</form:button>
</form:form>

</body>
</html>
