package about.classloader1;

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

import pojo.BMWCar;

/**
 * Servlet implementation class CreateCarBMW
 */
@WebServlet("/CreateBMWCar")
public class CreateBMWCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletContext sc = request.getServletContext();
		
		ICar bmw = new BMWCar();
		
		bmw.setModello("Serie 3");
		bmw.setNome("320d");
		
		sc.setAttribute("CAR", bmw);
		
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.write("Timestamp: "+GregorianCalendar.getInstance().getTimeInMillis());
		out.write("Creata auto:\n");
		out.write("Nome: "+bmw.getNome() + "Modello: "+bmw.getModello() );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
