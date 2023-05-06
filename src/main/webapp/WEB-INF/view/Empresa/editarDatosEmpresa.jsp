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
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-top: 50px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px #999;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="password"] {
            padding: 10px;
            border-radius: 5px;
            border: none;
            box-shadow: 0px 0px 5px #999;
            margin-bottom: 20px;
            width: 100%;
        }

        input[type="submit"],
        input[type="reset"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-right: 10px;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #3e8e41;
        }
    </style>
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
    <button>    <a href="/goPrincipalEmpresa?id=<%=socio.getIdUsuario()%>">SALIR</a></button>

</form:form>

</body>
</html>
