package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonItem;

/**
 * Servlet implementation class addPersonServlet
 */
@WebServlet("/addPersonServlet")
public class addPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonItemHelper pih = new PersonItemHelper();
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		int intAge = 0;
		try {
			intAge = Integer.parseInt(age);
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid age entered");
		}
		String gender = request.getParameter("gender");
		
		PersonItem pi = new PersonItem(name, intAge, gender);
		
		request.setAttribute("PersonInfo", pi);
		
		getServletContext().getRequestDispatcher("/addJob.jsp").forward(request, response);
	}

}
