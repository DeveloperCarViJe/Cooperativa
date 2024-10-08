<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COOPERATIVA FASTMOVIL</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Usuario.css">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/Usuario.js"></script>
</head>
<body>
    <jsp:include page="/Menu.jsp" />
    <div class="contentregistro">
		     <div class="form-group row d-flex justify-content-center align-items-center position-relative">
			    <div class="col-sm-8 text-center">
			        <h2 class="m-0">REGISTRO DE USUARIOS</h2>
			    </div>
			    <div class="position-absolute" style="top: 0; right: 10px;">
			        <c:if test="${not empty registroExitosoFalse}">
			            <div id="alertRegistroUsuario">
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
            <div class="row">
            	<div class="col-md-7">
		            <form action="/cooperativaFastmovil/UsuariosController" method="post">
		                <div class="form-section mb-4">
			                <div class="form-group row">
							    <label for="staticEmail" class="col-sm-3 col-form-label">NOMBRES:</label>
							    <div class="col-sm-6">
							        <input type="text" class="form-control" id="nombres" name="nombres" maxlength="50" required>
							    </div>
							</div>
							<div class="form-group row">
							    <label for="apellidos" class="col-sm-3 col-form-label">APELLIDOS:</label>
							    <div class="col-sm-6">
							        <input type="text" class="form-control" id="apellidos" name="apellidos" maxlength="50" required>
							    </div>
							</div>
							<div class="form-group row">
							    <label for="edad" class="col-sm-3 col-form-label">EDAD:</label>
							    <div class="col-sm-6">
							        <input type="text" class="form-control" id="edad" name="edad" maxlength="50" required>
							    </div>
							</div>
							<div class="form-group row">
							    <label for="usuario" class="col-sm-3 col-form-label">USUARIO:</label>
							    <div class="col-sm-6">
							        <input type="text" class="form-control" id="usuario" name="usuario" maxlength="50" required>
							    </div>
							</div>
							<div class="form-group row">
							    <label for="password" class="col-sm-3 col-form-label">PASSWORD:</label>
							    <div class="col-sm-6">
							        <input type="password" class="form-control" id="password" name="password" maxlength="50" required>
							    </div>
							</div>
							<div class="form-group row">
							    <label for="email" class="col-sm-3 col-form-label">EMAIL:</label>
							    <div class="col-sm-6">
							        <input type="email" class="form-control" id="email" name="email" maxlength="50" required>
							    </div>
							</div>
							<div class="form-group row">
							    <label for="telefono" class="col-sm-3 col-form-label">TELEFONO:</label>
							    <div class="col-sm-6">
							        <input type="text" class="form-control" id="telefono" name="telefono" maxlength="50" required>
							    </div>
							</div>
							<div class="form-group row align-items-center">
							    <label class="col-sm-3 col-form-label">ROL:</label>
							    <div class="col-sm-8">
							        <div class="form-check form-check-inline">
							            <input class="form-check-input" type="radio" name="flexRadioRol" id="flexRadioRol1" value="ADMINISTRADOR" checked>
							            <label class="form-check-label" for="flexRadioRol1">
							                ADMINISTRADOR
							            </label>
							        </div>
							        <div class="form-check form-check-inline">
							            <input class="form-check-input" type="radio" name="flexRadioRol" id="flexRadioRol2" value="OPERADOR">
							            <label class="form-check-label" for="flexRadioRol2">
							                OPERADOR
							            </label>
							        </div>
							    </div>
							</div>
						</div>
		               <div class="form-group row">
						    <div class="col-sm-6 offset-sm-2 d-flex justify-content-center">
						        <button type="submit" class="btn btn-secondary btn-lg px-5 py-2" name="accion" value="Registrar">REGISTRAR USUARIO</button>
						    </div>
						</div>
		            </form>
		          </div>
	            <div class="col-md-3">
	                <img src="${pageContext.request.contextPath}/Imagenes/usuarioRegistro.png" alt="Logotipo de Taxi en la pantalla principal" width="400">
	            </div>
	        </div>
        </div>
</body>
</html>