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
<%--@elvariable id="cliente" type=""--%>
<form:form method="post" modelAttribute="cliente" action="/editarCliente" >
    Nombre: <form:input path="nombre" size="30" maxlength="30"  /><br/>
    Segundo nombre: <form:input path="segundoNombre" size="30" maxlength="30"  /><br/>
    Primer apellido: <form:input path="primerApellido" size="30" maxlength="30"  /><br/>
    Segundo Apellido: <form:input path="segundoApellido" size="30" maxlength="30"  /><br/>
    <form:hidden path="idUsuario"/>
    <form:hidden path="nif"/>
    <form:hidden path="contrasena"/>
    <form:hidden path="fechaNacimiento"/>
    <form:hidden path="fechaInicio"/>
    <form:hidden path="cuentabancoByCuentaBancoIdCuentaBanco"/>
    <form:hidden path="empresaByEmpresaIdEmpresa"/>
    <form:hidden path="direccionByDireccionIdDireccion"/>
    <form:button>Submit</form:button>
</form:form>

</body>
</html>
