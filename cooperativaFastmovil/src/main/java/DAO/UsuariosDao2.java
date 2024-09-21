package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Conexion.Conexion;
import modelo.Usuarios;


public class UsuariosDao2 {

	PreparedStatement ps;
	ResultSet rs;
	Conexion c=new Conexion();
	Connection con;
	
    public boolean insertarUsuario(Usuarios usuarios) {
    	String sql = "insert into USUARIOS(ID_USER,NOMBRES, APELLIDOS, EDAD, USUARIO, PASSWORD, EMAIL, ESTADO, TELEFONO," +
    			     "FECHA_INGRESO, FECHA_SALIDA) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	    try {
	        con = c.conectar();
	        ps = con.prepareStatement(sql);
	        ps.setInt(1, ObtenerSecuenciaRegistroUsuario());
	        ps.setString(2, usuarios.getNombres());
	        ps.setString(3, usuarios.getApellidos());
	        ps.setInt(4, usuarios.getEdad());
	        ps.setString(5, usuarios.getUsuario());
	        ps.setString(6, usuarios.getPassword());
	        ps.setString(7, usuarios.getEmail());
	        ps.setString(8, usuarios.getEstado());
	        ps.setString(9, usuarios.getTelefono());
	        ps.setDate(10, new java.sql.Date(new Date().getTime()));
	        ps.setDate(11, null);
	        ps.executeUpdate();
	        System.out.println("Data inserted successfully.");
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
    }
    
    public Integer ObtenerSecuenciaRegistroUsuario() throws SQLException {
		con = c.conectar();
		String sql = "SELECT usuarios_seq.NEXTVAL FROM dual";
    	PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs;
        Integer nextId=0;
		try {
			rs = ps.executeQuery();
			if (rs.next()) {
	            nextId = rs.getInt(1);
	        } else {
	            System.out.println("No se encontró ningún valor en la secuencia.");
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        try {
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
		return nextId;
    }
}
