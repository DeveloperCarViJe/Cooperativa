<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COOPERATIVA FASTMOVIL</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
        }
        .menu {
            width: 200px;
            background-color: #f4f4f4;
            padding: 15px;
            box-shadow: 2px 0 5px rgba(0,0,0,0.1);
        }
        .menu a {
            display: block;
            padding: 10px;
            text-decoration: none;
            color: #333;
            margin-bottom: 5px;
        }
        .menu a:hover {
            background-color: #ddd;
        }
        .content {
            flex: 1;
            padding: 15px;
        }
    </style>
</head>
<body>
	<div class="menu">
        <h2>Menú</h2>
        <a href="index.jsp">USUARIOS</a>
        <a href="about.jsp">CHOFERES</a>
        <a href="services.jsp">DESTINOS</a>
        <a href="contact.jsp">CARRERAS</a>
    </div>
    <div class="content">
        <!-- Aquí va el contenido de la página -->
        <h2>REGISTRO DE USUARIOS</h2>
	    <form action="/cooperativaFastmovil/UsuariosController" method="post">
	        <label for="nombres">Nombres:</label>
	        <input type="text" id="nombres" name="nombres" maxlength="50" required><br><br>
	        
	        <label for="apellidos">Apellidos:</label>
	        <input type="text" id="apellidos" name="apellidos" maxlength="50" required><br><br>
	        
	        <label for="edad">Edad:</label>
	        <input type="number" id="edad" name="edad" required><br><br>
	        
	        <label for="usuario">Usuario:</label>
	        <input type="text" id="usuario" name="usuario" maxlength="20" required><br><br>
	        
	        <label for="password">Contraseña:</label>
	        <input type="password" id="password" name="password" maxlength="20" required><br><br>
	        
	        <label for="email">Email:</label>
	        <input type="email" id="email" name="email" maxlength="50" required><br><br>
	        
	        <label for="telefono">Teléfono:</label>
	        <input type="text" id="telefono" name="telefono" maxlength="10" required><br><br>
	        
	        <button type="submit" name="accion" value="Registrar">Registrar</button>
    	</form>
    </div>
</body>
</html>