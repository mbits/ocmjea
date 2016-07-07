package com.mbirtchnell.ocmjea.services;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.mbirtchnell.ocmjea.domain.Customer;

@Stateful
@TransactionAttribute(TransactionAttributeType.NEVER)
public class CustomerService
{
	@PersistenceContext(unitName = "test", type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public List<Customer> searchByZipCode(String searchTerm)
	{
		TypedQuery<Customer> q = entityManager.createQuery("SELECT c FROM Customer c WHERE zipCode = ?1", Customer.class);
		q.setParameter(1, searchTerm);
		List<Customer> results = (List<Customer>) q.getResultList();
		System.out.println("Customers found " + results.size());
		return results;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void init()
	{
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
			entityManager.persist(customerFour);
		}
	}

}
