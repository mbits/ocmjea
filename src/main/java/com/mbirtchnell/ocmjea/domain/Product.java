package com.mbirtchnell.ocmjea.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Product
{
	@Id private String id;
	@ManyToMany private List<CompletedDesign> completedDesigns;
	@OneToOne private House house;
	private HouseDesignStatus status;
	private String generatedDownloadLink;

	public Product()
	{
		this.id = UUID.randomUUID().toString();
		status = HouseDesignStatus.IN_PROGRESS;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
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
	
	public HouseDesignStatus getStatus()
	{
		return this.status;
	}

	public void setStatus(HouseDesignStatus completed)
	{
		this.status = completed;
	}

	public String getGeneratedDownloadLink()
	{
		return generatedDownloadLink;
	}
	
	public void setGeneratedDownloadLink(String generatedDownloadLink)
	{
		this.generatedDownloadLink = generatedDownloadLink;
	}

	public void calculateIndicativeCost()
	{
		
	}
}
