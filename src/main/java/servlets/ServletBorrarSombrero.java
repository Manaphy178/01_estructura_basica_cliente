package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.SombrerosDAO;
import daosImpl.SombrerosDAOImpl;

/**
 * Servlet implementation class ServletBorrarSombrero
 */
@WebServlet("/ServletBorrarSombrero")
public class ServletBorrarSombrero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		SombrerosDAO dao = new SombrerosDAOImpl();
		dao.borrarSombrero(Integer.parseInt(id));
		response.sendRedirect("ServletPortada");
	}

}
