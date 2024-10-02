function toggleSubMenu(subMenuId) {
    const subMenu = document.getElementById(subMenuId);
    if (subMenu.style.display === "none" || subMenu.style.display === "") {
        subMenu.style.display = "block";
    } else {
        subMenu.style.display = "none";
    }
}

document.addEventListener("DOMContentLoaded", function() {
    const botonesEditarUsuarios = document.querySelectorAll(".editarBtnUsuarios");
	const botonesEliminarUsuarios = document.querySelectorAll(".eliminarBtnUsuarios");
    botonesEditarUsuarios.forEach(button => {
        button.addEventListener("click", function() {
            const idUsuario = this.getAttribute("data-id");
            editarFila(idUsuario);
        });
    });
	botonesEliminarUsuarios.forEach(button => {
	        button.addEventListener("click", function() {
	            const idUsuario = this.getAttribute("data-id");
				if (confirm("¿Estás seguro de que deseas eliminar este usuario?")) {
				           EliminarUsuarios(idUsuario);
				   }
	        });
	});
});

function editarFila(idUsuario) {
    // Convertir las celdas a campos de texto
    document.getElementById("nombres-" + idUsuario).innerHTML = `<input type="text" value="` + document.getElementById("nombres-" + idUsuario).innerText + `" />`;
    document.getElementById("apellidos-" + idUsuario).innerHTML = `<input type="text" value="` + document.getElementById("apellidos-" + idUsuario).innerText + `" />`;
    document.getElementById("usuario-" + idUsuario).innerHTML = `<input type="text" value="` + document.getElementById("usuario-" + idUsuario).innerText + `" />`;
    document.getElementById("password-" + idUsuario).innerHTML = `<input type="password" value="` + document.getElementById("password-" + idUsuario).innerText + `" />`;
    document.getElementById("email-" + idUsuario).innerHTML = `<input type="email" value="` + document.getElementById("email-" + idUsuario).innerText + `" />`;
    document.getElementById("telefono-" + idUsuario).innerHTML = `<input type="text" value="` + document.getElementById("telefono-" + idUsuario).innerText + `" />`;
    document.getElementById("rol-" + idUsuario).innerHTML = `<input type="text" value="` + document.getElementById("rol-" + idUsuario).innerText + `" disabled />`;

    // Cambiar el botón a "Guardar"
    document.querySelector("#fila-" + idUsuario + " td:last-child").innerHTML = `<button class="btn btn-success" style="background-color: #5F9EA0; border-color: #5F9EA0;" onclick="ActualizarUsuarios(` + idUsuario + `)">ACTUALIZAR</button>`;
}

function ActualizarUsuarios(idUsuario) {
    // Recoger los valores de los inputs
    const nombres = document.querySelector(`#nombres-${idUsuario} input`).value;
    const apellidos = document.querySelector(`#apellidos-${idUsuario} input`).value;
    const usuario = document.querySelector(`#usuario-${idUsuario} input`).value;
    const password = document.querySelector(`#password-${idUsuario} input`).value;
    const email = document.querySelector(`#email-${idUsuario} input`).value;
    const telefono = document.querySelector(`#telefono-${idUsuario} input`).value;
	
	const params = new URLSearchParams();
	params.append("accion", "Actualizar");
	params.append("idUsuario", idUsuario);
	params.append("nombres", nombres);
	params.append("apellidos", apellidos);
	params.append("usuario", usuario);
	params.append("password", password);
	params.append("email", email);
	params.append("telefono", telefono);
	
	fetch('/cooperativaFastmovil/UsuariosController', {
	    method: 'POST',
	    headers: {
	        'Content-Type': 'application/x-www-form-urlencoded',
	    },
	    body: params.toString()
	})
	.then(response => {
				    // Verifica si el contenido devuelto es JSON
				    if (!response.ok) {
				        throw new Error('Error en la respuesta del servidor.');
				    }
				    return response.json();  // Interpreta la respuesta como JSON
	})
	.then(data => {
		const ActualizarExitoFalse= data.accion;
		const accionMostrar="A";
				window.location.href = '/cooperativaFastmovil/UsuariosController?accionExitoFalse=' + ActualizarExitoFalse + '&accionMostrar=' + accionMostrar;
	})
	.catch(error => {
	    alert("Error: " + error.message);  // Mostrar el error en un alert
	    console.error('Error:', error);
	});
}

function EliminarUsuarios(idUsuario) {

	const params = new URLSearchParams();
	params.append("accion", "Eliminar");
	params.append("idUsuario", idUsuario);
	
	fetch('/cooperativaFastmovil/UsuariosController', {
	    method: 'POST',
	    headers: {
	        'Content-Type': 'application/x-www-form-urlencoded',
	    },
	    body: params.toString()
	})
	.then(response => {
					    // Verifica si el contenido devuelto es JSON
					    if (!response.ok) {
					        throw new Error('Error en la respuesta del servidor.');
					    }
					    return response.json();  // Interpreta la respuesta como JSON
	})
	.then(data => {
		const EliminarExitoFalse= data.accion;
		const accionMostrar="E";
		window.location.href = '/cooperativaFastmovil/UsuariosController?accionExitoFalse=' + EliminarExitoFalse + '&accionMostrar=' + accionMostrar;
	})
	.catch(error => {
	    alert("Error: " + error.message);  // Mostrar el error en un alert
	    console.error('Error:', error);
	});
}

setTimeout(function() {
           const alertElement = document.getElementById('alertRegistroUsuario');
           if (alertElement) {
               alertElement.querySelector('.alert').classList.remove('show');
               alertElement.querySelector('.alert').classList.add('fade');
           }
}, 3000);
