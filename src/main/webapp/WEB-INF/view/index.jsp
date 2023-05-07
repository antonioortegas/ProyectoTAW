<!--
AUTOR : Sergio Morejón Pérez - 100%
-->

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


<head>
    <title>Title</title>
    <style>
        button {
            background-color: #ff9800;
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
<a href="Empresa/empresaPrincipal"><button>Empresa</button></a>
<br>
<a href="Cliente/cientePrincipal"><button>Cliente</button></a>
<br>
<a href="gestor/usuarios"><button>Gestor</button></a>
<br>
<a href="Asistencia/asistente"><button>Asistente</button></a>
<br>
</body>
</html>
