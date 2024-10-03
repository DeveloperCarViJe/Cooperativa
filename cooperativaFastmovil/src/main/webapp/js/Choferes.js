function toggleSubMenu(subMenuId) {
    const subMenu = document.getElementById(subMenuId);
    if (subMenu.style.display === "none" || subMenu.style.display === "") {
        subMenu.style.display = "block";
    } else {
        subMenu.style.display = "none";
    }
}

document.addEventListener("DOMContentLoaded", function() {
    // Manejo de eliminación de choferes
    const botonesEliminarChoferes = document.querySelectorAll(".eliminarBtnChoferes");
    botonesEliminarChoferes.forEach(button => {
        button.addEventListener("click", function() {
            const idChofer = this.getAttribute("data-id");
            if (confirm("¿Estás seguro de que deseas eliminar este Movil?")) {
                EliminarChoferes(idChofer);
            }
        });
    });

    // Evento para validar el movil existente
    const registrarChoferBtn = document.getElementById('registrarChoferBtn');
    if (registrarChoferBtn) {
		console.log("Botón 'Registrar Chofer' encontrado"); 
        registrarChoferBtn.addEventListener('click', function(event) {
            event.preventDefault();
			console.log("Evento click del botón registrado");
			const movil = document.getElementById('movil').value;
			console.log("Móvil ingresado:", movil);
			const params = new URLSearchParams();
			    params.append("accion", "ValidarMovil");
			    params.append("movil", movil);

            fetch('/cooperativaFastmovil/ChoferesController', {
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
                if (data.existe) {
					const alertContainer = document.getElementById('alertRegistroChofer');
					       if (alertContainer) {
							   alertContainer.style.display = 'block';
					           alertContainer.innerHTML = `
					               <div class="alert alert-danger alert-dismissible fade show" role="alert">
					                   <strong>Error: </strong> El número de móvil ya está registrado.
					               </div>`;
					       }
						   setTimeout(function() {
						                           if (alertContainer) {
						                               alertContainer.querySelector('.alert').classList.remove('show');
						                               alertContainer.querySelector('.alert').classList.add('fade');
						                               // Ocultar el contenedor de alerta después de que se desvaneció
						                               setTimeout(function() {
						                                   alertContainer.style.display = 'none';
						                                   alertContainer.innerHTML = ''; // Limpiar el contenido
						                               }, 500); // Tiempo para la animación de desvanecimiento
						                           }
						                       }, 3000);
                } else {
                    document.getElementById('formRegistroChoferes').submit();
                }
            })
            .catch(error => {
                alert('Error al registrar el movil.');
            });
        });
    }

    // Ocultar la alerta de éxito/error automáticamente
    setTimeout(function() {
        const alertElement = document.getElementById('alertRegistroChofer');
        if (alertElement) {
            alertElement.querySelector('.alert').classList.remove('show');
            alertElement.querySelector('.alert').classList.add('fade');
        }
    }, 3000);
});

function EliminarChoferes(idChofer) {
    const params = new URLSearchParams();
    params.append("accion", "Eliminar");
    params.append("idChofer", idChofer);

    fetch('/cooperativaFastmovil/ChoferesController', {
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
			const EliminarExitoFalse= data.eliminar;
			window.location.href = '/cooperativaFastmovil/ChoferesController?eliminarExitoFalse=' + EliminarExitoFalse;  
    })
    .catch(error => {
        alert("Error: " + error.message);  // Mostrar el error en un alert
        console.error('Error:', error);
    });
}

function updateFileName() {
        const fileInput = document.getElementById('file');
        const fileLabel = document.querySelector('.custom-file-label');
        
        if (fileInput.files.length > 0) {
            fileLabel.textContent = fileInput.files[0].name;  // Actualiza el texto con el nombre del archivo
        }
    }
