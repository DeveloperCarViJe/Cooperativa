package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class DestinoCarrera {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "destinoCarrera_seq")
    @SequenceGenerator(name = "destinoCarrera_seq", sequenceName = "destinoCarrera_seq", allocationSize = 1)
	private Integer id;
	private String Origen;
	private String Destino;
	private float valor;
	
	public DestinoCarrera(){
		
	}
	public DestinoCarrera(String origen, String destino, float valor) {
		this.Origen = origen;
		this.Destino = destino;
		this.valor = valor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrigen() {
		return Origen;
	}
	public void setOrigen(String origen) {
		Origen = origen;
	}
	public String getDestino() {
		return Destino;
	}
	public void setDestino(String destino) {
		Destino = destino;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
}
