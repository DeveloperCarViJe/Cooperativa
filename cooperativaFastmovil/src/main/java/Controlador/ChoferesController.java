package Controlador;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.ChoferesDao;
import DAO.ImagenesChoferesDao;
import modelo.Choferes;
import modelo.ImagenesChoferes;

/**
 * Servlet implementation class ChoferesController
 */
@WebServlet("/ChoferesController")
@MultipartConfig
public class ChoferesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChoferesDao dao = new ChoferesDao();
	int edad=0;
	int movil=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChoferesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String alertEliminar = request.getParameter("eliminarExitoFalse");
        if (alertEliminar != null && !alertEliminar.isEmpty()) {
            try {
            	request.setAttribute("eliminacionExitosaFalse", alertEliminar);
            } catch (NumberFormatException e) {
            	request.setAttribute("eliminacionExitosaFalse", "false");
            }
        }
		ChoferesDao choferesDao = new ChoferesDao();
	    List<Choferes> choferes = choferesDao.obtenerTodosLosChoferes();
	    request.setAttribute("choferes", choferes);
	    request.getRequestDispatcher("Formularios/MostrarChoferes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		System.out.println("Acción recibida: " + accion);
		String movilParam = request.getParameter("movil");
        if (movilParam != null && !movilParam.isEmpty()) {
            try {
            	movil = Integer.parseInt(movilParam);
            } catch (NumberFormatException e) {
            	movil = 0;
            }
        }
		String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String edadParam = request.getParameter("edad");
        if (edadParam != null && !edadParam.isEmpty()) {
            try {
                edad = Integer.parseInt(edadParam);
            } catch (NumberFormatException e) {
                edad = 0;
            }
        }
        String email = request.getParameter("email");
        String estado = "A";
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String modelo = request.getParameter("modelo");
        String color = request.getParameter("color");
        String placa = request.getParameter("placa");
        byte[] imageBytes = null;
     // Obtiene la imagen desde el formulario
        InputStream inputStream = null;
        if ("Registrar".equals(accion)) {
            try {
			        Part filePart = request.getPart("file");
			        if (filePart != null) {
			            inputStream = filePart.getInputStream();
			            imageBytes = inputStream.readAllBytes();
			        }
            	} finally {
            		if (inputStream != null) {
            	        inputStream.close(); 
            	    }
            	}
        }
        //System.out.println(imageBytes);
        switch (accion) {        
            case "Registrar":
            	Choferes choferesR = new Choferes(movil,nombres,apellidos,edad,email,estado,telefono,direccion,modelo,color,placa/*,imageBytes*/);
                boolean registroExitosoFalse = dao.insertarChofer(choferesR);
                request.setAttribute("registroExitosoFalse", registroExitosoFalse);
                if (registroExitosoFalse) {
                    // Obtener el ID del chofer recién insertado
                    int choferId = choferesR.getId_chofer();
                    ImagenesChoferesDao daoImagenesChoferesDao = new ImagenesChoferesDao();
                    boolean imagenInsertada = daoImagenesChoferesDao.insertarImagen(choferId, imageBytes);
                    request.setAttribute("registroExitosoFalse", imagenInsertada);
                }
                request.setAttribute("mostrarAlerta", "true");
                request.getRequestDispatcher("Formularios/RegistroChoferes.jsp").forward(request, response);
                break;
           
            case "Actualizar":
            	/*int idUsuarioActualizar = Integer.parseInt(request.getParameter("idUsuario"));
            	Usuarios usuariosA = new Usuarios(idUsuarioActualizar,nombres,apellidos,usuario,password,email,telefono);
            	dao.actualizarUsuarios(usuariosA);*/
            	break;
            
            case "Eliminar":
            	int idChoferEliminar = Integer.parseInt(request.getParameter("idChofer"));
            	boolean EliminacionExitosoFalse = dao.desactivarChofer(idChoferEliminar);
            	response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String jsonResponseEliminar = "{\"eliminar\": " + EliminacionExitosoFalse + "}";
                response.getWriter().write(jsonResponseEliminar);
            	break;
            
            case "ValidarMovil":
            	System.out.println("ingreso validar movil");
                boolean movilExiste = dao.movilExistente(movil);
                
                // Construcción manual de JSON
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                
                // Envío de la respuesta como un objeto JSON con clave 'existe'
                String jsonResponseValidar = "{\"existe\": " + movilExiste + "}";
                response.getWriter().write(jsonResponseValidar);
                break;

                
            default:
                throw new AssertionError();
        }
	}

}
