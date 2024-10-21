<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>COOPERATIVA FAST MOVIL</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Usuario.css">
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/Usuario.js"></script>
</head>
<body>
    <jsp:include page="Menu.jsp" />
    <div class="content">
        <!-- Aquí va el contenido de la página -->
        <h1>BIENVENIDOS FAST MOVIL - COOPERTATIVA DE TAXI</h1>
        <img src="Imagenes/Taxi.png" alt="Logotipo de Taxi en la pantalla principal" width="400">
    </div>
</body>
</html>
