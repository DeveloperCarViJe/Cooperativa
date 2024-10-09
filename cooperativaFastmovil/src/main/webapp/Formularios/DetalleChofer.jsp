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
			<h2>DETALLE CHOFER - MOVIL <%= request.getAttribute("movil") %></h2>
		</div>
		<div class="flex-container-detalle-chofer">
			<div class="bordered-section-Chofer"> <!-- Sección con borde -->
	            <img src="data:${tipoImagen};base64,${imagenPerfil}" alt="Imagen Perfil Chofer" class="detalle-chofer-image">
	        </div>
	        <div class="h3-container-chofer">
			    <c:forEach var="chofer" items="${choferes}">
			        <div class="h3-group">
			            <h3 style="font-weight: bold;">NOMBRES: </h3><h3>${chofer.nombres}</h3>
			        </div>
			        <div class="h3-group">
			            <h3 style="font-weight: bold;">APELLIDOS: </h3><h3>${chofer.apellidos}</h3>
			        </div>
			        <div class="h3-group">
			            <h3 style="font-weight: bold;">EDAD: </h3><h3>${chofer.edad}</h3>
			        </div>
			        <div class="h3-group">
			            <h3 style="font-weight: bold;">EMAIL: </h3><h3>${chofer.email}</h3>
			        </div>
			        <div class="h3-group">
			            <h3 style="font-weight: bold;">TELEFONO: </h3><h3>${chofer.telefono}</h3>
			        </div>
			        <div class="h3-group">
			            <h3 style="font-weight: bold;">DIRECCION: </h3><h3>${chofer.direccion}</h3>
			        </div>
			        <div class="h3-group">
			            <h3 style="font-weight: bold;">MODELO VEHICULO: </h3><h3>${chofer.modelo}</h3>
			        </div>
			        <div class="h3-group">
			            <h3 style="font-weight: bold;">NUMERO PLACA: </h3><h3>${chofer.numero_placa}</h3>
			        </div>
			        <div class="h3-group">
			            <h3 style="font-weight: bold;">COLOR VEHICULO: </h3><h3>${chofer.color_vehiculo}</h3>
			        </div>
			        <div class="h3-group">
			            <h3 style="font-weight: bold;">FECHA INGRESO: </h3><h3><%= request.getAttribute("fechaFormateada") %></h3>
			        </div>
			    </c:forEach>
			</div>
		</div>
			<h2 style="margin-top: 20px; margin-left: 2px; margin-bottom: 8px; justify-content: flex-start; font-size: 120%; font-family: a r i a l, serif; font-weight: bold;">FOTOS DE LA UNIDAD</h2>
			<div class="flex-container-detalle-chofer" style=" margin-top: 0px;">
				<c:forEach var="mostrarImagenV" items="${mostrarImagenV}">
					<div class="bordered-section-Chofer">
			            <img src="data:${mostrarImagenV.tipo_imagen};base64,${mostrarImagenV.imagen}" alt="Imagen del vehiculo" class="detalle-chofer-image">
			        </div>
			    </c:forEach>  
			</div>
    </div>
</body>
</html>