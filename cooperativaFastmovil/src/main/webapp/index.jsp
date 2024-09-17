<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <a href="FormUsuarios/RegistroUsuarios.jsp">USUARIOS</a>
        <a href="about.jsp">CHOFERES</a>
        <a href="services.jsp">DESTINOS</a>
        <a href="contact.jsp">CARRERAS</a>
    </div>
    <div class="content">
        <!-- Aquí va el contenido de la página -->
        <h1>Bienvenidos Menu Principal de la Cooperativa FastMovil</h1>
    </div>
</body>
</html>
