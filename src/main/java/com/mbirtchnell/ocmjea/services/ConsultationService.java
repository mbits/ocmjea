package com.mbirtchnell.ocmjea.services;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.mbirtchnell.ocmjea.domain.CompletedDesign;
import com.mbirtchnell.ocmjea.domain.Customer;

@Stateful
@TransactionAttribute(TransactionAttributeType.NEVER)
public class ConsultationService
{
	private static final Logger log = Logger.getLogger("ConsultationService");
	@PersistenceContext(unitName = "test", type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public List<CompletedDesign> searchByZipCode(String searchTerm)
	{
		TypedQuery<CompletedDesign> q = entityManager.createQuery("SELECT c FROM CompletedDesign c JOIN c.customer c2 WHERE c2.zipCode = ?1", CompletedDesign.class);
		q.setParameter(1, searchTerm);
		List<CompletedDesign> results = (List<CompletedDesign>) q.getResultList();
		System.out.println("Customers found " + results.size());
		return results;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void init()
	{
		log.info("Initializing");
		TypedQuery<Customer> q = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
		List<Customer> results = (List<Customer>) q.getResultList();
		if(results == null || results.isEmpty())
		{
			System.out.println("Creating customers");
			Customer customerOne = new Customer();
			customerOne.setZipCode("1002");
			customerOne.setEmail("first@localhost.com");
			customerOne.setPhone("04100100101");
			customerOne.setFirstName("First");
			customerOne.setLastName("Customer");
			customerOne.setStreet("1 Test Street");
			customerOne.setState("Victoria");
			customerOne.setCountry("Australia");
			CompletedDesign designOne = new CompletedDesign();
			designOne.setCustomer(customerOne);
			customerOne.setCompletedDesigns(Arrays.asList(new CompletedDesign[] { designOne }));
			entityManager.persist(designOne);
			entityManager.persist(customerOne);
			
			Customer customerTwo = new Customer();
			customerTwo.setZipCode("1002");
			customerTwo.setEmail("second@localhost.com");
			customerOne.setPhone("04100100102");
			customerTwo.setFirstName("Second");
			customerTwo.setLastName("Customer");
			customerTwo.setStreet("2 Test Street");
			customerTwo.setState("Victoria");
			customerTwo.setCountry("Australia");
			CompletedDesign designTwo = new CompletedDesign();
			designTwo.setCustomer(customerTwo);
			customerOne.setCompletedDesigns(Arrays.asList(new CompletedDesign[] { designTwo }));
			entityManager.persist(designTwo);
			entityManager.persist(customerTwo);
			
			Customer customerThree = new Customer();
			customerThree.setZipCode("1003");
			customerThree.setEmail("third@localhost.com");
			customerOne.setPhone("04100100103");
			customerThree.setFirstName("Third");
			customerThree.setLastName("Customer");
			customerThree.setStreet("3 Test Street");
			customerThree.setState("Victoria");
			customerThree.setCountry("Australia");
			CompletedDesign designThree = new CompletedDesign();
			designThree.setCustomer(customerThree);
			customerOne.setCompletedDesigns(Arrays.asList(new CompletedDesign[] { designThree }));
			entityManager.persist(designThree);
			entityManager.persist(customerThree);
			
			Customer customerFour = new Customer();
			customerFour.setZipCode("1002");
			customerFour.setEmail("fourth@localhost.com");
			customerOne.setPhone("04100100104");
			customerFour.setFirstName("Fourth");
			customerFour.setLastName("Customer");
			customerFour.setStreet("4 Test Street");
			customerFour.setState("Victoria");
			customerFour.setCountry("Australia");
			CompletedDesign designFour = new CompletedDesign();
			designFour.setCustomer(customerFour);
			customerOne.setCompletedDesigns(Arrays.asList(new CompletedDesign[] { designFour }));
			entityManager.persist(designFour);
			entityManager.persist(customerFour);
		}
	}
}
