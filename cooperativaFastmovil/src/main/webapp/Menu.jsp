<div class="menu">
    <h2>MENU</h2>
    <a href="#" class="menu-item" onclick="toggleSubMenu('usuariosSubMenu')">USUARIOS</a>
    <div id="usuariosSubMenu" class="submenu" style="display: none;">
        <a href="${pageContext.request.contextPath}/FormUsuarios/RegistroUsuarios.jsp">REGISTRAR</a>
        <a href="listar.jsp">MOSTRAR</a>
    </div>
    <a href="about.jsp">CHOFERES</a>
    <a href="services.jsp">DESTINOS</a>
    <a href="contact.jsp">CARRERAS</a>
</div>