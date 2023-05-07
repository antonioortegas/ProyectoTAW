<!--
AUTOR : ANTONIO ORTEGA SANTAOLALLA - 100%
-->

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.TransaccionEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>
<%@ page import="org.w3c.dom.stylesheets.LinkStyle" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 30/04/2023
  Time: 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    UsuarioEntity usuario = (UsuarioEntity) request.getAttribute("usuario");
    EmpresaEntity empresa = usuario.getEmpresaByEmpresaIdEmpresa();
    List<TransaccionEntity> listaTransacciones = (List<TransaccionEntity>) request.getAttribute("listaTransacciones");
%>

<html>
<head>
    <title>Detalles</title>

    <style type="text/css">

        body {
            font-family: Arial, sans-serif;
            font-size: 13px;
            line-height: 1.5;
        }

        /* Styles for form elements */
        form {
            display: inline-block;
            margin-bottom: 10px;
        }

        select {
            padding: 5px 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 16px;
            background-color: #fff;
            color: #333;
        }

        button {
            padding: 5px 10px;
            border-radius: 5px;
            border: none;
            font-size: 13px;
            color: #000000;
            cursor: pointer;
            font-weight: bold;
        }

        /* Styles for table */
        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 10px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            vertical-align: top;
            border: 1px solid #ccc;
            font-size: 13px;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        /* Styles for headings */
        h1 {
            margin: 0;
            font-size: 16px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        /* Styles for links */
        a {
            color: #000000;
            font-weight: bold;
            text-decoration: none;
            width: inherit;
            display: block;
        }

        a:hover {
            text-decoration: underline;
            background-color: #DAD8D8;
        }

        tr td table tr td:hover {
            background-color: #DAD8D8;
        }

        a:visited {
            color: #000000;
        }

    </style>
    <!-- End Styles -->

</head>
<body>


    <table class="wrap">
        <tr>
            <td>
                <button> <a href="/gestor/usuarios">Back</a></button>
                <button> <a href="/">Home</a></button><br>
                <hr>
            </td>
        </tr>
        <tr>
            <td>
                <h1>Detalles Cliente</h1>
                <hr>
                <h2>Usuario :</h2>
                ID de Usuario: <%= usuario.getIdUsuario() %><br>
                NIF: <%= usuario.getNif() %><br>
                Nombre: <%= usuario.getNombre() %>
                <%
                    if(usuario.getSegundoNombre() != null) {
                %>
                <%= usuario.getSegundoNombre() %><br>
                <%
                    }
                %>
                Apellidos: <%= usuario.getPrimerApellido() %>
                <%
                    if(usuario.getSegundoApellido() != null) {
                %>
                <%= usuario.getSegundoApellido() %><br>
                <%
                    }
                %>
                Fecha de Nacimiento: <%= usuario.getFechaNacimiento() %><br>
                Tipo de Usuario: <%= usuario.getTipoUsuario() %><br>
                Estado del Usuario: <%= usuario.getEstadoUsuario() %><br>
                Cuenta Bancaria:
                <% if(usuario.getCuentabancoByCuentaBancoIdCuentaBanco() != null) { %>
                <%= usuario.getCuentabancoByCuentaBancoIdCuentaBanco().getIban() %><br>
                <% } else { %>
                PENDIENTE DE ASIGNAR
                <% } %>
                <hr>
                <h2>Direccion : </h2>
                Pais: <%= usuario.getDireccionByDireccionIdDireccion().getPais() %><br>
                Ciudad: <%= usuario.getDireccionByDireccionIdDireccion().getCiudad() %><br>
                Codigo Postal: <%= usuario.getDireccionByDireccionIdDireccion().getCp() %><br>
                Calle: <%= usuario.getDireccionByDireccionIdDireccion().getCalle() %><br>
                Numero: <%= usuario.getDireccionByDireccionIdDireccion().getNumero() %><br>
                Puerta: <%= usuario.getDireccionByDireccionIdDireccion().getPuerta() %><br>
                <br>

                <%
                    if(empresa!=null){
                %>
                <hr>
                <h2>Trabaja para :</h2>
                Nombre: <%= empresa.getNombre() %><br>
                CIF: <%= empresa.getCif() %><br>
                Dirección: <%= empresa.getDireccionByDireccionIdDireccion().getPais()
                    + ", " + empresa.getDireccionByDireccionIdDireccion().getCiudad()
                    + ", " + empresa.getDireccionByDireccionIdDireccion().getCp()

                    + ", " + empresa.getDireccionByDireccionIdDireccion().getCalle()
                    + ", " + empresa.getDireccionByDireccionIdDireccion().getNumero()
                    + ", " + empresa.getDireccionByDireccionIdDireccion().getPuerta() %><br>
                <%
                    }
                %>
            </td>
            <td>
                <div>
                    <table>
                        <%
                            if (usuario.getCuentabancoByCuentaBancoIdCuentaBanco() != null){
                        %>
                        <h2>Transacciones del cliente :</h2>
                        <hr>
                        <div>
                            <form:form action="/gestor/filtrarTransacciones" method="post" modelAttribute="filtroTransaccion">
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
                </div>
            </td>
        </tr>
    </table>



</body>
</html>
