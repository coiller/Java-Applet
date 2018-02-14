package servlet;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Show
 */

public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Show() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String x = request.getParameter("appWidth");
		String y = request.getParameter("appHeight");
		String MESSAGE = request.getParameter("MESSAGE");
		String SHAPE = request.getParameter("SHAPE");
		String COLOR = request.getParameter("COLOR");
		String X = request.getParameter("X");
		String Y = request.getParameter("Y");
		String BGCOLOR = request.getParameter("BGCOLOR");
		String FTSTYLE = request.getParameter("FTSTYLE");
		String FTSIZE = request.getParameter("FTSIZE");	
		ServletContext c=getServletContext();
		URL url=c.getResource("/WEB-INF/lib/ShowShape.class");
		String path=url.toString();
		request.setAttribute("x", x);
		request.setAttribute("y", y);
		request.setAttribute("MESSAGE", MESSAGE);
		request.setAttribute("SHAPE", SHAPE);
		request.setAttribute("COLOR", COLOR);
		request.setAttribute("X", X);
		request.setAttribute("Y", Y);
		request.setAttribute("BGCOLOR", BGCOLOR);
		request.setAttribute("FTSTYLE", FTSTYLE);
		request.setAttribute("FTSIZE", FTSIZE);
		request.setAttribute("path", path);

		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
