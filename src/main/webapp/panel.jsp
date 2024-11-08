<%-- 
    Document   : panel
    Created on : 28/10/2024, 9:27:07 a. m.
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de usuarios ADSO</title>
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
    </head>
    <body>
        <main class:"container">
        <h1 style="color:blue">Hola, <%= request.getAttribute("usuarios")%>!!,
        Bienvenido a proyecto ADSO(:</h1>
        <h3 style="color:blue">Este es tu panel de usuarios  <%= request.getAttribute("usuarios")%>!!</h3>

    </main>
</body>
</html>
