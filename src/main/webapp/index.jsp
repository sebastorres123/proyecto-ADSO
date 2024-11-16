<%-- 
    Document   : index
    Created on : 28/10/2024, 9:23:19 a. m.
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>proyecto adso</title>
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
            >
        
    </head>
    <body>
        <main class="container">
        <h1>LOGIN ADSO</h1>
        <h3 style="color: red">
            <%= request.getAttribute("mensajeError") != null ? request.getAttribute("mensajeError") : "" %>
        </h3>
        <form action="recibirdatos" name="login" method="POST">
            <input type="text" name="user" placeholder="usuario">
            <input type="text" name="password" placeholder="contraseña">
            <input type="submit" value="ingresar">
        </form>
        </main>
    </body>
</html>
