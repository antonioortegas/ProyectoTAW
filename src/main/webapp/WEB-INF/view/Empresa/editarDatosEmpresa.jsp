<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>
<%@ page import="es.taw.proyectotaw.ui.FEditarEmpresa" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 20/04/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%

    FEditarEmpresa fEditarEmpresa = (FEditarEmpresa) request.getAttribute("fEditarEmpresa");
    UsuarioEntity socio = (UsuarioEntity) request.getAttribute("socio");
%>

<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="fEditarEmpresa" type=""--%>
<form:form method="post" modelAttribute="fEditarEmpresa" action="/guardarEmpresa">
    Nombre: <form:input path="nombre" size="30" maxlength="30"/><br/>
    CIF: <form:input path="cif" size="30" maxlength="30"/><br/>
    <form:hidden path="idEmpresa"></form:hidden>
    <form:hidden path="direccionByDireccionIdDireccion"></form:hidden>
    <form:hidden path="cuentabancoByCuentaEmpresaIdCuentaBanco"></form:hidden>
    <form:hidden path="idSocio"></form:hidden>
    <form:button>Submit</form:button>
</form:form>
<button>    <a href="/goPrincipalEmpresa?id=<%=socio.getIdUsuario()%>">SALIR</a></button>

</body>
</html>
