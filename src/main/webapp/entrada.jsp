<%@ page import="es.taw.proyectotaw.entity.UsuarioEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 20/04/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<UsuarioEntity> lista = (List<UsuarioEntity>) request.getAttribute("lista");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
ENTRADA.jsp

<%
   for (UsuarioEntity usuario : lista){

%>
    <%=usuario.getPrimerApellido()%><br>
<%
    }
%>

</body>
</html>
