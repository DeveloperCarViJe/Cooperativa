package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ImagenesChoferes {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "choferesImagen_seq")
    @SequenceGenerator(name = "choferesImagen_seq", sequenceName = "choferesImagen_seq", allocationSize = 1)
	private int id;
	
	@ManyToOne // Indica que hay una relación muchos a uno con Choferes
	@JoinColumn(name = "id_chofer", nullable = false) // Define la columna de referencia
	private Choferes chofer_id;
	
	private byte[] imagen;
	
	// Constructor por defecto
    public ImagenesChoferes() {}

    // Constructor con parámetros
    public ImagenesChoferes(Choferes chofer_id, byte[] imagen) {
        this.chofer_id = chofer_id;
        this.imagen = imagen;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Choferes getChofer_id() {
		return chofer_id;
	}

	public void setChofer_id(Choferes chofer_id) {
		this.chofer_id = chofer_id;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
}
