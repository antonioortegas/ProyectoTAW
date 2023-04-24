bloquearSocios.jsp<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 20/04/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aplicación Bancaria</title>
</head>
<body>
<h1>Bienvenido a la Aplicación Bancaria</h1>
<h2>Menú Principal</h2>
<button onclick="altaSocio()">Dar de alta a nuevo socio</button>
<button onclick="modificarDatos()">Modificar datos</button>
<button onclick="bloquearSocios()">Bloquear socios</button>
<button onclick="transferenciaBancaria()">Transferencia bancaria</button>
<button onclick="cambioDivisas()">Cambio de divisas</button>
<button onclick="verHistorial()">Ver historial de operaciones</button>
<button onclick="estadoCuenta()">Estado de la cuenta</button>
<button onclick="salir()">Salir</button>

</body>
</html>
