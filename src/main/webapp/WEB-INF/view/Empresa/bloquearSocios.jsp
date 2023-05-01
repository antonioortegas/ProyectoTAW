<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="java.util.List" %><%--
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
    List<UsuarioEntity> listaUsuriosEmpresa = (List<UsuarioEntity>) request.getAttribute("listaUsuriosEmpresa");

%>
<head>
    <title>Lista de Socios</title>
</head>
<body>
<h1>Lista de Socios</h1>
<ul id="listaSocios">
    <%for (UsuarioEntity usuario : listaUsuriosEmpresa) {%>
    <li>
        <span><%= usuario.getNombre()%></span>
        <span><%= usuario.getPrimerApellido()%></span>
        <span><%= usuario.getTipoUsuario()%></span>
        <span><%= usuario.getTipoPersonaRelacionada()%></span>
        <!--<span><%=usuario.getEmpresaByEmpresaIdEmpresa().getNombre()%></span>-->
        <%
            if (usuario.getTipoPersonaRelacionada()=="bloqueada") {
        %>
            <button><a href="cambiarEstadoSocio?idCambio=<%= usuario.getIdUsuario()%> ">Desbloquear</a></button>
        <%
        } else {%>
        <button> <a href="cambiarEstadoSocio?idCambio=<%= usuario.getIdUsuario()%> ">Bloquear</a></button>
        <%
            }
        %>
    </li>
    <%}%>
    <!-- Añadir más elementos de lista para los demás socios -->
</ul>

</body>
</html>
