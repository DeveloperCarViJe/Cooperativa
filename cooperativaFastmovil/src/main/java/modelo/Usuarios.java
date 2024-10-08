package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuarios {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_seq")
    @SequenceGenerator(name = "usuarios_seq", sequenceName = "usuarios_seq", allocationSize = 1)
    private Integer id_User;
    private String nombres;
    private String apellidos;
    private Integer edad;
    private String usuario;
    private String password;
    private String email;
    private String estado;
    private String telefono;
    private String rol;
    private Date Fecha_ingreso;
	private Date fecha_Salida;

    public Usuarios() {
    }

    public Usuarios(String nombres, String apellidos, Integer edad, String usuario, String password, String email, String estado, String telefono, String rol, Date fecha_Salida) {
    	this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.estado = estado;
        this.telefono = telefono;
        this.rol = rol;
        this.fecha_Salida = fecha_Salida;
    }
    
    public Usuarios(Integer id_User, String nombres, String apellidos, String usuario, String password, String email, String telefono) {
    	this.id_User = id_User;
    	this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters y Setters

    public Integer getId_User() {
		return id_User;
	}

	public void setId_User(Integer id_User) {
		this.id_User = id_User;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Date getFecha_Salida() {
        return fecha_Salida;
    }

    public Date getFecha_ingreso() {
		return Fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		Fecha_ingreso = fecha_ingreso;
	}

    public void setFecha_Salida(Date fecha_Salida) {
        this.fecha_Salida = fecha_Salida;
    }
    
}

