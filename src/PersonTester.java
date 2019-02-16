import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import controller.JobDetailsHelper;
import controller.PersonItemHelper;
import model.JobDetails;
import model.PersonItem;

public class PersonTester {

	public static void main(String[] args) {
		PersonItem matt = new PersonItem("Tim", 22, "Male");
		
		String sSal = "25000";
		BigDecimal sal = new BigDecimal(sSal);
		String sStart = "2016-01-15";
		String sEnd = "2017-03-15";
		LocalDate stDate = LocalDate.parse(sStart);
		LocalDate endDate = LocalDate.parse(sEnd);
		
		JobDetailsHelper jdh = new JobDetailsHelper();
		PersonItemHelper pih = new PersonItemHelper();
		
		
	//	JobDetails newJob = new JobDetails ("Cheffy", "Test", sal, stDate, endDate);
	//	matt.getAllJobs().add(newJob);
	//	PersonItem tim = pih.searchForItemById(51);
		JobDetails newJob = new JobDetails ("Cheffy", "Test", sal, stDate, endDate);
		newJob.setPerson(matt);
		JobDetails secondJob = new JobDetails ("Cheffy", "TestTwo", sal, stDate, endDate);
		secondJob.setPerson(matt);
		
		matt.getAllJobs().add(newJob);
		matt.getAllJobs().add(secondJob);
	//	pih.InsertItem(matt);
		
	/*	List<PersonItem> thisList = pih.showAllItems();
		List<JobDetails> otherList = jdh.getJobs();
		
		for (PersonItem a : thisList) {
			System.out.println(a.toString());
		}
		
		for (JobDetails b : otherList) {
			System.out.println(b.toString());
		} */
		jdh.InsertNewJobDetails(newJob);
		
		}


}
