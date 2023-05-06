<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.TransaccionEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 30/04/2023
  Time: 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<UsuarioEntity> usuariosDeLaEmpresa = (List<UsuarioEntity>) request.getAttribute("listaUsuarios");
    EmpresaEntity empresa = (EmpresaEntity) request.getAttribute("empresa");
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
                <h1>Detalles</h1>
                <hr>
                <h2>Empresa :</h2>
                Nombre: <%= empresa.getNombre() %><br>
                CIF: <%= empresa.getCif() %><br>
                Dirección: <%= empresa.getDireccionByDireccionIdDireccion().getPais()
                    + ", " + empresa.getDireccionByDireccionIdDireccion().getCiudad()
                    + ", " + empresa.getDireccionByDireccionIdDireccion().getCp()
                    + ", " + empresa.getDireccionByDireccionIdDireccion().getCalle()
                    + ", " + empresa.getDireccionByDireccionIdDireccion().getNumero()
                    + ", " + empresa.getDireccionByDireccionIdDireccion().getPuerta() %><br>
                Iban de la empresa:
                <% if(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco() != null) { %>
                <%= empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getIban() %><br>
                <% } else { %>
                PENDIENTE DE ASIGNAR
                <% } %>
                <hr>
                <h2>Socios / Autorizados</h2>
                <div>
                    <table>
                        <tr>
                            <th>NIF</th>
                            <th>Nombre</th>
                            <th>Estado</th>
                            <th>Tipo</th>
                            <th>F. de nacimiento</th>
                            <th>F. de incorporacion</th>
                            <th>Direccion</th>
                        </tr>
                        <%
                            for (UsuarioEntity usuario : usuariosDeLaEmpresa) {
                        %>
                        <tr>
                            <td><%= usuario.getNif() %></td>
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
                            <td><%= usuario.getEstadoUsuario() %></td>
                            <td><%= usuario.getTipoUsuario() %></td>
                            <td><%= usuario.getFechaNacimiento()%></td>
                            <td><%= usuario.getFechaInicio() %></td>
                            <td>
                                <%= usuario.getDireccionByDireccionIdDireccion().getPais()
                                        + ", " + usuario.getDireccionByDireccionIdDireccion().getCiudad()
                                        + ", " + usuario.getDireccionByDireccionIdDireccion().getCp()
                                        + ", " + usuario.getDireccionByDireccionIdDireccion().getCalle()
                                        + ", " + usuario.getDireccionByDireccionIdDireccion().getNumero()
                                        + ", " + usuario.getDireccionByDireccionIdDireccion().getPuerta() %>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>

                </div>


            </td>
            <td>
                <h2>Transacciones de la empresa :</h2>
                <div>
                    <%--@elvariable id="filtroTransaccionEmpresa" type=""--%>
                    <form:form action="/gestor/filtrarTransaccionesEmpresa" method="post" modelAttribute="filtroTransaccionEmpresa">
                        <form:hidden path="id_empresa" value="${empresa.getIdEmpresa()}"/>
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
                <div>
                    <table>

                        <tr>
                            <th>Fecha de instruccion</th>
                            <th>IBAN destino</th>
                            <th>Cambio de divisa</th>
                        </tr>

                        <%
                            if(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco()!=null && empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getTransaccionsByIdCuentaBanco()!=null){
                                for (TransaccionEntity transaccion : listaTransacciones) {
                        %>
                        <tr>
                            <td><%= transaccion.getFechaInstruccion() %></td>
                            <td>
                                <% if(transaccion.getPagoByPagoIdPago() != null) { %>
                                    <%= transaccion.getPagoByPagoIdPago().getIbanBeneficiario() %>
                                <% } %>
                            </td>
                            <td>
                                <% if(transaccion.getCambiodivisaByCambioDivisaIdCambioDivisa() != null) { %>
                                    <%= transaccion.getCambiodivisaByCambioDivisaIdCambioDivisa().getMonedaVenta() +
                                    " --> " + transaccion.getCambiodivisaByCambioDivisaIdCambioDivisa().getMonedaCompra()%>
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
