<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COOPERATIVA FASTMOVIL</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Formato.css">
<script src="${pageContext.request.contextPath}/js/Formato.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/Menu.jsp" />
<div class="content">
	<div class="h2-container-destinos">
	<h2>DESTINOS CARRERAS</h2>
	</div>
        <form id="formRegistroChoferes" action="/cooperativaFastmovil/ChoferesController" method="post" enctype="multipart/form-data">
            <div class="form-section">
                <div class="form-group row">
                    <label for="origen" class="col-sm-1 col-form-label">ORIGEN:</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="origen" name="origen" maxlength="200" required>
                    </div>
                    <label for="destino" class="col-sm-1 col-form-label">DESTINO:</label>
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
</body>
</html>