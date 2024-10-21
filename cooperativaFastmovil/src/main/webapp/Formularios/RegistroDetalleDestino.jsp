<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COOPERATIVA FASTMOVIL</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Destinos.css">
<script src="${pageContext.request.contextPath}/js/Destinos.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/Menu.jsp" />
<div class="content">
	<div class="form-group row d-flex justify-content-center align-items-center position-relative">
			    <div class="h2-container-destinos">
			        <h2>DESTINOS CARRERAS</h2>
			    </div>
			    <div class="position-absolute" style="top: 0; right: 10px;">
			        <c:if test="${not empty registroExitosoFalse}">
			            <div id="alertRegistroDestino">
			                <div class="alert alert-success alert-dismissible fade show" role="alert">
			                    <strong></strong> 
			                    <c:choose>
			                        <c:when test="${registroExitosoFalse == 'true'}">
			                            Registro ingresado correctamente.
			                        </c:when>
			                        <c:otherwise>
			                            Error al ingresar el registro.
			                        </c:otherwise>
			                    </c:choose>
			                </div>
			            </div>
			        </c:if>
			    </div>
			</div>
        <form id="formRegistroChoferes" action="/cooperativaFastmovil/DestinoCarreraController" method="post">
            <div class="form-section">
                <div class="form-group row">
                    <label for="origen" class="col-sm-1 col-form-label">ORIGEN:</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="origen" name="origen" maxlength="200" required>
                    </div>
                    <label for="destino" class="col-sm-1 col-form-label">DESTINO:</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="destino" name="destino" maxlength="200" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="valor" class="col-sm-1 col-form-label">VALOR:</label>
                    <div class="col-sm-1">
                        <input type="text" class="form-control" id="valor" name="valor" maxlength="10" required>
                    </div>
                    <div class="col-sm-10 text-right">
                        <button type="submit" class="btn btn-secondary btn-lg px-4 py-2" name="accion" value="Registrar">REGISTRAR DESTINO</button>
                    </div>
                </div>
            </div>
        </form>
</div>
</body>
</html>