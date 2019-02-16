package model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="job_details")
public class JobDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JOB_ID")
	private int id;
	@Column(name="JOB_TITLE")
	private String jobTitle;
	@Column(name="EMPLOYER")
	private String employer;
	@Column(name="SALARY")
	private BigDecimal salary;
	@Column(name="START_DATE")
	private LocalDate startDate;
	@Column(name="END_DATE")
	private LocalDate endDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID")
	private PersonItem person;

	public JobDetails() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public PersonItem getPerson() {
		return person;
	}

	public void setPerson(PersonItem person) {
		this.person = person;
	}

	public JobDetails(String jobTitle, String employer, BigDecimal salary, LocalDate startDate, LocalDate endDate) {
		this.jobTitle = jobTitle;
		this.employer = employer;
		this.salary = salary;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public JobDetails(String jobTitle, String employer, BigDecimal salary, LocalDate startDate, LocalDate endDate, PersonItem person) {
		this.jobTitle = jobTitle;
		this.employer = employer;
		this.salary = salary;
		this.startDate = startDate;
		this.endDate = endDate;
		this.person = person;
	}
	
	public String toString() {
		return "[id = " + id + ", jobTitle = " + jobTitle + ", employer = " + employer + ", salary = $" + salary + ", startDate = " + startDate + ", endDate = " + endDate + "]";
	}
	
}
