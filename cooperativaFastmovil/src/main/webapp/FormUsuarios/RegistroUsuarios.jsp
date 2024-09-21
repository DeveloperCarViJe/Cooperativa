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
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="menu">
        <h2>MENU</h2>
        <a href="${pageContext.request.contextPath}/FormUsuarios/RegistroUsuarios.jsp">USUARIOS</a>
        <a href="about.jsp">CHOFERES</a>
        <a href="services.jsp">DESTINOS</a>
        <a href="contact.jsp">CARRERAS</a>
    </div>
    <div class="contentregistro">
            <h2>REGISTRO DE USUARIOS</h2>
            <div class="row">
            	<div class="col-md-6">
		            <form action="/cooperativaFastmovil/UsuariosController" method="post">
		                <div class="form-group row">
						    <label for="staticEmail" class="col-sm-2 col-form-label">NOMBRES:</label>
						    <div class="col-sm-6">
						        <input type="text" class="form-control" id="nombres" name="nombres" maxlength="50" required>
						    </div>
						</div>
						<div class="form-group row">
						    <label for="apellidos" class="col-sm-2 col-form-label">APELLIDOS:</label>
						    <div class="col-sm-6">
						        <input type="text" class="form-control" id="apellidos" name="apellidos" maxlength="50" required>
						    </div>
						</div>
						<div class="form-group row">
						    <label for="edad" class="col-sm-2 col-form-label">EDAD:</label>
						    <div class="col-sm-6">
						        <input type="text" class="form-control" id="edad" name="edad" maxlength="50" required>
						    </div>
						</div>
						<div class="form-group row">
						    <label for="usuario" class="col-sm-2 col-form-label">USUARIO:</label>
						    <div class="col-sm-6">
						        <input type="text" class="form-control" id="usuario" name="usuario" maxlength="50" required>
						    </div>
						</div>
						<div class="form-group row">
						    <label for="password" class="col-sm-2 col-form-label">PASSWORD:</label>
						    <div class="col-sm-6">
						        <input type="password" class="form-control" id="password" name="password" maxlength="50" required>
						    </div>
						</div>
						<div class="form-group row">
						    <label for="email" class="col-sm-2 col-form-label">EMAIL:</label>
						    <div class="col-sm-6">
						        <input type="email" class="form-control" id="email" name="email" maxlength="50" required>
						    </div>
						</div>
						<div class="form-group row">
						    <label for="telefono" class="col-sm-2 col-form-label">TELEFONO:</label>
						    <div class="col-sm-6">
						        <input type="text" class="form-control" id="telefono" name="telefono" maxlength="50" required>
						    </div>
						</div>
						<div class="form-check">
						  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" checked>
						  <label class="form-check-label" for="flexRadioDefault1">
						    ADMINISTRADOR
						  </label>
						</div>
						<div class="form-check">
						  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2">
						  <label class="form-check-label" for="flexRadioDefault2">
						    OPERADOR
						  </label>
						</div>
		               <div class="form-group row">
						    <div class="col-sm-10 ml-auto mt-3">
						        <button type="submit" class="btn btn-secondary btn-lg" name="accion" value="Registrar">REGISTRAR USUARIO</button>
						    </div>
						</div>
		            </form>
		            <c:if test="${not empty registroExitosoFalse}">
		                <div id="alertContainer" class="mt-3">
		                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
		                        <strong></strong> <c:choose>
		                            <c:when test="${registroExitosoFalse == 'true'}">Registro ingresado correctamente.</c:when>
		                            <c:otherwise>Error al ingresar el registro.</c:otherwise>
		                        </c:choose>
		                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		                            <span aria-hidden="true">&times;</span>
		                        </button>
		                    </div>
		                </div>
		            </c:if>
		          </div>
	            <div class="col-md-3">
	                <img src="${pageContext.request.contextPath}/Imagenes/Taxi.png" alt="Logotipo de Taxi en la pantalla principal" width="400">
	            </div>
	        </div>
        </div>
</body>
</html>