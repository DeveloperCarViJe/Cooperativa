package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsuariosDao;
import modelo.Usuarios;

/**
 * Servlet implementation class UsuariosController
 */
@WebServlet("/UsuariosController")
public class UsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UsuariosDao dao= new UsuariosDao();
    int edad=0;
	//UsuariosDao2 dao= new UsuariosDao2();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuariosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsuariosDao usuariosDao = new UsuariosDao();
	    List<Usuarios> usuarios = usuariosDao.obtenerTodosLosUsuarios();
	    request.setAttribute("usuarios", usuarios);
	    request.getRequestDispatcher("FormUsuarios/MostrarUsuarios.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
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
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String estado = "A";
        String telefono = request.getParameter("telefono");
        String rol = request.getParameter("flexRadioRol");
        switch (accion) {        
            case "Registrar":
            	Usuarios usuariosR = new Usuarios(nombres,apellidos,edad,usuario,password,email,estado,telefono, rol, null);
                boolean registroExitosoFalse = dao.insertarUsuario(usuariosR);
                request.setAttribute("registroExitosoFalse", registroExitosoFalse);
                request.getRequestDispatcher("FormUsuarios/RegistroUsuarios.jsp").forward(request, response);
                break;
           
            case "Actualizar":
            	int idUsuarioActualizar = Integer.parseInt(request.getParameter("idUsuario"));
            	Usuarios usuariosA = new Usuarios(idUsuarioActualizar,nombres,apellidos,usuario,password,email,telefono);
            	dao.actualizarUsuarios(usuariosA);
            	break;
            
            case "Eliminar":
            	int idUsuarioEliminar = Integer.parseInt(request.getParameter("idUsuario"));
            	dao.desactivarUsuario(idUsuarioEliminar);
            	break;
                
            default:
                throw new AssertionError();
        }
    }

}
