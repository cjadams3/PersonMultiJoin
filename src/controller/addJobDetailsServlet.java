package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.JobDetails;
import model.PersonItem;

/**
 * Servlet implementation class addJobDetailsServlet
 */
@WebServlet("/addJobDetailsServlet")
public class addJobDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addJobDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("toAdd");

		JobDetailsHelper jdh = new JobDetailsHelper();
		PersonItemHelper pih = new PersonItemHelper();
		int personID = Integer.parseInt(request.getParameter("id"));
		String personName = request.getParameter("name");
		int personAge = Integer.parseInt(request.getParameter("age"));
		String personGender = request.getParameter("gender");
		PersonItem thisPerson = pih.searchForItemById(personID);
		
		String jobTitle = request.getParameter("title");
		String employer = request.getParameter("employer");
		String sSalary = request.getParameter("salary");
		BigDecimal salary = new BigDecimal(sSalary);
		String stMonth = request.getParameter("stMM");
		String stDay = request.getParameter("stDD");
		String stYear = request.getParameter("stYYYY");
		LocalDate stDate;
		try {
			stDate = LocalDate.of(Integer.parseInt(stYear),
			Integer.parseInt(stMonth), Integer.parseInt(stDay));
		}
		catch(NumberFormatException ex) {
			stDate = LocalDate.now();
		}
		
		String endMonth = request.getParameter("endMM");
		String endDay = request.getParameter("endDD");
		String endYear = request.getParameter("endYYYY");
		LocalDate endDate;
		try {
			endDate = LocalDate.of(Integer.parseInt(endYear),
			Integer.parseInt(endMonth), Integer.parseInt(endDay));
		}
		catch(NumberFormatException ex) {
			endDate = LocalDate.now();
		}
		JobDetails newJob = new JobDetails(jobTitle, employer, salary, stDate, endDate);
		
		if (thisPerson != null) {
			newJob.setPerson(thisPerson);
			thisPerson.getAllJobs().add(newJob);
			pih.updateItem(thisPerson);
		}
		else {
		PersonItem pToAdd = new PersonItem(personName, personAge, personGender);
		newJob.setPerson(pToAdd);
		pToAdd.getAllJobs().add(newJob);
		jdh.InsertNewJobDetails(newJob);
		}
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		if (act.equals("Submit")) {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
	}

}
