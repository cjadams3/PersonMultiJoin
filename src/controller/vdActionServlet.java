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
 * Servlet implementation class vdActionServlet
 */
@WebServlet("/vdActionServlet")
public class vdActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vdActionServlet() {
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
		String act = request.getParameter("thisAction");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllServlet").forward(request, response);
		}
		else if (act.equals("Delete Job")) {
			PersonItemHelper pih = new PersonItemHelper();
			Integer personId = Integer.parseInt(request.getParameter("pId"));
			PersonItem toDeleteFrom = pih.searchForItemById(personId);
			List<JobDetails> jobsToView = toDeleteFrom.getAllJobs();
			Integer jobId = Integer.parseInt(request.getParameter("jId"));
			pih.DeleteJob(toDeleteFrom, jobId);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if (act.equals("Add New Job")) {
			PersonItemHelper pih = new PersonItemHelper();
			Integer personId = Integer.parseInt(request.getParameter("pId"));
			PersonItem toAddTo = pih.searchForItemById(personId);
			request.setAttribute("PersonInfo", toAddTo);
			getServletContext().getRequestDispatcher("/addJob.jsp").forward(request, response);
		}
	}

}
