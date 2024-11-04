/* Funcion para el sub menu */
function toggleSubMenu(subMenuId) {
    const subMenu = document.getElementById(subMenuId);
    if (subMenu.style.display === "none" || subMenu.style.display === "") {
        subMenu.style.display = "block";
    } else {
        subMenu.style.display = "none";
    }
}

document.addEventListener("DOMContentLoaded", function() {

		const tbody = document.querySelector('tbody.text-center');
	    if (tbody) {
	        tbody.addEventListener('click', function(event) {
	            if (event.target.closest('.editarValorDestino')) {
	                const idDestino = event.target.closest('.editarValorDestino').getAttribute("data-id");
	                editarFila(idDestino);
	            }
	        });
	    }
	
	const buscarDestinoElement = document.getElementById("buscarDestino");
	if (buscarDestinoElement) {
	    buscarDestinoElement.addEventListener("keydown", function(event) {
	        if (event.key === "Enter" && buscarDestinoElement.value.trim() !== "") {
	            const valorBuscado = event.target.value;
	            BuscarDestinos(valorBuscado);            
	        }
	    });
	}

	// Verifica si el elemento "valor" existe antes de agregar el evento
	const valorElement = document.getElementById("valor");
	if (valorElement) {
	    valorElement.addEventListener("input", function (e) {
	        this.value = this.value.replace(/,/g, '');
	    });
	}
	
	setTimeout(function() {
	    const alertElement = document.getElementById('alertRegistroDestino');
	    if (alertElement) {
	        alertElement.querySelector('.alert').classList.remove('show');
	        alertElement.querySelector('.alert').classList.add('fade');
	    }
	}, 3000);
	
});

function BuscarDestinos(valor) {
	const params = new URLSearchParams();
	params.append("accion", "Buscar");
	params.append("filtro", valor);
	
	fetch('/cooperativaFastmovil/DestinoCarreraController', {
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
			const tbody = document.querySelector('tbody.text-center'); // Selecciona el <tbody> donde quieres agregar las filas
			        tbody.innerHTML = ''; // Limpiar el contenido anterior (opcional)

			        data.forEach(destinoCarrera => {
			            // Crear una nueva fila para cada objeto de destinoCarrera
			            const row = document.createElement('tr');
			            row.id = `fila-${destinoCarrera.id}`; // Asegúrate de usar la propiedad correcta

			            // Agregar celdas a la fila
			            row.innerHTML = `
			                <td id="origen-${destinoCarrera.id}">${destinoCarrera.Origen}</td>
			                <td id="destino-${destinoCarrera.id}">${destinoCarrera.Destino}</td>
			                <td id="valor-${destinoCarrera.id}">${destinoCarrera.valor}</td>
			                <td style="text-align: center; ">
			                    <a href="#" class="editarValorDestino" data-id="${destinoCarrera.id}" title="Editar Valor">
			                        <i class="fas fa-edit fa-2x" style="margin-right: 10px; color: #5F9EA0;"></i>
			                    </a>
			                </td>
			            `;
			            tbody.appendChild(row); // Agregar la fila al <tbody>
			});
	    })
	    .catch(error => {
	        alert("Error: " + error.message);  // Mostrar el error en un alert
	        console.error('Error:', error);
	    });
}

function editarFila(idDestino) {
    // Convertir las celdas a campos de texto
    document.getElementById("valor-" + idDestino).innerHTML = `<input type="text" value="` + document.getElementById("valor-" + idDestino).innerText + `" />`;
    // Cambiar el botón a "Guardar"
    document.querySelector("#fila-" + idDestino + " td:last-child").innerHTML = `<button class="btn btn-success" style="background-color: #5F9EA0; border-color: #5F9EA0;" onclick="ActualizarValor(` + idDestino + `)">ACTUALIZAR</button>`;
}

function ActualizarValor(idDestino){
	const valor = document.querySelector(`#valor-${idDestino} input`).value;
	const params = new URLSearchParams();
	params.append("accion", "Actualizar");
	params.append("idDestino", idDestino);
	params.append("valor", valor);
	
	fetch('/cooperativaFastmovil/DestinoCarreraController', {
	    method: 'POST',
	    headers: {
	        'Content-Type': 'application/x-www-form-urlencoded',
	    },
	    body: params.toString()
	})
	.then(data => {
		const celdaValor = document.getElementById(`valor-${idDestino}`);
		            celdaValor.innerHTML = `<td id="valor-${idDestino}">${valor}</td>`;

		            // Cambiar el ícono de guardar a edición
		            const celdaBoton = document.querySelector(`#fila-${idDestino} td:last-child`);
		            celdaBoton.innerHTML = `
		                <a href="#" class="editarValorDestino" onclick="editarFila(${idDestino})" title="Editar Valor">
		                    <i class="fas fa-edit fa-2x" style="margin-right: 10px; color: #5F9EA0;"></i>
		                </a>
		            `;
	})
	.catch(error => {
	    alert("Error: " + error.message);  // Mostrar el error en un alert
	    console.error('Error:', error);
	});
}
