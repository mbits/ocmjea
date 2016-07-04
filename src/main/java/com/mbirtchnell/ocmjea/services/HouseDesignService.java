package com.mbirtchnell.ocmjea.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mbirtchnell.ocmjea.domain.CompletedDesign;
import com.mbirtchnell.ocmjea.domain.Customer;

@Stateful
public class HouseDesignService
{
	@PersistenceContext(unitName = "test")
	private EntityManager entityManager;
	
	private Customer currentCustomer;
	private CompletedDesign currentHouseDesign;
	
	@PostConstruct
	public void init()
	{
		currentCustomer = new Customer();
	}
	
	public void create()
	{
		currentHouseDesign = new CompletedDesign();

		List<CompletedDesign> completedDesigns = currentCustomer.getCompletedDesigns();
		if(completedDesigns == null)
			completedDesigns = new ArrayList<CompletedDesign>();
		completedDesigns.add(currentHouseDesign);
		
		currentCustomer.setCompletedDesigns(completedDesigns);
	}

	public CompletedDesign getCurrentHouseDesign()
	{
		return currentHouseDesign;
	}

	public void setCurrentHouseDesign(CompletedDesign currentHouseDesign)
	{
		this.currentHouseDesign = currentHouseDesign;
	}

	public Customer getCurrentCustomer()
	{
		return currentCustomer;
	}
}