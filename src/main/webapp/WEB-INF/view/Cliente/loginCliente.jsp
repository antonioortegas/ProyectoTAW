<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Iniciar Sesión</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
            font-size: 28px;
            margin-bottom: 30px;
        }

        form {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0px 2px 5px #999;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-size: 16px;
            font-weight: bold;
            color: #333;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            box-shadow: 0px 2px 5px #ccc;
        }

        input[type="submit"],
        input[type="reset"] {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #0062cc;
        }
    </style>
</head>
<body>
<h1>Iniciar Sesión</h1>
<form action="/loginCliente" method="post">
    <label for="nif">NIF:</label>
    <input type="text" id="nif" name="nif" required>
    <label for="contrasena">Contraseña:</label>
    <input type="password" id="contrasena" name="contrasena" required>
    <input type="submit" value="Iniciar Sesión">
    <input type="reset" value="Limpiar">
</form>
</body>
</html>
