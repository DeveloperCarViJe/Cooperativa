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
	
});