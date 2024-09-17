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
    private Date fecha_Salida;

    // Constructor sin parámetros
    public Usuarios() {
    }

    // Constructor con todos los parámetros
    public Usuarios(String nombres, String apellidos, Integer edad, String usuario, String password, String email, String estado, String telefono, Date fecha_Salida) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.estado = estado;
        this.telefono = telefono;
        this.fecha_Salida = fecha_Salida;
    }

    // Getters y Setters

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

    public Date getFecha_Salida() {
        return fecha_Salida;
    }

    public void setFecha_Salida(Date fecha_Salida) {
        this.fecha_Salida = fecha_Salida;
    }
    
}

