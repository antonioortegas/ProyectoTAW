<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.TransaccionEntity" %>
<%--
Created by IntelliJ IDEA.
User: Carlos Dominguez
Date: 06/05/2023
Time: 14:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    UsuarioEntity usuario = (UsuarioEntity) request.getAttribute("usuario");
    List<TransaccionEntity> listaTransacciones = (List<TransaccionEntity>) request.getAttribute("listaTransacciones");
%>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <%
        if (usuario.getCuentabancoByCuentaBancoIdCuentaBanco() != null){
    %>
    <h2>Historial de transacciones :</h2>
    <hr>
    <div>
        <%--@elvariable id="filtroTransaccion" type=""--%>
        <form:form action="/Cliente/filtrarTransacciones" method="post" modelAttribute="filtroTransaccion">
            <form:hidden path="id_usuario" value="${usuario.getIdUsuario()}"/>
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
        <th>TIPO</th>
        <th>Fecha de instruccion</th>
        <th>IBAN destino</th>
        <th>Cambio de divisa</th>
    </tr>


    <%
        for (TransaccionEntity transaccion : listaTransacciones) {
    %>
    <tr>
        <td>
            <%
                if(transaccion.getPagoByPagoIdPago() != null){
            %>
            <%= "Pago" %>
            <%
            } else {
            %>
            <%= "Cambio de divisa" %>
            <% } %>
        </td>
        <td><%= transaccion.getFechaInstruccion() %></td>
        <td>
            <%
                if(transaccion.getPagoByPagoIdPago() != null){
            %>
            <%= transaccion.getPagoByPagoIdPago().getIbanBeneficiario()%>
            <% } %>
        </td>
        <td>
            <% if(transaccion.getCambiodivisaByCambioDivisaIdCambioDivisa() != null){ %>
            <%= transaccion.getCambiodivisaByCambioDivisaIdCambioDivisa().getMonedaVenta() + " -> " + transaccion.getCambiodivisaByCambioDivisaIdCambioDivisa().getMonedaCompra()%>
            <% } %>
        </td>
    </tr>
    <%
            }
        }
    %>


</table>

<br><button> <a href="/">Salir</a></button><br>
</body>
</html>
