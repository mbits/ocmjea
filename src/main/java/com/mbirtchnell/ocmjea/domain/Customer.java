package com.mbirtchnell.ocmjea.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer
{
	@Id @GeneratedValue private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String zipCode;
	@OneToMany private List<CompletedDesign> completedDesigns;
	@OneToMany private List<Customer> customers;
	private String street;
	private String state;
	private String country;
	private String phone;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getFullName()
	{
		return getFirstName() + " " + getLastName();
	}
	
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public List<CompletedDesign> getCompletedDesigns()
	{
		return completedDesigns;
	}

	public void setCompletedDesigns(List<CompletedDesign> completedDesigns)
	{
		this.completedDesigns = completedDesigns;
	}
	
	public List<Customer> getCustomers()
	{
		return customers;
	}

	public void setCustomers(List<Customer> customers)
	{
		this.customers = customers;
	}
	
	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	@Override
	public String toString()
	{
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	public String getStreet()
	{
		return this.street;
	}
	
	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getState()
	{
		return this.state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}

	public String getCountry()
	{
		return this.country;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getPhone()
	{
		return this.phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
}
