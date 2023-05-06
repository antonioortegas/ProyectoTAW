<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.TransaccionEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.CuentabancoEntity" %>
<%@ page import="es.taw.proyectotaw.dao.UsuarioRepository" %><%--
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
    List<UsuarioEntity> actores = (List<UsuarioEntity>) request.getAttribute("actores");
    List<TransaccionEntity> transacciones = (List<TransaccionEntity>) request.getAttribute("listaTransacciones");
%>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }
        h2 {
            color: #4CAF50;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: #fff;
        }
        button {
            margin-top: 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #4CAF50;
        }
    </style>
</head>
<body>

<table border="1">
    <%
        CuentabancoEntity cuentaBanco = socio.getEmpresaByEmpresaIdEmpresa().getCuentabancoByCuentaEmpresaIdCuentaBanco();
        if (cuentaBanco != null) {
    %>

    <h2>Transacciones de la Empresa :</h2>
    <div>
        <%--@elvariable id="filtroTransaccionEmpresa" type=""--%>
        <form:form action="/Empresa/filtrarTransaccionesEmpresa" method="post"
                   modelAttribute="filtroTransaccionEmpresa">
            <form:hidden path="id_empresa" value="${empresa.getIdEmpresa()}"/>
            <form:hidden path="id_socio" value="${socio. getIdUsuario()}"/>
            Propiedad:
            <form:select path="propiedad">
                <form:option value="">-----</form:option>
                <form:option value="Pago">Pago</form:option>
                <form:option value="Cambio de divisa">Cambio de divisa</form:option>

            </form:select>
            Orden:
            <form:select path="orden">
                <form:option value="idTransaccion">ID</form:option>
                <form:option value="fechaInstruccion">Fecha</form:option>
            </form:select>
            <form:button>Filtrar</form:button>
        </form:form>
    </div>
    <tr>
        <th>Nombre</th>
        <th>IBAN</th>
        <th>Fecha de Instruccion</th>
        <th>PAGO</th>
        <th>CAMBIO DE DIVISA</th>
    </tr>


    <%
        for (TransaccionEntity transaccion : transacciones) {

    %>
    <tr>
        <td>
            <%
                for (UsuarioEntity u : actores) {
                    if (u.getIdUsuario() == transaccion.getIdUsuarioActor()) {
            %>
            <%=       u.getNombre() %>
            <%=       u.getPrimerApellido() %>
            <%
                if (u.getSegundoApellido() != null) {
            %>
            <%= u.getSegundoApellido() %>
            <%
                        }
                    }
                }
            %>


        </td>
        <td><%= cuentaBanco.getIban() %>
        </td>
        <td><%= transaccion.getFechaInstruccion() %>
        </td>
        <td><%if (transaccion.getPagoByPagoIdPago() != null) { %>
            <%= transaccion.getPagoByPagoIdPago().getIbanBeneficiario() %>
            <% } %>
        </td>
        <td><%if (transaccion.getCambiodivisaByCambioDivisaIdCambioDivisa() != null) { %>
            <%= transaccion.getCambiodivisaByCambioDivisaIdCambioDivisa().getMonedaCompra() %>
            <% } %>
        </td>


    </tr>
    <%
            }
        }
    %>


</table>
<button><a href="/goPrincipalEmpresa?id=<%=socio.getIdUsuario()%>">SALIR</a></button>

</body>
</html>
