package about.classloader2;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import about.classcastexception.ICar;


/**
 * Servlet implementation class ReadCarBMW
 */
@WebServlet("/ReadCar")
public class ReadCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = request.getServletContext().getContext("/WebAppForClassLoader1");
		
		ICar car = (ICar) sc.getAttribute("CAR");
		

		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.write("Timestamp: "+GregorianCalendar.getInstance().getTimeInMillis());
		out.write("Auto recuperata:\n");
		out.write("Nome: "+car.getNome() + " Modello: "+car.getModello()+"" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
