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
    EmpresaEntity empresa = (EmpresaEntity) request.getAttribute("empresa");
%>

<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="socio" type=""--%>
<%--@elvariable id="empresa" type=""--%>
<form:form method="post" modelAttribute="empresa" action="/editarDatosEmpresa" >
    Nombre: <form:input path="nombre" size="30" maxlength="30"  /><br/>
    CIF: <form:input path="cif" size="30" maxlength="30"  /><br/>

    <form:button>Submit</form:button>
</form:form>

</body>
</html>
