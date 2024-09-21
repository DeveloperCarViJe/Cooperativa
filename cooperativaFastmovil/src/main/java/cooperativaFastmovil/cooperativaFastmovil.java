package cooperativaFastmovil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Conexion.Conexion;

public class cooperativaFastmovil {

	public static void main(String[] args) throws ParseException, SQLException {
		// TODO Auto-generated method stub
		Conexion c=new Conexion();
		Connection con;
		con = c.conectar();
		String sql = "SELECT usuarios_seq.NEXTVAL FROM dual";
    	PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) { // Mueve el cursor a la primera fila
            int nextId = rs.getInt(1);
            System.out.println(nextId);
        } else {
            System.out.println("No se encontró ningún valor en la secuencia.");
        }
	}

}
