function toggleSubMenu(subMenuId) {
    const subMenu = document.getElementById(subMenuId);
    if (subMenu.style.display === "none" || subMenu.style.display === "") {
        subMenu.style.display = "block";
    } else {
        subMenu.style.display = "none";
    }
}

document.addEventListener("DOMContentLoaded", function() {
	const botonesEliminarChoferes = document.querySelectorAll(".eliminarBtnChoferes");
	botonesEliminarChoferes.forEach(button => {
	        button.addEventListener("click", function() {
	            const idChofer = this.getAttribute("data-id");
				if (confirm("¿Estás seguro de que deseas eliminar este Movil?")) {
				           EliminarChoferes(idChofer);
				   }
	        });
	});
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
	    if (!response.ok) {
	        console.error('Respuesta del servidor:', response.status, response.statusText);
	        return response.text().then(text => {
	            throw new Error(text || 'Error en la respuesta del servidor.');
	        });
	    }
	    return response.text();
	})
	.then(data => {
	    window.location.href = '/cooperativaFastmovil/ChoferesController';
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