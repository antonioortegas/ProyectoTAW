<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 20/04/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    List<UsuarioEntity> listaUsuarios = (List<UsuarioEntity>) request.getAttribute("listaUsuarios");

%>

<head>
    <title>Title</title>
</head>
<body>

<%
    for (UsuarioEntity u:listaUsuarios) {

%>
    <%=u.getNombre()%><br>
<%
    }
%>
</body>
</html>
