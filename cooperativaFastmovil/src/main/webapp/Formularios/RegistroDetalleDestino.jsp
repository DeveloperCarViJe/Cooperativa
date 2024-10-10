<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COOPERATIVA FASTMOVIL</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Destinos.css">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/Destinos.js"></script>
</head>
<body>
     <div class="contentDetalleDestinos">
   	    <jsp:include page="/Menu.jsp" />
    	<div class="h2-container-destinos">
			<h2>DESTINOS CARRERAS</h2>
		</div>
		     <div class="flex-container-detalle-chofer">
			            <form id="formRegistroChoferes" action="/cooperativaFastmovil/ChoferesController" method="post" enctype="multipart/form-data">
							<div class="form-section">
							    <div class="form-group row">
							        <label for="origen" class="col-sm-1 col-form-label">ORIGEN:</label>
							        <div class="col-sm-5">
							            <input type="text" class="form-control" id="origen" name="origen" maxlength="200" required>
							        </div>
							        <label for="destino" class="col-sm-1 col-form-label">DESINO:</label>
							        <div class="col-sm-5">
							            <input type="text" class="form-control" id="destino" name="destino" maxlength="50" required>
							        </div>
							    </div>
							    <div class="form-group row">
							        <label for="valor" class="col-sm-1 col-form-label">VALOR:</label>
							        <div class="col-sm-1">
							            <input type="text" class="form-control" id="valor" name="valor" maxlength="50" required>
							        </div>
							        <div class="col-sm-10 text-right">
								     <button type="submit" id="registrarChoferBtn" class="btn btn-secondary btn-lg px-4 py-2" name="accion" value="Registrar">REGISTRAR DESTINO</button>
								 	</div>
							    </div>
							</div>
			            </form>
		    </div>
	</div>
</body>
</html>