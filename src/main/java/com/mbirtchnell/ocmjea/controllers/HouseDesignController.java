package com.mbirtchnell.ocmjea.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import com.mbirtchnell.ocmjea.domain.CompletedDesign;
import com.mbirtchnell.ocmjea.services.HouseDesignService;

@Named
@RequestScoped
public class HouseDesignController
{
	@EJB private HouseDesignService houseDesignService;
	private Map<String, CompletedDesign> completedDesignMap = 
			new HashMap<String, CompletedDesign>();
	
	@PostConstruct
	public void init()
	{
		List<CompletedDesign> designs = 
				houseDesignService.getCurrentCustomer().getCompletedDesigns();
		for(CompletedDesign design : designs)
		{
			completedDesignMap.put(design.getName(), design);
		}
	}

	public void newHouseDesign()
	{
		houseDesignService.create("New Design");
	}

	public Map<String, CompletedDesign> getCompletedDesignMap() 
	{
		return completedDesignMap;
	}

	public void setCompletedDesignMap(Map<String, CompletedDesign> completedDesignMap) 
	{
		this.completedDesignMap = completedDesignMap;
	}
}
