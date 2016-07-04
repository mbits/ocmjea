package com.mbirtchnell.ocmjea.controllers;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mbirtchnell.ocmjea.services.HouseDesignService;

@Named
public class HouseDesignController
{
	@EJB private HouseDesignService houseDesignService;
	
	public void newHouseDesign()
	{
		houseDesignService.create();
	}
}
