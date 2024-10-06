<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COOPERATIVA FASTMOVIL</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Choferes.css">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/Choferes.js"></script>
</head>
<body>
     <div class="contentregistroDetalleChofer">
   	    <jsp:include page="/Menu.jsp" />
    	<div class="h2-container-chofer">
			<h2>DETALLE CHOFER - MOVIL 2</h2>
		</div>
		<div class="flex-container-detalle-chofer">
			<div class="bordered-section-Chofer"> <!-- Sección con borde -->
	            <img src="${pageContext.request.contextPath}/Imagenes/usuarioRegistro.png" alt="Logotipo de Taxi en la pantalla principal" class="detalle-chofer-image">
	        </div>
	        <div class="h3-container-chofer">
		        <h3>NOMBRES: </h3>
		        <h3>APELLIDOS: </h3>
		        <h3>EDAD: </h3>
		        <h3>EMAIL: </h3>
		        <h3>TELEFONO: </h3>
		        <h3>DIRECCION: </h3>
		        <h3>MODELO VEHICULO: </h3>
		        <h3>NUMERO PLACA: </h3>
		        <h3>COLOR VEHICULO: </h3>
		        <h3>FECHA INGRESO: </h3>
		    </div>
		</div>
			<h2 style="margin-top: 20px; margin-left: 2px; margin-bottom: 8px; justify-content: flex-start; font-size: 120%; font-family: a r i a l, serif; font-weight: bold;">FOTOS DE LA UNIDAD</h2>
			<div class="flex-container-detalle-chofer" style=" margin-top: 1px;">
				<div class="bordered-section-Chofer">
		            <img src="${pageContext.request.contextPath}/Imagenes/carro1.jpg" alt="Logotipo de Taxi en la pantalla principal" class="detalle-chofer-image">
		        </div>
		         <div class="bordered-section-Chofer">
			        <img src="${pageContext.request.contextPath}/Imagenes/carro2.jpg" alt="Otra imagen" class="detalle-chofer-image">
			    </div>
			    <div class="bordered-section-Chofer">
			        <img src="${pageContext.request.contextPath}/Imagenes/carro3.jpg" alt="Otra imagen" class="detalle-chofer-image">
			    </div>
			</div>
    </div>
</body>
</html>