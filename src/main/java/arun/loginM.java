package arun;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginM
 */
@WebServlet("/loginM")
public class loginM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginM() {
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
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sub = request.getParameter("submit");
		String nam = request.getParameter("uName");
		String pas = request.getParameter("pass");
		String mobi = request.getParameter("mobile");
		String serv = request.getParameter("server");
		if(sub.equals("admin")) {
			if (nam.equals("Admin")&&pas.equals("Admin@ak")) {
				RequestDispatcher rdr = request.getRequestDispatcher("adminHome.html");
				rdr.forward(request, response);
			} else {
				out.print(" invalid user name or password");
				RequestDispatcher rdr = request.getRequestDispatcher("login.html");
				rdr.include(request, response);
			}
		}
		else if(sub.equals("consumerLogin")) {
			 if (connectivity.login(nam, pas)) {
					RequestDispatcher rdr = request.getRequestDispatcher("uBill.html");
					rdr.forward(request, response);
				 } else {
						out.print(" invalid user name or password");
						RequestDispatcher rdr = request.getRequestDispatcher("login.html");
						rdr.include(request, response);
			 }
		}
		else {
			if (connectivity.anotherlogin(mobi, serv)) {
				RequestDispatcher rdr = request.getRequestDispatcher("uBill.html");
				rdr.forward(request, response);
			 } else {
					out.print(" invalid user name or password");
					RequestDispatcher rdr = request.getRequestDispatcher("login.html");
					rdr.include(request, response);
		 }
		}
			
	}

	public static boolean admin(String nam, String pas) {
		
		return true;
	}

}
