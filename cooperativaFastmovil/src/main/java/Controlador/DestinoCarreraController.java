package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
		
        switch (accion) {        
        case "Registrar":
        	String origen= request.getParameter("origen");
    		String destino= request.getParameter("destino");
    		float valor= Float.parseFloat(request.getParameter("valor"));
        	DestinoCarrera destinoC = new DestinoCarrera(origen,destino,valor);
            boolean registroExitosoFalse = dao.insertarDestinoCarrera(destinoC);
            request.setAttribute("registroExitosoFalse", registroExitosoFalse);
            request.getRequestDispatcher("Formularios/RegistroDetalleDestino.jsp").forward(request, response);
            break;    
        
        case "Buscar":
        	String filtro = request.getParameter("filtro");
        	System.out.println("ingreso a buscar");
        	List<DestinoCarrera> destinoCarreras = dao.obtenerDestinoCarreraFiltro(filtro);
        	response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            
            String json = new Gson().toJson(destinoCarreras);
            response.getWriter().write(json);
            break;
            
        default:
            throw new AssertionError();
    }
	}

}
