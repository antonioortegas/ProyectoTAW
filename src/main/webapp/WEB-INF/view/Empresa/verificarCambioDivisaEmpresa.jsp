<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.CambiodivisaEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    UsuarioEntity socio = (UsuarioEntity) request.getAttribute("socio");
    EmpresaEntity empresa = (EmpresaEntity) request.getAttribute("empresa");
    CambiodivisaEntity cd = (CambiodivisaEntity) request.getAttribute("cambioDivisa");
    int pasta = (int) request.getAttribute("pasta");
%>

<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        #container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 18px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            text-decoration: none;
        }

        a:hover {
            background-color: #0062cc;
        }
    </style>
</head>
<body>
<div id="container">
    <div>La cuenta tiene un saldo
        de <%=empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getSaldo()%> <%=empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getTipoMoneda()%>
    </div>
    <div>Y pasará a tener <%=pasta%> <%=cd.getMonedaCompra()%>
    </div>
    <a href="/goPrincipalEmpresa?id=<%=socio.getIdUsuario()%>">Cancelar operación</a>
    <a href="/realizarCambioEmpresa?id=<%=empresa.getIdEmpresa()%>&cambioDivisa=<%=cd.getIdCambioDivisa()%>&pasta=<%=pasta%>">Verificar
        cambio</a>
</div>
</body>
</html>
