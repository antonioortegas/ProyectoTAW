<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 20/04/2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Gestión de Usuarios</title>
    <style>
        /* Estilos de ejemplo para dar formato a la lista de usuarios */
        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
            border: 1px solid #ccc;
            padding: 10px;
            background-color: #f9f9f9;
        }

        li:hover {
            background-color: #e9e9e9;
        }
    </style>
</head>
<body>
<h1>Gestión de Usuarios</h1>
<ul>
    <li>
        <input type="checkbox" name="usuario" value="usuario1"> Usuario 1
    </li>
    <li>
        <input type="checkbox" name="usuario" value="usuario2"> Usuario 2
    </li>
    <li>
        <input type="checkbox" name="usuario" value="usuario3"> Usuario 3
    </li>
    <!-- Agregar más usuarios de la lista aquí -->
</ul>
<br>
<button onclick="darRol('socio')">Dar Rol de Socio</button>
<button onclick="darRol('representante')">Dar Rol de Representante</button>

<script>
    function darRol(rol) {
        var usuariosSeleccionados = document.querySelectorAll('input[name=usuario]:checked');
        if (usuariosSeleccionados.length === 0) {
            alert("Selecciona al menos un usuario.");
            return;
        }
        var usuariosIds = Array.from(usuariosSeleccionados).map(function(usuario) {
            return usuario.value;
        });
        // Enviar los IDs de los usuarios y el rol seleccionado al servidor para su procesamiento
        // Puedes implementar aquí la lógica de tu aplicación para asignar los roles a los usuarios
        console.log("Usuarios seleccionados: " + usuariosIds);
        console.log("Rol seleccionado: " + rol);
    }
</script>
</body>
</html>

