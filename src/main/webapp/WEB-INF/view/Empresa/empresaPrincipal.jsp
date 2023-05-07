<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %><%--
  Created by IntelliJ IDEA.
  User: Sergio Morejon Perez
  Date: 30/04/2023
  Time: 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<head>
    <title>Title</title>
    <style>
        button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
        }

        a {
            color: white;
            text-decoration: none;
        }

        a:hover {
            color: #f2f2f2;
        }
    </style>
</head>
<body>

<button> <a href="/Empresa/crearNuevaEmpresa"> NUEVA EMPRESA</a></button><br>
<!--<button> <a href="crearUsuarioEmpresa"> NUEVO SOCIO</a></button><br>
<button> <a href=""> INCIAR SESION EMPRESA</a></button><br>-->
<button> <a href="/Empresa/loginSocio"> INCIAR SESION SOCIO</a></button><br>
<button><a href="/">Salir</a></button>

</body>
</html>
