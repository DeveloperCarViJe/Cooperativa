<div class="menu">
    <h2>MENU</h2>
    <a href="#" class="menu-item" onclick="toggleSubMenu('usuariosSubMenu')">USUARIOS  <i class="fas fa-users ml-2"></i></a>
    <div id="usuariosSubMenu" class="submenu" style="display: none;">
        <a href="${pageContext.request.contextPath}/Formularios/RegistroUsuarios.jsp">REGISTRAR <i class="fas fa-user-plus ml-2"></i></a>
        <a href="${pageContext.request.contextPath}/UsuariosController">MOSTRAR <i class="fas fa-list ml-2"></i></a>
    </div>
    <a href="#" class="menu-item" onclick="toggleSubMenu('choferesSubMenu')">CHOFERES  <i class="fas fa-user-tie ml-2"></i></a>
    <div id="choferesSubMenu" class="submenu" style="display: none;">
        <a href="${pageContext.request.contextPath}/Formularios/RegistroChoferes.jsp">REGISTRAR <i class="fas fa-user-plus ml-2"></i></a>
        <a href="${pageContext.request.contextPath}/ChoferesController">MOSTRAR <i class="fas fa-list ml-2"></i></a>
    </div>
    <a href="${pageContext.request.contextPath}/Formularios/RegistroDetalleDestino.jsp">DESTINOS <i class="fas fa-map-marker-alt ml-2"></i></a>
    <a href="contact.jsp">CARRERAS</a>
</div>