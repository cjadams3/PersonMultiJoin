package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.JobDetails;
import model.PersonItem;

/**
 * Servlet implementation class listThisServlet
 */
@WebServlet("/listThisServlet")
public class listThisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listThisServlet() {
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
		Integer thisId = Integer.parseInt(request.getParameter("id"));
		String act = request.getParameter("doThis");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllServlet").forward(request, response);
		}
		else if (act.equals("Delete Person")) {
			PersonItemHelper pih = new PersonItemHelper();
			PersonItem toDelete = pih.searchForItemById(thisId);
			
			pih.Remove(toDelete);
			}
		else if (act.equals("View Details")) {
			PersonItemHelper pih = new PersonItemHelper();
			PersonItem toView = pih.searchForItemById(thisId);
			List<JobDetails> jobsToView = toView.getAllJobs();
			request.setAttribute("personItem", toView);
			request.setAttribute("jobsList", jobsToView);
			getServletContext().getRequestDispatcher("/view-details.jsp").forward(request, response);
			return;
		}
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}

}
