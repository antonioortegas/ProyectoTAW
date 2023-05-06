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
    UsuarioEntity socio = (UsuarioEntity) request.getAttribute("socio");
%>

<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="socio" type=""--%>
<form:form method="post" modelAttribute="socio" action="/guardarSocio" >
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
    <form:hidden path="tipoPersonaRelacionada"/>
    <form:hidden path="direccionByDireccionIdDireccion"/>
    <form:hidden path="estadoUsuario"/>
    <form:hidden path="tipoUsuario"/>
    <form:button>Submit</form:button>
</form:form>
<button><a href="/goPrincipalEmpresa?id=<%=socio.getIdUsuario()%>">SALIR</a></button>

</body>
</html>
