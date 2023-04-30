<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.TransaccionEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %><%--
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
%>

<html>
<head>
    <title>Detalles</title>

    <style type="text/css">

        .wrap{ -webkit-border-horizontal-spacing: 100px;}
        .wrap tr td { vertical-align: top; }

        div table{
            background-color:#eee;
            border-collapse:collapse;
        }
        div table th { background-color:#000;color:white; }
        div table td, div table th { padding:5px;border:1px solid #000; }

        button {
            padding: 10px;
            margin: 15px;
        }
    </style>

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
                        <tr>
                            <th>Nombre</th>
                            <th>IBAN</th>
                            <th>Fecha de Instruccion</th>
                        </tr>


                        <%
                            for (TransaccionEntity transaccion : usuario.getCuentabancoByCuentaBancoIdCuentaBanco().getTransaccionsByIdCuentaBanco()) {
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
                </div>
            </td>
        </tr>
    </table>



</body>
</html>
