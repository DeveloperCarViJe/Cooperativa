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
<script src="${pageContext.request.contextPath}/js/Choferes.js"></script>
</head>
<body>
	<jsp:include page="/Menu.jsp" />
	<div class="contentregistro">
        <div class="form-group row d-flex justify-content-center align-items-center position-relative">
			    <div class="col-sm-8 text-center">
			        <h2 class="m-0">MOSTRAR CHOFERES</h2>
			    </div>
			    <div class="position-absolute" style="top: -10px; right: 10px;">
				   <c:if test="${not empty eliminacionExitosaFalse}">
				            <div id="alertRegistroChofer">
				                <div class="alert alert-success alert-dismissible fade show" role="alert">
				                    <strong></strong> 
				                    <c:choose>
				                        <c:when test="${eliminacionExitosaFalse == 'true'}">
				                            Se ha eliminado existosamente el Movil
				                        </c:when>
				                        <c:otherwise>
				                            Error al al eliminar el Movil.
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
                	<th>MOVIL</th>
                    <th>NOMBRES</th>
                    <th>APELLIDOS</th>
                    <th>TELEFONO</th>
                    <th>MODELO VEHICULO</th>
                    <th>COLOR VEHICULO</th>
                    <th>NUMERO PLACA</th>
                    <th>ACCION</th>
                </tr>
            </thead>
            <tbody class="text-center">
                <c:forEach var="chofer" items="${choferes}">
                    <tr id="fila-${chofer.id_chofer}">
                    	<td id="movil-${chofer.id_chofer}">${chofer.movil}</td>
                        <td id="nombres-${chofer.id_chofer}">${chofer.nombres}</td>
		                <td id="apellidos-${chofer.id_chofer}">${chofer.apellidos}</td>
		                <td id="telefono-${chofer.id_chofer}">${chofer.telefono}</td>
		                <td id="modelo-${chofer.id_chofer}">${chofer.modelo}</td>
		                <td id="color-${chofer.id_chofer}">${chofer.color_vehiculo}</td>
		                <td id="placa-${chofer.id_chofer}">${chofer.numero_placa}</td>
		                <td style="text-align: center;">
							<a href="#" class="mostrarBtnChoferes" data-id="${chofer.id_chofer}" title="Editar">
							    <i class="fas fa-user-circle fa-2x" style="margin-right: 10px; color: #5F9EA0;"></i>
							</a>
							<a href="#" class="eliminarBtnChoferes" data-id="${chofer.id_chofer}" title="Eliminar">
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