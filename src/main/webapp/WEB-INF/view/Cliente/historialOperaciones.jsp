<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.TransaccionEntity" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 20/04/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    UsuarioEntity cliente = (UsuarioEntity) request.getAttribute("cliente");
%>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <%
        if (cliente.getCuentabancoByCuentaBancoIdCuentaBanco() != null){
    %>
    <h2>Historial de transacciones:</h2>
    <tr>
        <th>Nombre</th>
        <th>IBAN</th>
        <th>Fecha de Instruccion</th>
        <th>Tipo</th>
    </tr>


    <%
        for (TransaccionEntity transaccion : cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getTransaccionsByIdCuentaBanco()) {
    %>
    <tr>
        <td>
            <%= cliente.getNombre() %>
            <%= cliente.getPrimerApellido() %>
            <%
                if(cliente.getSegundoApellido() != null) {
            %>
            <%= cliente.getSegundoApellido() %>
            <%
                }
            %>
        </td>
        <td><%= cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getIban() %></td>
        <td><%= transaccion.getFechaInstruccion() %></td>
        <td><%if(transaccion.getCambiodivisaByCambioDivisaIdCambioDivisa()!=null){ %>
            Cambio de divisa
        <%}else{%>
            Pago
            <%}%>
        </td>


    </tr>
    <%
            }
        }
    %>


</table>
</body>
</html>
