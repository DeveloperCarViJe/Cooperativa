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
<div class="col-sm-12 ml-auto mt-2">
	<jsp:include page="/Menu.jsp" />
	<div class="contentregistro">
        <h2>MOSTRAR USUARIOS</h2>
        <table class="table">
            <thead>
                <tr class="text-center">
                    <th>NOMBRES</th>
                    <th>APELLIDOS</th>
                    <th>USUARIO</th>
                    <th>EMAIL</th>
                    <th>TELEFONO</th>
                    <th>ROL</th>
                    <th>ACCION</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="usuario" items="${usuarios}">
                    <tr class="text-center">
                        <td>${usuario.nombres}</td>
                        <td>${usuario.apellidos}</td>
                        <td>${usuario.usuario}</td>
                        <td>${usuario.email}</td>
                        <td>${usuario.telefono}</td>
                        <td>${usuario.rol}</td>
                        <td>
                            <a href="editarUsuario.jsp?id=${usuario.id_User}" class="btn btn-secondary">EDITAR</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
   </div>
</body>
</html>