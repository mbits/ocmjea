package com.mbirtchnell.ocmjea.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Product
{
	@Id @GeneratedValue private int id;
	@ManyToMany private List<CompletedDesign> completedDesigns;
	@OneToOne private House house;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public List<CompletedDesign> getCompletedDesigns()
	{
		return completedDesigns;
	}

	public void setCompletedDesigns(List<CompletedDesign> completedDesigns)
	{
		this.completedDesigns = completedDesigns;
	}

	public House getHouse() 
	{
		return house;
	}

	public void setHouse(House house) 
	{
		this.house = house;
	}
}
