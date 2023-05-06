<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.TransaccionEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.CuentabancoEntity" %>
<%@ page import="es.taw.proyectotaw.dao.UsuarioRepository" %><%--
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
    List<UsuarioEntity> actores = (List<UsuarioEntity>) request.getAttribute("actores");
%>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <%
        CuentabancoEntity cuentaBanco = socio.getEmpresaByEmpresaIdEmpresa().getCuentabancoByCuentaEmpresaIdCuentaBanco();
        if (cuentaBanco != null) {
    %>
    <h2>Transacciones de la Empresa :</h2>
    <tr>
        <th>Nombre</th>
        <th>IBAN</th>
        <th>Fecha de Instruccion</th>
    </tr>


    <%
        for (TransaccionEntity transaccion : cuentaBanco.getTransaccionsByIdCuentaBanco()) {

    %>
    <tr>
        <td>
            <%
                for (UsuarioEntity u : actores) {
                    if (u.getIdUsuario() == transaccion.getIdUsuarioActor()) {
            %>
            <%=       u.getNombre() %>
            <%=       u.getPrimerApellido() %>
            <%
                if (u.getSegundoApellido() != null) {
            %>
            <%= u.getSegundoApellido() %>
            <%
                        }
                    }
                }
            %>


        </td>
        <td><%= cuentaBanco.getIban() %>
        </td>
        <td><%= transaccion.getFechaInstruccion() %>
        </td>


    </tr>
    <%
            }
        }
    %>


</table>
</body>
</html>
