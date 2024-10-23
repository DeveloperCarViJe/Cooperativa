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

	setTimeout(function() {
	    const alertElement = document.getElementById('alertRegistroDestino');
	    if (alertElement) {
	        alertElement.querySelector('.alert').classList.remove('show');
	        alertElement.querySelector('.alert').classList.add('fade');
	    }
	}, 3000);
	
	document.getElementById("buscarDestino").addEventListener("keydown", function(event) {
	    // Verificar si la tecla presionada es Enter (código de tecla 13)
	    if (event.key === "Enter") {
			const valorBuscado = event.target.value;
			BuscarDestinos(valorBuscado);            
	    }
	});
	
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
			                    <a href="#" class="editarOrigenDestino" data-id="${destinoCarrera.id}" title="Editar">
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
