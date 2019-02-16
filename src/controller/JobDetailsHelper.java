package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.JobDetails;
import model.PersonItem;

public class JobDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PersonMultiJoin");
	
	public void InsertNewJobDetails(JobDetails jd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(jd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<JobDetails> getJobs() {
		EntityManager em = emfactory.createEntityManager();
		List<JobDetails> allDetails = em.createQuery("SELECT d FROM JobDetails d").getResultList();
		return allDetails;
	}
	
	public void DeleteItems(int toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Integer> query = em.createQuery("SELECT j.JOB_ID FROM job_to_person j WHERE j.PERSON_ID = :selectedPerson", Integer.class);
		query.setParameter("selectedPerson", toDelete);
		
		List<Integer> jobsToDelete = query.getResultList();
		
		for (int a : jobsToDelete) {
			JobDetails toRemove = searchByID(a);
			em.remove(toRemove);
			em.getTransaction().commit();
		}
		em.close();
	}
	
	public JobDetails searchByID(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		JobDetails found = em.find(JobDetails.class, id);
		em.close();
		return found;
	}
}
