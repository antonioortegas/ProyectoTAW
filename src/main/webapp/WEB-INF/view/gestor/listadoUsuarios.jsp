<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.proyectotaw.Entity.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.time.LocalDate" %>
<%--
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
    System.out.println("LISTA CUENTAS SOSPECHOSAS: " + listaCuentasSospechosas);
    //Date field 30 days before today
    LocalDate date = LocalDate.now().minusDays(30);
    Date dateBefore30Days = java.sql.Date.valueOf(date);
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
            <td>
                <form:form action="/gestor/filtrar" method="post" modelAttribute="filtroUsuarios">
                    Propiedad:
                    <form:select path="propiedadU">
                        <form:option value="">-----</form:option>
                        <form:option value="30d">30d sin actividad</form:option>
                        <form:option value="Pendiente de alta">Pendiente de alta</form:option>
                        <form:option value="Actividad sospechosa">Actividad sospechosa</form:option>
                    </form:select>
                    Orden:
                    <form:select path="ordenU">
                        <form:option value="idUsuario">ID</form:option>
                        <form:option value="nif">NIF</form:option>
                        <form:option value="nombre">Nombre</form:option>
                        <form:option value="empresaByEmpresaIdEmpresa">Empresa</form:option>
                        <form:option value="tipoUsuario">Tipo</form:option>
                    </form:select>
                    <form:button>Filtrar</form:button>
                </form:form>
            </td>
            <td>
                <form:form action="/gestor/filtrar" method="post" modelAttribute="filtroEmpresas">
                    Propiedad:
                    <form:select path="propiedadE">
                        <form:option value="">-----</form:option>
                        <form:option value="30d">30d sin actividad</form:option>
                        <form:option value="Pendiente de alta">Pendiente de alta</form:option>
                        <form:option value="Actividad sospechosa">Actividad sospechosa</form:option>
                    </form:select>
                    Orden:
                    <form:select path="ordenE">
                        <form:option value="idEmpresa">ID</form:option>
                        <form:option value="cif">CIF</form:option>
                        <form:option value="nombre">Nombre</form:option>
                        <form:option value="estadoEmpresa">Estado</form:option>
                    </form:select>
                    <form:button>Filtrar</form:button>
                </form:form>
            </td>
        </tr>
        <tr>
            <td><h1>Usuarios:</h1></td>


            <td><h1>Empresas:</h1></td>

        </tr>

        <tr>
            <td>
                <table class="tableUsuarios">
                    <tr>
                        <th>NIF</th>
                        <th>Nombre</th>
                        <th>Empresa</th>
                        <th>Tipo de Usuario</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                    <% if (listaUsuarios != null) { %>
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

                        <!-- Possible actions from "gestor" -->
                        <td>
                            <!-- Check if the user has any active requests -->


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
                                <button><a href="/gestor/aceptarAltaUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Alta</a></button>
                                <button><a href="/gestor/denegarAltaUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Denegar</a></button><br>
                                <% } %>

                                <!-- Solicitud de activacion estando inactivo -->
                                <% if(usuario.getEstadoUsuario().equals("inactivo")&&listaPeticiones.contains("activar")) { %>
                                <button><a href="/gestor/aceptarActivarUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Activar</a></button>
                                <button><a href="/gestor/denegarActivarUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Denegar</a></button>
                                <% } %>

                                <!-- Solicitud de desbloqueo estando bloqueado -->
                                <% if(usuario.getEstadoUsuario().equals("bloqueado")&&listaPeticiones.contains("desbloqueo")) { %>
                                <button><a href="/gestor/aceptarDesbloquearUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Desbloquear</a></button>
                                <button><a href="/gestor/denegarDesbloquearUsuario?id_usuario=<%= usuario.getIdUsuario() %>">Denegar</a></button>
                                <% } %>
                            <% } %>

                            <!-- Check if the user is suspicious or inactive -->
                            <%
                                Boolean sospechoso = false;
                                Boolean inactivo = false;
                            %>
                            <%if(usuario.getCuentabancoByCuentaBancoIdCuentaBanco()!=null){
                                    for(TransaccionEntity transaction : usuario.getCuentabancoByCuentaBancoIdCuentaBanco().getTransaccionsByIdCuentaBanco()){
                                        if(transaction.getPagoByPagoIdPago()!=null){
                                            if(transaction.getFechaInstruccion().after(dateBefore30Days)){
                                                inactivo = false;

                                            }
                                            for (CuentabancoEntity cuentasospechosa : listaCuentasSospechosas) {
                                                if(transaction.getPagoByPagoIdPago().getIbanBeneficiario()!=null){
                                                    if(transaction.getPagoByPagoIdPago().getIbanBeneficiario().equals(cuentasospechosa.getIban())){
                                                        sospechoso = true;
                                                    }
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
                    <% } %>
                </table>
            </td>

            <td>
                <table>
                    <tr>
                        <th>CIF</th>
                        <th>NOMBRE</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>

                    <% if (listaEmpresas != null) { %>
                    <% for (EmpresaEntity empresa : listaEmpresas) { %>
                    <tr>
                        <td><%= empresa.getCif() %></td>
                        <td>
                            <a href="/gestor/empresa?id_empresa=<%= empresa.getIdEmpresa() %>">
                                <%= empresa.getNombre() %>
                            </a>
                        </td>
                        <td><%= empresa.getEstadoEmpresa() %></td>
                        <td>
                            <% if(empresa.getPeticionsByIdEmpresa() != null){ %>
                                <%
                                    List<String> listaPeticiones = new ArrayList<>();
                                    for (PeticionEntity peticionEntity : empresa.getPeticionsByIdEmpresa()) {
                                        if (peticionEntity.getEstadoPeticion().equals("noprocesada")) {
                                            listaPeticiones.add(peticionEntity.getTipoPeticion());
                                        }
                                    }
                                %>
                                <% if(empresa.getEstadoEmpresa().equals("pendiente")&& listaPeticiones.contains("alta") ) { %>
                                    <button><a href="/gestor/aceptarAltaEmpresa?id_empresa=<%= empresa.getIdEmpresa() %>">Alta</a></button>
                                    <button><a href="/gestor/denegarAltaEmpresa?id_empresa=<%= empresa.getIdEmpresa() %>">Denegar</a></button><br>
                                <% } %>

                                <% if(empresa.getEstadoEmpresa().equals("inactiva")&&listaPeticiones.contains("activar")) { %>
                                    <button><a href="/gestor/aceptarActivarEmpresa?id_empresa=<%= empresa.getIdEmpresa() %>">Activar</a></button>
                                    <button><a href="/gestor/denegarActivarEmpresa?id_empresa=<%= empresa.getIdEmpresa() %>">Denegar</a></button>
                                <% } %>

                                <% if(empresa.getEstadoEmpresa().equals("bloqueada")&&listaPeticiones.contains("desbloqueo")) { %>
                                    <button><a href="/gestor/aceptarDesbloquearEmpresa?id_empresa=<%= empresa.getIdEmpresa() %>">Desbloquear</a></button>
                                    <button><a href="/gestor/denegarDesbloquearEmpresa?id_empresa=<%= empresa.getIdEmpresa() %>">Denegar</a></button>
                                <% } %>
                            <% } %>

                            <%
                                Boolean sospechoso = false;
                                Boolean inactivo = true;

                                //Iterate over the company account transactions to see if any of them are suspicious or all of them are older than 30 days
                                if(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco()!=null){
                                    for(TransaccionEntity transaction : empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getTransaccionsByIdCuentaBanco()){
                                        if(transaction.getPagoByPagoIdPago()!=null){
                                            if(transaction.getFechaInstruccion().after(dateBefore30Days)){
                                                inactivo = false;
                                            }
                                            for (CuentabancoEntity cuentasospechosa : listaCuentasSospechosas) {
                                                if(transaction.getPagoByPagoIdPago().getIbanBeneficiario()!=null){
                                                    if (transaction.getPagoByPagoIdPago().getIbanBeneficiario().equals(cuentasospechosa.getIban())) {
                                                        sospechoso = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

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