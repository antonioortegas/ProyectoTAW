<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.CambiodivisaEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    UsuarioEntity cliente = (UsuarioEntity) request.getAttribute("cliente");
    List<CambiodivisaEntity> cambioDivisa = (List<CambiodivisaEntity>) request.getAttribute("cambioDivisa");
%>

<head>
    <title>Title</title>
</head>
<body>
La cuenta tiene un saldo de <%cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getSaldo();  cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getTipoMoneda();%><br>
<form:form method="post" action="realizarCambioDivisa" >
    Cantidad:<input type="number" name="cantidad" max=<%=cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getSaldo()%>>
    La conversión será de <%=cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getTipoMoneda()%> a:
    <label for="cambio">--Selecciona la moneda de cambio--</label>
    <select id="cambio" name="cambio">
        <% for(CambiodivisaEntity cd : cambioDivisa){%>
        <option value="
            <%if(!cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getTipoMoneda().equals(cd.getMonedaVenta())){%>
                <%=cd.getMonedaVenta()%>"></option>
        <%}%>
        <%}%>
    </select><br>
    <form:button>Realizar cambio</form:button>
</form:form>

</body>
</html>
