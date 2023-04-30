<%@ page import="es.taw.proyectotaw.Entity.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.time.MonthDay" %>
<%@ page import="java.util.concurrent.TimeUnit" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 30/04/2023
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<UsuarioEntity> listaUsuarios = (List<UsuarioEntity>) request.getAttribute("listaUsuarios");
    List<EmpresaEntity> listaEmpresas = (List<EmpresaEntity>) request.getAttribute("listaEmpresas");
    List<CuentabancoEntity> listaCuentasSospechosas = (List<CuentabancoEntity>) request.getAttribute("listaCuentasSospechosas");

    //Date field 30 days before today
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -30);
    Date dateBefore30Days = cal.getTime();
%>



<html>
<head>
    <title>Usuarios</title>
    <!-- Start Styles -->
    <style type="text/css">

        table table{
            background-color:#eee;
            border-collapse:collapse;
        }
        table table th { background-color:#000;color:white; }
        table table td, table table th { padding:5px;border:1px solid #000; }

        .wrap { -webkit-border-horizontal-spacing: 100px; }
        .wrap tr td { vertical-align: top; }

        div button {
            padding: 5px;
            margin: 5px;
        }
    </style>
    <!-- End Styles -->

</head>
<body>

    <table class="wrap">
        <tr>
            <td><h1>Usuarios:</h1></td>
            <td><h1>Empresas:</h1></td>
        </tr>
        <tr>
            <td>
                <table class="tableUsuarios">
                    <tr>
                        <th>NIF<%=dateBefore30Days%></th>
                        <th>Nombre</th>
                        <th>Empresa</th>
                        <th>Tipo de Usuario</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>

                    <% for (UsuarioEntity usuario : listaUsuarios) { %>
                    <tr>
                        <td><%= usuario.getNif() %></td>
                        <td>
                            <a href="/gestor/cliente?id_usuario=<%= usuario.getIdUsuario() %> ">
                                <%= usuario.getNombre() %>
                                <%= usuario.getPrimerApellido() %>
                                <%
                                    if(usuario.getSegundoApellido() != null) {
                                %>
                                <%= usuario.getSegundoApellido() %>
                                <%
                                    }
                                %>
                            </a>
                        </td>
                        <td><%
                            if(usuario.getEmpresaByEmpresaIdEmpresa() != null) {
                        %>
                            <%= usuario.getEmpresaByEmpresaIdEmpresa().getNombre() %>
                        <%
                            }
                        %></td>
                        <td><%= usuario.getTipoUsuario() %></td>
                        <td><%= usuario.getEstadoUsuario() %></td>

                        <!-- Posible actions from "gestor" -->
                        <td>
                            <% if(usuario.getPeticionsByIdUsuario() != null){ %>
                                <%
                                    List<String> listaPeticiones = new ArrayList<>();
                                    for (PeticionEntity peticionEntity : usuario.getPeticionsByIdUsuario()) {
                                        if (peticionEntity.getEstadoPeticion().equals("noprocesada")) {
                                            listaPeticiones.add(peticionEntity.getTipoPeticion());
                                        }
                                    }
                                %>

                                <!-- El usuario ha solicitado el alta en el sistema -->
                                <% if(usuario.getEstadoUsuario().equals("pendiente")&& listaPeticiones.contains("alta") ) { %>
                                <button><a href="/gestor/aceptarUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Alta</a></button>
                                <button><a href="/gestor/denegarUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Denegar</a></button><br>
                                <% } %>

                                <!-- Solicitud de activacion estando inactivo -->
                                <% if(usuario.getEstadoUsuario().equals("inactivo")&&listaPeticiones.contains("activar")) { %>
                                <button><a href="/gestor/activarUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Activar</a></button>
                                <button><a href="/gestor/denegarActivacionUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Denegar</a></button>
                                <% } %>

                                <!-- Solicitud de desbloqueo estando bloqueado -->
                                <% if(usuario.getEstadoUsuario().equals("bloqueado")&&listaPeticiones.contains("desbloqueo")) { %>
                                <button><a href="/gestor/desbloquearUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Desbloquear</a></button>
                                <button><a href="/gestor/denegarDesbloqueoUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Denegar</a></button>
                                <% } %>
                            <% } %>

                            <%  Boolean sospechoso = false;
                                Boolean inactivo = false;


                                //Iterate over the users of the company to se if any of them has made a transaction to a suspicious account

                                    if(usuario.getCuentabancoByCuentaBancoIdCuentaBanco() != null && usuario.getEstadoUsuario().equals("activo")) {
                                        for (TransaccionEntity transaccion : usuario.getCuentabancoByCuentaBancoIdCuentaBanco().getTransaccionsByIdCuentaBanco()) {
                                            if (transaccion.getPagoByPagoIdPago() != null) {
                                                if(transaccion.getFechaInstruccion().before(dateBefore30Days)){
                                                    inactivo = true;
                                                }
                                                for (CuentabancoEntity cuentasospechosa : listaCuentasSospechosas) {
                                                    if (transaccion.getPagoByPagoIdPago().getBeneficiarioByBeneficiarioIdBeneficiario().getNumeroCuentaBeneficiario()
                                                            .equals(usuario.getCuentabancoByCuentaBancoIdCuentaBanco().getIban())) {
                                                        sospechoso = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                            %>

                            <!-- Bloquear si el usuario es sospechoso -->
                            <% if(usuario.getEstadoUsuario().equals("activo")&&sospechoso) { %>
                            <button><a href="/gestor/bloquearUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Bloquear</a></button>
                            <% } %>

                            <!-- Desactivar si hace >30d desde la ultima transaccion -->
                            <% if(usuario.getEstadoUsuario().equals("activo")&&inactivo) { %>
                            <button><a href="/gestor/desactivarUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Desactivar</a></button><br>
                            <% } %>
                        </td>
                    </tr>
                    <% } %>
                </table>
            </td>

            <td>
                <table>
                    <tr>
                        <th>CIF</th>
                        <th>NOMBRE</th>
                        <th>ACCIONES</th>
                    </tr>

                    <% for (EmpresaEntity empresa : listaEmpresas) { %>
                    <tr>
                        <td><%= empresa.getCif() %></td>
                        <td>
                            <a href="/gestor/empresa?id_empresa=<%= empresa.getIdEmpresa() %>">
                                <%= empresa.getNombre() %>
                            </a>
                        </td>
                        <td>
                            <%  Boolean sospechoso = false;
                                Boolean inactivo = false;

                                //Iterate over the active users of the company to se if any of them has made a transaction to a suspicious account
                                for(UsuarioEntity usuario : empresa.getUsuariosByIdEmpresa()){
                                    if(usuario.getCuentabancoByCuentaBancoIdCuentaBanco() != null && usuario.getEstadoUsuario().equals("activo")) {
                                        for (TransaccionEntity transaccion : usuario.getCuentabancoByCuentaBancoIdCuentaBanco().getTransaccionsByIdCuentaBanco()) {
                                            if (transaccion.getPagoByPagoIdPago() != null) {
                                                if(transaccion.getFechaInstruccion().before(dateBefore30Days)){
                                                    inactivo = true;
                                                }
                                                for (CuentabancoEntity cuentasospechosa : listaCuentasSospechosas) {
                                                    System.out.println(transaccion.getPagoByPagoIdPago().getBeneficiarioByBeneficiarioIdBeneficiario().getNumeroCuentaBeneficiario());
                                                    System.out.println(usuario.getCuentabancoByCuentaBancoIdCuentaBanco().getIban());
                                                    if (transaccion.getPagoByPagoIdPago().getBeneficiarioByBeneficiarioIdBeneficiario().getNumeroCuentaBeneficiario()
                                                            .equals(usuario.getCuentabancoByCuentaBancoIdCuentaBanco().getIban())) {
                                                        sospechoso = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            %>
                                <%
                                if (sospechoso) { %>
                                    <button><a href="/gestor/bloquearEmpresa?id_empresa=<%= empresa.getIdEmpresa() %>">Bloquear</a></button>
                                <% } %>
                                <%
                                if (inactivo) { %>
                                    <button><a href="/gestor/desactivarEmpresa?id_empresa=<%= empresa.getIdEmpresa() %>">Desactivar</a></button>
                                <% } %>
                        </td>
                    </tr>
                    <% } %>
                </table>
            </td>
            <td>
                <table>
                    <tr>
                        <td>
                            <div>
                                <button><a href="/">Home</a></button>
                            </div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</body>
</html>