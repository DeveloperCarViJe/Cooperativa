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
			        <h2 class="m-0">MOSTRAR USUARIOS</h2>
			    </div>
			    <div class="position-absolute" style="top: -10px; right: 10px;">
				   <c:if test="${not empty accionExitosaFalse}">
				            <div id="alertRegistroUsuario">
				                <div class="alert alert-success alert-dismissible fade show" role="alert">
				                    <strong></strong> 
				                    <c:choose>
				                        <c:when test="${accionExitosaFalse == 'true'}">
				                            ${mostrarMensaje}
				                        </c:when>
				                        <c:otherwise>
				                            ${mostrarMensaje}
				                        </c:otherwise>
				                    </c:choose>
				                </div>
				            </div>
				    </c:if>
				</div>
		</div>
        <table class="table">
            <thead>
                <tr class="text-center">
                    <th>NOMBRES</th>
                    <th>APELLIDOS</th>
                    <th>USUARIO</th>
                    <th>PASSWORD</th>
                    <th>EMAIL</th>
                    <th>TELEFONO</th>
                    <th>ROL</th>
                    <th>ACCION</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach var="usuario" items="${usuarios}">
                    <tr id="fila-${usuario.id_User}">
                        <td id="nombres-${usuario.id_User}">${usuario.nombres}</td>
		                <td id="apellidos-${usuario.id_User}">${usuario.apellidos}</td>
		                <td id="usuario-${usuario.id_User}">${usuario.usuario}</td>
		                <td id="password-${usuario.id_User}">${usuario.password}</td>
		                <td id="email-${usuario.id_User}">${usuario.email}</td>
		                <td id="telefono-${usuario.id_User}">${usuario.telefono}</td>
		                <td id="rol-${usuario.id_User}">${usuario.rol}</td>
		                <td style="text-align: center;">
							<a href="#" class="editarBtnUsuarios" data-id="${usuario.id_User}" title="Editar">
							    <i class="fas fa-edit fa-2x" style="margin-right: 10px; color: #5F9EA0;"></i>
							</a>
							<a href="#" class="eliminarBtnUsuarios" data-id="${usuario.id_User}" title="Eliminar">
							    <i class="fas fa-trash-alt fa-2x" style="color: #A52A2A;"></i>
							</a>
		                </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>