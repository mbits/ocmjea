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
    private String name;

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

	public String getName() 
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		CompletedDesign other = (CompletedDesign) obj;
		if(id != other.id)
			return false;
		return true;
	}
}
