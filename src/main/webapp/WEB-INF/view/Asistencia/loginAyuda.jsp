<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Ayuda</title>
</head>
<body>
<h1>Login</h1>
<form action="/Asistencia/loginAyuda" method="post">
    <label for="nif">NIF:</label>
    <input type="text" id="nif" name="nif" required>
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <br>
    <input type="submit" value="Submit">
</form>
<br>
</body>
</html>
