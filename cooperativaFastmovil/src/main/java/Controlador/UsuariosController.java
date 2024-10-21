package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String mostrarMensaje="";
		String alertEliminarActualizar = request.getParameter("accionExitoFalse");
		String getaccionMostrar = request.getParameter("accionMostrar");
		if (alertEliminarActualizar != null && !alertEliminarActualizar.isEmpty()) {
            try {
            	if ("E".equals(getaccionMostrar)) {
            	    if ("true".equals(alertEliminarActualizar)) {
            	        mostrarMensaje = "Usuario Eliminado correctamente";
            	    } else {
            	        mostrarMensaje = "Error al eliminar el Usuario";
            	    }
            	} else {
            	    if ("true".equals(alertEliminarActualizar)) {
            	        mostrarMensaje = "Usuario Actualizado correctamente";
            	    } else {
            	        mostrarMensaje = "Error al actualizar el Usuario";
            	    }
            	}
            	request.setAttribute("mostrarMensaje", mostrarMensaje);
            	request.setAttribute("accionExitosaFalse", alertEliminarActualizar);
            } catch (NumberFormatException e) {
            	request.setAttribute("getaccionMostrar", mostrarMensaje);
            	request.setAttribute("accionExitosaFalse", "false");
            }
        }
		UsuariosDao usuariosDao = new UsuariosDao();
	    List<Usuarios> usuarios = usuariosDao.obtenerTodosLosUsuarios();
	    request.setAttribute("usuarios", usuarios);
	    request.getRequestDispatcher("Formularios/MostrarUsuarios.jsp").forward(request, response);
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
                request.getRequestDispatcher("Formularios/RegistroUsuarios.jsp").forward(request, response);
                break;
           
            case "Actualizar":
            	int idUsuarioActualizar = Integer.parseInt(request.getParameter("idUsuario"));
            	Usuarios usuariosA = new Usuarios(idUsuarioActualizar,nombres,apellidos,usuario,password,email,telefono);
            	boolean accionExitosaFalseA = dao.actualizarUsuarios(usuariosA);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String jsonResponseActualizar = "{\"accion\": " + accionExitosaFalseA + "}";
                response.getWriter().write(jsonResponseActualizar);
            	break;
            
            case "Eliminar":
            	int idUsuarioEliminar = Integer.parseInt(request.getParameter("idUsuario"));
            	boolean accionExitosaFalseE = dao.desactivarUsuario(idUsuarioEliminar);
            	
            	response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String jsonResponseEliminar = "{\"accion\": " + accionExitosaFalseE + "}";
                response.getWriter().write(jsonResponseEliminar);
            	break;
            
            case "Ingresar":
            	boolean UsuarioExiste = dao.UsuarioExistente(usuario, password);
            	HttpSession session = request.getSession();
                session.setAttribute("user", usuario); // Establecer el usuario en la sesión
                response.sendRedirect(request.getContextPath() + "/Home.jsp"); // Redirigir a Home.jsp
            	break;
                
            default:
                throw new AssertionError();
        }
    }

}
