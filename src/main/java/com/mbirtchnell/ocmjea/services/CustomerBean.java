package com.mbirtchnell.ocmjea.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mbirtchnell.ocmjea.domain.Customer;

@Stateless
public class CustomerBean
{
	public void test()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");  
		EntityManager em = emf.createEntityManager();                               
		EntityTransaction tx = em.getTransaction();                                 
	
		Customer test = em.find(Customer.class, 1);                                         
		if (test == null) {                                                         
		  test = new Customer();                                                        
		  test.setEmail("test@testing.com");
		  test.setFirstName("Test");
		  test.setLastName("Testing");
		  tx.begin();                                                               
		  em.persist(test);                                                         
		  tx.commit();                                                              
		}                                                                           
	
		System.out.format("Customer{%s}\n", test.toString());            
	
		em.close();                                                                 
		emf.close();  
	}
}
