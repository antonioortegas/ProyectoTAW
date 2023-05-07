<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="es.taw.proyectotaw.Entity.EmpresaEntity" %><%--
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

    EmpresaEntity empresa = (EmpresaEntity) request.getAttribute("empresa");
%>
<head>
    <title>Aplicación Bancaria</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        css
        Copy code
        h1 {
            text-align: center;
            color: #333;
        }

        h2 {
            margin-top: 20px;
            color: #333;

        }

        status {
            padding: 10px;
            margin: 20px auto;
            max-width: 500px;
            border-radius: 5px;
            color: #fff;
            font-weight: bold;
            text-align: center;
        }

        inactive {
            background-color: #ff9800;
        }

        blocked {
            background-color: #f44336;
        }

        pending {
            background-color: #2196f3;
        }

        button {
            display: inline-block;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            background-color: #4CAF50;
            color: #fff;
            text-align: center;
            font-size: 16px;
            margin: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #3e8e41;
        }

        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            align-items: center;
            margin-top: 30px;
            max-width: 800px;
            margin: 0 auto;
        }

        .card {
            background-color: #fff;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            margin: 20px;
            padding: 20px;
            text-align: center;
            width: 300px;
            border-radius: 5px;
            transition: box-shadow 0.3s ease-in-out;
        }

        card:hover {
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
        }

        card h3 {
            font-size: 20px;
            color: #333;
            margin-bottom: 20px;
        }

        card a {
            display: block;
            margin-top: 10px;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            background-color: #4CAF50;
            color: #fff;
            text-align: center;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        card a:hover {
            background-color: #3e8e41;
        }
    </style>
</head>
<body>
<h1>Bienvenido a la Aplicación Bancaria</h1>
<h2>Menú Principal</h2>
<%="Bienvenido " + socio.getNombre() + ", "+ socio.getTipoUsuario()+"  de la Empresa: " + socio.getEmpresaByEmpresaIdEmpresa().getNombre()%> <br>


<div class="status <%=empresa.getEstadoEmpresa()%>">
    Su cuenta se encuentra en estado: <%=empresa.getEstadoEmpresa()%>.
    <% if (empresa.getEstadoEmpresa().equals("inactiva")) {%>
    <br><a href="/nuevaPeticionInactivoEmpresa?idUsuario=<%=empresa.getIdEmpresa()%>" class="button">Solicitar
    activación</a>
    <%} else if (empresa.getEstadoEmpresa().equals("bloqueada")) {%>
    <br><a href="/nuevaPeticionBloqueadoEmpresa?idUsuario=<%=empresa.getIdEmpresa()%>">Solicitar desbloqueo.</a>
    <%} else if (empresa.getEstadoEmpresa().equals("pendiente")) {%>
    <a href="/nuevaPeticionAltaEmpresa?idUsuario=<%=empresa.getIdEmpresa()%>">Solicitar alta.</a>
    <%} else { %>
</div>

<a>IBAN: </a><%=socio.getEmpresaByEmpresaIdEmpresa().getCuentabancoByCuentaEmpresaIdCuentaBanco().getIban()%><br>
<a>SALDO:</a><%=empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getSaldo() + " "+empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getTipoMoneda()%><br>
<%
    if (!socio.getTipoPersonaRelacionada().toLowerCase().equals("bloqueada")) {
%>
<%
    if (socio.getTipoUsuario().toLowerCase().equals("socio")) {

%>
<button><a href="Empresa/registrarNuevoSocio?id=<%= socio.getIdUsuario() %>">Dar de alta a nuevo socio</a></button>
<button><a href="Empresa/bloquearSocios?id=<%=socio.getEmpresaByEmpresaIdEmpresa().getIdEmpresa()%>">Lista de socios</a>
</button>
<button><a href="/Empresa/editarDatosSocio?id=<%= socio.getIdUsuario() %>">Modificar datos personales</a></button>
<button><a href="Empresa/editarDatosEmpresa?id=<%= socio.getIdUsuario() %>">Modificar datos Empresa</a></button>

<%
    }
%>

<br>
<br>
<button><a href="/pagoEmpresa?id=<%=socio.getIdUsuario()%>">Transferencia bancaria</a>
</button>
<button><a href="/cambioDeDivisaEmpresa?id=<%= socio.getIdUsuario() %>">Cambio de
    divisas</a></button>
<button><a href="/historialOperacionesEmpresa?id=<%=socio.getIdUsuario()%>">Ver historial de operaciones</a></button>
<button><a href="/Asistencia/asistente">Chat de ayuda</a></button>
<br>

<%
} else {
%><a>Estas bloqueado/a por la empresa, contacata con tu superior</a>

<%
    }
%>

<%
    }
%>


<br>
<button><a href="/Empresa/SalirEmpresa">Cerrar sesion</a></button>
<br>
<button><a href="/">Salir</a></button>

</body>
</html>
