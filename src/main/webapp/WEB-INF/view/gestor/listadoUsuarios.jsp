<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %><%--
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

        button {
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
                        <th>NIF</th>
                        <th>Nombre</th>
                        <th>Empresa</th>
                        <th>Tipo de Usuario</th>
                        <th>Estado</th>
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
                        <td><%= usuario.getEmpresaByEmpresaIdEmpresa().getNombre() %></td>
                        <td><%= usuario.getTipoUsuario() %></td>
                        <td><%= usuario.getEstadoUsuario() %></td>
                    </tr>
                    <% } %>
                </table>
            </td>

            <td>
                <table>
                    <tr>
                        <th>CIF</th>
                        <th>NOMBRE</th>
                    </tr>

                    <% for (EmpresaEntity empresa : listaEmpresas) { %>
                    <tr>
                        <td><%= empresa.getCif() %></td>
                        <td>
                            <a href="/gestor/empresa?id_empresa=<%= empresa.getIdEmpresa() %>">
                                <%= empresa.getNombre() %>
                            </a>
                        </td>
                    </tr>
                    <% } %>
                </table>
            </td>
            <td>
                <table>
                    <tr>
                        <td>
                            <button><a href="/">Home</a></button><br>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</body>
</html>
