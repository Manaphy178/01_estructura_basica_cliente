package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.SombrerosDAO;
import daosImpl.SombrerosDAOImpl;
import modelo.Sombrero;

/**
 * Servlet implementation class servletRegistroSombrero
 */
@WebServlet("/ServletRegistroSombrero")
public class ServletRegistroSombrero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegistroSombrero() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("registrar un libro con la informacion recibida");
		/**
		 * Lo que hay que hacer aqui es: recoger la informaicon -> formar un objeto de
		 * sombrero validar la informacion recibida (mas adelante) registrar la
		 * informacion en base de datos
		 */
		Sombrero s = new Sombrero();
		s.setNombre(request.getParameter("nombre")); // Indicar el name del input
		s.setPrecio(Double.parseDouble(request.getParameter("precio")));
		s.setDesc(request.getParameter("description"));
		SombrerosDAO sombrerosDAO = new SombrerosDAOImpl();
		sombrerosDAO.registrarSombrero(s);
//		una vez realizado el registro, mostramos el listado
		response.sendRedirect("ServletPortada");
		/**
		 * al redirijir a ServletPortada, ServletPortada pedira por un DAO los productor
		 * para darselos a portada.jsp y asi vemos si aparece el nuevo libro registrado
		 */
	}

}
