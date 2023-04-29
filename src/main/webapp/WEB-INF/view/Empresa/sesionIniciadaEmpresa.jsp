<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %><%--
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
    <title>Aplicación Bancaria</title>
</head>
<body>
<h1>Bienvenido a la Aplicación Bancaria</h1>
<h2>Menú Principal</h2>
<button><a href="">Dar de alta a nuevo socio</a></button>
<button><a href="Empresa/bloquearSocios">Bloquear socios</a></button>
<button><a href="Empresa/editarDatosSocio?id=<%= socio.getIdUsuario() %>" >Modificar datos</a></button>
<button><a href="">Transferencia bancaria</a></button>
<button><a href="">Cambio de divisas</a></button>
<button><a href="">Ver historial de operaciones</a></button>
<button><a href="">Estado de la cuenta</a></button>
<button><a href="">Salir</a></button>

</body>
</html>
