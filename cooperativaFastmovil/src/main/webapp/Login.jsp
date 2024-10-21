<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COOPERATIVA FASTMOVIL</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Login.css">
<script src="${pageContext.request.contextPath}/js/Formato.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
<div class="content">
	<div class="imagenLogin">
		<img src="${pageContext.request.contextPath}/Imagenes/login.jpg" alt="Logotipo de Taxi en la pantalla principal" width="100%">
	</div>
</div>
<div class="login">
  	<div class="h2-login">
		<h2><i class="fas fa-user fa-4x"></i></h2>
	</div>
	<form id="formLogin" action="/cooperativaFastmovil/UsuariosController" method="post">
    	<div class="form-section">
        	<div class="form-group row">
            	<label for="usuario" class="col-sm-12 col-form-label text-left">USUARIO</label>
	            <div class="col-sm-8">
	                <input type="text" class="form-control" id="usuario" name="usuario" maxlength="200" required>
	            </div>
        	</div>
        	<div class="form-group row">
            	<label for="password" class="col-sm-12 col-form-label text-left">CONTRASEÑA</label>
            	<div class="col-sm-8">
                	<input type="password" class="form-control" id="password" name="password" maxlength="200" required>
            	</div>
        	</div>
        	<div class="form-group row mt-4">
	            <div class="col-sm-12 text-center">
	                <button type="submit" class="btn btn-secondary btn-lg px-4 py-2" name="accion" value="Ingresar">INICIAR SESION</button>
	            </div>
        	</div>
     	</div>
     </form>
     <div class="form-group row mt-5 text-center">
     	<div class="col-sm-12">
        	<p class="firma-texto">© 2024 JC DEVELOPER. Todos los derechos reservados.</p>
        </div>
     </div>
</div> 
</body>
</html>