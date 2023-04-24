<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 20/04/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
    <title>Lista de Socios</title>
</head>
<body>
<h1>Lista de Socios</h1>
<ul id="listaSocios">
    <li>
        <span>Nombre Socio 1</span>
        <span>Estado: Activo</span>
        <button onclick="bloquearDesbloquearSocio(1)">Bloquear/Desbloquear</button>
    </li>
    <li>
        <span>Nombre Socio 2</span>
        <span>Estado: Activo</span>
        <button onclick="bloquearDesbloquearSocio(2)">Bloquear/Desbloquear</button>
    </li>
    <!-- Añadir más elementos de lista para los demás socios -->
</ul>

<script>
    // Función para bloquear o desbloquear a un socio
    function bloquearDesbloquearSocio(idSocio) {
        // Obtener el elemento de lista correspondiente al socio seleccionado
        var liElement = document.getElementById("listaSocios").querySelectorAll("li")[idSocio - 1];
        // Obtener el estado actual del socio
        var estadoElement = liElement.querySelector("span:nth-child(2)");
        var estado = estadoElement.textContent.split(": ")[1]; // Extraer el estado del texto

        // Cambiar el estado del socio y actualizar el botón
        if (estado === "Activo") {
            estadoElement.textContent = "Estado: Bloqueado";
            liElement.querySelector("button").textContent = "Desbloquear";
        } else {
            estadoElement.textContent = "Estado: Activo";
            liElement.querySelector("button").textContent = "Bloquear";
        }
    }
</script>
</body>
</html>
