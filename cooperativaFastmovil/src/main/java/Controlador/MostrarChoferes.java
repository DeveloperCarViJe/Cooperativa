package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ChoferesDao;
import modelo.Choferes;

/**
 * Servlet implementation class MostrarChoferes
 */
@WebServlet("/MostrarChoferes")
public class MostrarChoferes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChoferesDao choferesDao = new ChoferesDao();
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
		int idChofer = Integer.parseInt(request.getParameter("idChofer"));
	    List<Choferes> choferes = choferesDao.obtenerchoferesID(idChofer);
	    for (Choferes chofer : choferes) {
	       String movil = String.valueOf(chofer.getMovil()); // Suponiendo que tienes un método getMovil() en la clase Choferes
	       request.setAttribute("movil", movil);
	    }
	    request.setAttribute("choferes", choferes);
	    request.getRequestDispatcher("Formularios/DetalleChofer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
