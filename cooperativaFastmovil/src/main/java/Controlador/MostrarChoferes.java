package Controlador;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ChoferesDao;
import DAO.ImagenesChoferesDao;
import modelo.Choferes;
import modelo.ImagenData;
import modelo.ImagenesChoferes;
import modelo.MostrarImagenVehiculo;

/**
 * Servlet implementation class MostrarChoferes
 */
@WebServlet("/MostrarChoferes")
public class MostrarChoferes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChoferesDao choferesDao = new ChoferesDao();
	ImagenesChoferesDao imagenesChoferesDao =  new ImagenesChoferesDao();
	String movil =null;
	String fechaFormateada = null;
	byte[] imagenBytesPerfil;
	String imagenPerfil=null;
	String tipoImagen=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarChoferes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Obtener los datos del chofer por el ID
		List<MostrarImagenVehiculo> mostrarImagenV = new ArrayList<>();
		int idChofer = Integer.parseInt(request.getParameter("idChofer"));
		List<Choferes> choferes = choferesDao.obtenerchoferesID(idChofer);
	    for (Choferes chofer : choferes) {
	       movil = String.valueOf(chofer.getMovil());
	       Date fechaI = chofer.getFecha_ingreso();
	       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	       fechaFormateada = formato.format(fechaI);
	    }
	    //Obtener los datos de las imagenes
	    List<ImagenesChoferes> imagenesChoferes = imagenesChoferesDao.obtenerImagenesID(idChofer);
	    for (ImagenesChoferes imagenChofer : imagenesChoferes) {
	    	if("P".equals(imagenChofer.getTipo())) {
	    		imagenBytesPerfil = imagenChofer.getImagen();
	    	    imagenPerfil = Base64.getEncoder().encodeToString(imagenBytesPerfil);
	    	 // Determina el tipo de imagen
	    	    ByteArrayInputStream tipoImagenBinario = new ByteArrayInputStream(imagenBytesPerfil);
	    	    tipoImagen = URLConnection.guessContentTypeFromStream(tipoImagenBinario);
	    	}else {
	    		imagenBytesPerfil = imagenChofer.getImagen();
	    	    imagenPerfil = Base64.getEncoder().encodeToString(imagenBytesPerfil);
	    	 // Determina el tipo de imagen
	    	    ByteArrayInputStream tipoImagenBinario = new ByteArrayInputStream(imagenBytesPerfil);
	    	    tipoImagen = URLConnection.guessContentTypeFromStream(tipoImagenBinario);
	    	    mostrarImagenV.add(new MostrarImagenVehiculo(imagenPerfil,tipoImagen));
	    	}
	    }
	    System.out.println(movil + fechaFormateada);
	    request.setAttribute("movil", movil);
	    request.setAttribute("fechaFormateada", fechaFormateada);
	    request.setAttribute("imagenPerfil", imagenPerfil);
	    request.setAttribute("tipoImagen", tipoImagen);
	    request.setAttribute("choferes", choferes);
	    request.setAttribute("mostrarImagenV", mostrarImagenV);
	    request.getRequestDispatcher("Formularios/DetalleChofer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
