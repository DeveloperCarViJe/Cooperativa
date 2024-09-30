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
    <jsp:include page="/Menu.jsp" />
    <div class="contentregistro">
            <div class="form-group row d-flex justify-content-center align-items-center position-relative">
			    <div class="col-sm-8 text-center">
			        <h2 class="m-0">REGISTRO DE CHOFERES</h2>
			        <p id="alertaMovil"></p>
			    </div>
			    <div class="position-absolute" style="top: 0; right: 10px;">
			            <div id="alertRegistroChofer" style="display: ${mostrarAlerta ? 'block' : 'none'};">
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
			    </div>
			</div>
            <div class="row">
            	<div class="col-md-7">
		            <form id="formRegistroChoferes" action="/cooperativaFastmovil/ChoferesController" method="post">
						<div class="form-section mb-4">
						    <h3>DATOS CHOFER</h3>
						    <div class="form-group row">
						        <label for="movil" class="col-sm-2 col-form-label">MOVIL:</label>
						        <div class="col-sm-2">
						            <input type="text" class="form-control" id="movil" name="movil" maxlength="5" required>
						        </div>
						    </div>
						    <div class="form-group row">
						        <label for="nombres" class="col-sm-2 col-form-label">NOMBRES:</label>
						        <div class="col-sm-4">
						            <input type="text" class="form-control" id="nombres" name="nombres" maxlength="50" required>
						        </div>
						        <label for="apellidos" class="col-sm-2 col-form-label">APELLIDOS:</label>
						        <div class="col-sm-4">
						            <input type="text" class="form-control" id="apellidos" name="apellidos" maxlength="50" required>
						        </div>
						    </div>
						    <div class="form-group row">
						        <label for="edad" class="col-sm-2 col-form-label">EDAD:</label>
						        <div class="col-sm-4">
						            <input type="text" class="form-control" id="edad" name="edad" maxlength="50" required>
						        </div>
						        <label for="email" class="col-sm-2 col-form-label">EMAIL:</label>
						        <div class="col-sm-4">
						            <input type="email" class="form-control" id="email" name="email" maxlength="50" required>
						        </div>
						    </div>
						    <div class="form-group row">
						        <label for="telefono" class="col-sm-2 col-form-label">TELEFONO:</label>
						        <div class="col-sm-4">
						            <input type="text" class="form-control" id="telefono" name="telefono" maxlength="50" required>
						        </div>
						        <label for="direccion" class="col-sm-2 col-form-label">DIRECCION:</label>
						        <div class="col-sm-4">
						            <input type="text" class="form-control" id="direccion" name="direccion" maxlength="50" required>
						        </div>
							</div>
							<h3>DATOS VEHICULO</h3>
							<div class="form-group row">
						        <label for="modelo" class="col-sm-2 col-form-label">MODELO:</label>
						        <div class="col-sm-4">
						            <input type="text" class="form-control" id="modelo" name="modelo" maxlength="50" required>
						        </div>
						        <label for="color" class="col-sm-2 col-form-label">COLOR:</label>
						        <div class="col-sm-4">
						            <input type="text" class="form-control" id="color" name="color" maxlength="50" required>
						        </div>
						        <label for="placa" class="col-sm-2 col-form-label">PLACA:</label>
						        <div class="col-sm-4">
						            <input type="text" class="form-control" id="placa" name="placa" maxlength="50" required>
						            <input type="hidden" name="accion" value="Registrar">
						        </div>
							</div>
						</div>
				        <div class="form-group row">
							 <div class="col-sm-11 offset-sm-2 d-flex justify-content-center">
							     <button type="submit" id="registrarChoferBtn" class="btn btn-secondary btn-lg px-4 py-2" name="accion" value="Registrar">REGISTRAR CHOFER</button>
							 </div>
						</div>
		            </form>
		          </div>
					<div class="col-md-4 d-flex justify-content-end align-items-start" style="margin-top: 60px; margin-left: 90px;"> <!-- Ajusta el margen según necesites -->
					    <img src="${pageContext.request.contextPath}/Imagenes/choferRegistro.png" alt="Logotipo de REgistro de Chofer" class="img-fluid" style="max-width: 300px; height: auto; max-height: 300px;"> <!-- Cambia max-height según necesites -->
					</div>
	        </div>
        </div>
</body>
</html>