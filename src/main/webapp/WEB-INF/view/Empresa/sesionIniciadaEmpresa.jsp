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

    EmpresaEntity empresa = (EmpresaEntity) request.getAttribute("empresa");
%>
<head>
    <title>Aplicación Bancaria</title>
</head>
<body>
<h1>Bienvenido a la Aplicación Bancaria</h1>
<h2>Menú Principal</h2>
<%="Bienvenido " + socio.getNombre()%> <br>
<%
    if (socio.getTipoPersonaRelacionada().toLowerCase().equals("bloqueada")) {
%>
<a>Estas bloqueado/a por la empresa, contacata con tu superior</a>

<%
    }else{
%>
<%
    if (socio.getTipoUsuario().toLowerCase().equals("socio")) {

%>
    <button><a href="Empresa/crearNuevoSocio">Dar de alta a nuevo socio</a></button>
    <button><a href="Empresa/bloquearSocios?id=<%=socio.getEmpresaByEmpresaIdEmpresa().getIdEmpresa()%>">Lista de socios</a></button>
    <button><a href="/Empresa/editarDatosSocio?id=<%= socio.getIdUsuario() %>">Modificar datos personales</a></button>
    <button><a href="Empresa/editarDatosEmpresa?id=<%= socio.getIdUsuario() %>">Modificar datos Empresa</a></button>

<%
    }
%>

<br>
<%=socio.getEmpresaByEmpresaIdEmpresa().getNombre()%>
<br>
<button><a href="/pagoEmpresa?id=<%=socio.getEmpresaByEmpresaIdEmpresa().getIdEmpresa()%>">Transferencia bancaria</a></button>
<button><a href="/cambioDeDivisaEmpresa?id=<%= socio.getEmpresaByEmpresaIdEmpresa().getIdEmpresa() %>">Cambio de divisas</a></button>
<button><a href="/historialOperacionesEmpresa?id=<%=socio.getIdUsuario()%>">Ver historial de operaciones</a></button>
<button><a href="">Estado de la cuenta</a></button>
<button><a href="">Salir</a></button>
<br>
<br>
<br>
<a>IBAN: </a><%=socio.getEmpresaByEmpresaIdEmpresa().getCuentabancoByCuentaEmpresaIdCuentaBanco().getIban()%><br>
<a>SALDO:</a><%=socio.getEmpresaByEmpresaIdEmpresa().getCuentabancoByCuentaEmpresaIdCuentaBanco().getSaldo()%>
<%
    }
%>

<button><a href="/SalirEmpresa">Salir Empresa</a></button>

</body>
</html>
