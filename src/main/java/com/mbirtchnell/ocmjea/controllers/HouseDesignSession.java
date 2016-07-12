package com.mbirtchnell.ocmjea.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.mbirtchnell.ocmjea.domain.Product;
import com.mbirtchnell.ocmjea.services.HouseDesignService;

@ManagedBean
@SessionScoped
public class HouseDesignSession
{
	@EJB private HouseDesignService houseDesignService;
	private List<Product> houseDesigns;
	
	@PostConstruct
	public void init()
	{
		if(getHouseDesigns() == null)
			setHouseDesigns(houseDesignService.getHouseDesigns());
	}
	
	public List<Product> getHouseDesigns()
	{
		return houseDesigns;
	}

	public void setHouseDesigns(List<Product> houseDesigns)
	{
		this.houseDesigns = houseDesigns;
	}
}
