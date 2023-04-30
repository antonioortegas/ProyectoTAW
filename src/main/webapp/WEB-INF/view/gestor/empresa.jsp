<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.TransaccionEntity" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 30/04/2023
  Time: 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<UsuarioEntity> empresa = (List<UsuarioEntity>) request.getAttribute("empresa");
%>

<html>
<head>
    <title>Detalles</title>

    <style type="text/css">

        table{
            background-color:#eee;
            border-collapse:collapse;
        }
        table th { background-color:#000;color:white; }
        table td, table th { padding:5px;border:1px solid #000; }

    </style>
</head>
<body>
    <h1>Detalles Empresa</h1>
    <table>

        //TODO: Añadir los detalles de la empresa antes de la tabla<br><br>

        <tr>
            <th>Nombre</th>
            <th>IBAN</th>
            <th>Fecha</th>
        </tr>

        <%
            for (UsuarioEntity usuario : empresa) {
                for (TransaccionEntity transaccion : usuario.getCuentabancoByCuentaBancoIdCuentaBanco().getTransaccionsByIdCuentaBanco()){
        %>
                    <tr>
                        <td>
                            <%= usuario.getNombre() %>
                            <%= usuario.getPrimerApellido() %>
                            <%
                                if(usuario.getSegundoApellido() != null) {
                            %>
                            <%= usuario.getSegundoApellido() %>
                            <%
                                }
                            %>
                        </td>
                        <td><%= usuario.getCuentabancoByCuentaBancoIdCuentaBanco().getIban() %></td>
                        <td><%= transaccion.getFechaInstruccion() %></td>


                    </tr>
        <%
                }
            }
        %>

    </table>
</body>
</html>
