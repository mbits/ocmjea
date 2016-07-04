package com.mbirtchnell.ocmjea.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class CompletedDesign
{
	@Id @GeneratedValue private int id;
	@ManyToOne private Customer customer;
    @ManyToMany private List<Product> products;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public List<Product> getProducts()
	{
		return products;
	}

	public void setProducts(List<Product> products)
	{
		this.products = products;
	}
	
    public Customer getCustomer() 
    { 
    	return customer; 
    }

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
}
