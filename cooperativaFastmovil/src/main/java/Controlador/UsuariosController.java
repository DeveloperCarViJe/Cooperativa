package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsuariosDao;
import DAO.UsuariosDao2;
import modelo.Usuarios;

/**
 * Servlet implementation class UsuariosController
 */
@WebServlet("/UsuariosController")
public class UsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UsuariosDao dao= new UsuariosDao();
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		
		String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String estado = "A";
        String telefono = request.getParameter("telefono");
        
        Usuarios usuarios = new Usuarios(nombres,apellidos,edad,usuario,password,email,estado,telefono,null);
        switch (accion) {        
            case "Registrar":
                boolean registroExitosoFalse = dao.insertarUsuario(usuarios);
                request.setAttribute("registroExitosoFalse", registroExitosoFalse);
                request.getRequestDispatcher("FormUsuarios/RegistroUsuarios.jsp").forward(request, response);
                break;
  
            default:
                throw new AssertionError();
        }
    }

}
