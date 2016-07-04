package com.mbirtchnell.ocmjea.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Consultation
{
	@Id @GeneratedValue private int id;
	@ManyToOne private Customer customer;
	@OneToMany private List<CompletedDesign> completedDesigns;
	@ManyToOne private FieldSalesRepresentative fieldSalesRepresentative;

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Customer getCustomer()
	{
		return customer;
	}
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	public List<CompletedDesign> getCompletedDesigns()
	{
		return completedDesigns;
	}
	public void setCompletedDesigns(List<CompletedDesign> completedDesigns)
	{
		this.completedDesigns = completedDesigns;
	}
	public FieldSalesRepresentative getFieldSalesRepresentative()
	{
		return fieldSalesRepresentative;
	}
	public void setFieldSalesRepresentative(FieldSalesRepresentative fieldSalesRepresentative)
	{
		this.fieldSalesRepresentative = fieldSalesRepresentative;
	}
} 
