<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.CambiodivisaEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    UsuarioEntity cliente = (UsuarioEntity) request.getAttribute("cliente");
    CambiodivisaEntity cd = (CambiodivisaEntity) request.getAttribute("cambioDivisa");
    int pasta = (Integer.parseInt(cd.getCantidadVenta())/Integer.parseInt(cd.getCantidadCompra()))*cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getSaldo();
%>

<head>
    <title>Title</title>
</head>
<body>
La cuenta tiene un saldo de <%cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getSaldo();  cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getTipoMoneda();%><br>
Y pasará a tener <%=pasta%> <% cd.getMonedaCompra();%><br>
<button onclick="/realizarCambio?id=<%=cliente.getIdUsuario()%>&cambioDivisa=<%=cd.getIdCambioDivisa()%>">Verificar cambio</button>
<button onclick="/volverIndex?id=<%=cliente.getIdUsuario()%>">Cancelar operacion</button>
</body>
</html>
