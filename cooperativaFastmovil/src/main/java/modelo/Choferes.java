package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Choferes {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "choferes_seq")
    @SequenceGenerator(name = "choferes_seq", sequenceName = "choferes_seq", allocationSize = 1)
	private Integer id_chofer;
    private Integer movil;
    private String nombres;
    private String apellidos;
    private Integer edad;
    private String email;
    private String estado;
    private String telefono;
    private String direccion;
    private String modelo;
    private String color_vehiculo;
    private String numero_placa;
    private byte[] fotos_vehiculo;
    private Date Fecha_ingreso;
	private Date fecha_Salida;
	
	public Choferes() {
		
	}
	
	public Choferes(Integer movil, String nombres, String apellidos, Integer edad, String email, String estado, String telefono, String direccion, String modelo, String color_vehiculo, String numero_placa,byte[] fotos_vehiculo, Date fecha_ingreso, Date fecha_Salida) {
		this.movil = movil;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.email = email;
		this.estado = estado;
		this.telefono = telefono;
		this.direccion = direccion;
		this.modelo = modelo;
		this.color_vehiculo = color_vehiculo;
		this.numero_placa = numero_placa;
		this.fotos_vehiculo = fotos_vehiculo;
		this.Fecha_ingreso = fecha_ingreso;
		this.fecha_Salida = fecha_Salida;
	}
	
	public Choferes(Integer movil, String nombres, String apellidos, Integer edad, String email, String estado, String telefono, String direccion, String modelo, String color_vehiculo, String numero_placa,byte[] fotos_vehiculo) {
		this.movil = movil;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.email = email;
		this.estado = estado;
		this.telefono = telefono;
		this.direccion = direccion;
		this.modelo = modelo;
		this.color_vehiculo = color_vehiculo;
		this.numero_placa = numero_placa;
		this.fotos_vehiculo = fotos_vehiculo;
	}
	
	
	
	public Integer getId_chofer() {
		return id_chofer;
	}

	public void setId_chofer(Integer id_chofer) {
		this.id_chofer = id_chofer;
	}

	public Integer getMovil() {
		return movil;
	}
	public void setMovil(Integer movil) {
		this.movil = movil;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor_vehiculo() {
		return color_vehiculo;
	}
	public void setColor_vehiculo(String color_vehiculo) {
		this.color_vehiculo = color_vehiculo;
	}
	public String getNumero_placa() {
		return numero_placa;
	}
	public void setNumero_placa(String numero_placa) {
		this.numero_placa = numero_placa;
	}
	public byte[] getFotos_vehiculo() {
		return fotos_vehiculo;
	}
	public void setFotos_vehiculo(byte[] fotos_vehiculo) {
		this.fotos_vehiculo = fotos_vehiculo;
	}
	public Date getFecha_ingreso() {
		return Fecha_ingreso;
	}
	public void setFecha_ingreso(Date fecha_ingreso) {
		Fecha_ingreso = fecha_ingreso;
	}
	public Date getFecha_Salida() {
		return fecha_Salida;
	}
	public void setFecha_Salida(Date fecha_Salida) {
		this.fecha_Salida = fecha_Salida;
	}
	
}
