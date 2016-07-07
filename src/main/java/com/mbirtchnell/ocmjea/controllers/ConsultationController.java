package com.mbirtchnell.ocmjea.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.mbirtchnell.ocmjea.domain.Customer;
import com.mbirtchnell.ocmjea.domain.FieldSalesRepresentative;
import com.mbirtchnell.ocmjea.services.CustomerService;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class ConsultationController implements Serializable
{
	private FieldSalesRepresentative fieldSalesRepresentative;
	private String searchTerm;
	private List<Customer> customers = new ArrayList<Customer>();
	private Customer selectedCustomer;
	
	@EJB
	CustomerService customerService;
	
	@PostConstruct
	public void init()
	{
		customerService.init();
	}
	
	public void search()
	{
		customers = customerService.searchByZipCode(searchTerm);
	}

	public FieldSalesRepresentative getFieldSalesRepresentative()
	{
		return fieldSalesRepresentative;
	}

	public void setFieldSalesRepresentative(FieldSalesRepresentative fieldSalesRepresentative)
	{
		this.fieldSalesRepresentative = fieldSalesRepresentative;
	}

	public String getSearchTerm()
	{
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm)
	{
		this.searchTerm = searchTerm;
	}

	public List<Customer> getCustomers()
	{
		return customers;
	}

	public void setCustomers(List<Customer> customers)
	{
		this.customers = customers;
	}

	public Customer getSelectedCustomer()
	{
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer)
	{
		this.selectedCustomer = selectedCustomer;
	}
}
