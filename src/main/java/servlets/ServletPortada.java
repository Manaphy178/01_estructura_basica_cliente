package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.*;
import daosImpl.*;
import modelo.*;

/**
 * este @WebServlet es crucial: indica la ruta por la que el servlet sera
 * ejecutado
 */

@WebServlet("/ServletPortada")
public class ServletPortada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPortada() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Se ejecuta el metodo doget del servlet, "
				+ "aqui veremos como acceder a BD y obtener los productos " + "que mostrar en portada");
		/**
		 * necesitamos obtener los productos para darselo a la portada y que la portada
		 * los liste
		 */
		SombrerosDAO sombrerosDAO = new SombrerosDAOImpl();

		/**
		 * Desde el servlet que es parte de control, no accedo directamente a base de
		 * datos, eso lo hara la parte de modelo, en ese caso a traves de un DAO
		 */
		ArrayList<Sombrero> sombreros = sombrerosDAO.obtenerSombrero();

		/**
		 * Yo quiero que estos sombreros le lleguen a portada.jsp para ello son
		 * necesarias dos cosas:
		 */

		request.setAttribute("info_listado", sombreros);

		/**
		 * de esta forma a portada.jsp le llegara por este objeto request, que se
		 * mantiene a lo largo de toda la operacion la informacion de los sombreros con
		 * el nombre info_listado
		 */

		// sendRedirect redirecciona al usuario a una nueva ruta
		// response.sendRedirect("portada.jsp");

		/**
		 * Para mantener la informacion en el request, y dar al usuario como respuesta
		 * una jsp:
		 */
		RequestDispatcher rd = request.getRequestDispatcher("portada.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
