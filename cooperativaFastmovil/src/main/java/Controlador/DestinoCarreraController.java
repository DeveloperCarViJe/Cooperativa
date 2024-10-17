package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DestinoCarreraDao;
import modelo.Choferes;
import modelo.DestinoCarrera;

/**
 * Servlet implementation class DestinoCarreraController
 */
@WebServlet("/DestinoCarreraController")
public class DestinoCarreraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DestinoCarreraDao dao = new DestinoCarreraDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestinoCarreraController() {
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
		String origen= request.getParameter("origen");
		String destino= request.getParameter("destino");
		float valor= Float.parseFloat(request.getParameter("valor"));
		
        switch (accion) {        
        case "Registrar":
        	DestinoCarrera destinoC = new DestinoCarrera(origen,destino,valor);
            boolean registroExitosoFalse = dao.insertarDestinoCarrera(destinoC);
            request.setAttribute("registroExitosoFalse", registroExitosoFalse);
            request.getRequestDispatcher("Formularios/RegistroDetalleDestino.jsp").forward(request, response);
            break;    
        default:
            throw new AssertionError();
    }
	}

}
