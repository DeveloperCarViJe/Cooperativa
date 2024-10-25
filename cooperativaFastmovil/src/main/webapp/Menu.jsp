<div class="menu">
    <h2>MENU</h2>
    <!-- Mostrar opciones para administradores -->
    <% String rol = (String) session.getAttribute("rol"); %>
    <% if ("ADMINISTRADOR".equals(rol)) { %>
    <a href="#" class="menu-item" onclick="toggleSubMenu('usuariosSubMenu')">USUARIOS  <i class="fas fa-users ml-2"></i></a>
    <div id="usuariosSubMenu" class="submenu" style="display: none;">
        <a href="${pageContext.request.contextPath}/Formularios/RegistroUsuarios.jsp">REGISTRAR <i class="fas fa-user-plus ml-2"></i></a>
        <a href="${pageContext.request.contextPath}/UsuariosController">MOSTRAR <i class="fas fa-list ml-2"></i></a>
    </div>
    <% } %>
    <a href="#" class="menu-item" onclick="toggleSubMenu('choferesSubMenu')">CHOFERES  <i class="fas fa-user-tie ml-2"></i></a>
    <div id="choferesSubMenu" class="submenu" style="display: none;">
        <a href="${pageContext.request.contextPath}/Formularios/RegistroChoferes.jsp">REGISTRAR <i class="fas fa-user-plus ml-2"></i></a>
        <a href="${pageContext.request.contextPath}/ChoferesController">MOSTRAR <i class="fas fa-list ml-2"></i></a>
    </div>
    
    <a href="${pageContext.request.contextPath}/Formularios/DetalleDestino.jsp">DESTINOS <i class="fas fa-map-marker-alt ml-2"></i></a>
    <a href="contact.jsp">CARRERAS</a>
    <a href="${pageContext.request.contextPath}/CerrarSesion" class="menu-item" class="btn btn-outline-danger">
    	<i class="fas fa-sign-out-alt"></i> Cerrar Sesión
	</a>
    	<div class="firma-texto">
        	© 2024 JC DEVELOPER. Todos los derechos reservados.
        </div>
</div>
<style>
    .btn-outline-danger {
        border: none; /* Elimina el borde */
        color: red;   /* Ajusta el color del texto si es necesario */
        background-color: transparent; /* Mantén el fondo transparente si es el estilo deseado */
    }

    .btn-outline-danger:hover {
        background-color: red; /* Puedes agregar un color de fondo al pasar el mouse */
        color: white; /* Cambia el color del texto al hacer hover si lo prefieres */
    }
    
    .firma-texto {
	    position: absolute; /* Posiciona el texto absolutamente dentro del contenedor */
	    bottom: 0; /* Coloca el texto en la parte inferior */
	    font-family: 'Roboto', sans-serif;
	    font-size: 12px;
	    color: #777;
	    text-align: center;
	}
</style>