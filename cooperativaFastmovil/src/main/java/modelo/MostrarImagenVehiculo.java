package modelo;

public class MostrarImagenVehiculo {

	private String imagen;
	private String tipo_imagen;
	
	public MostrarImagenVehiculo(String imagen, String tipo_imagen) {
		this.imagen = imagen;
		this.tipo_imagen = tipo_imagen;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTipo_imagen() {
		return tipo_imagen;
	}

	public void setTipo_imagen(String tipo_imagen) {
		this.tipo_imagen = tipo_imagen;
	}
	
}
