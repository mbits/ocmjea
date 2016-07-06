package com.mbirtchnell.ocmjea.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.mbirtchnell.ocmjea.domain.Component;
import com.mbirtchnell.ocmjea.domain.ComponentCategory;
import com.mbirtchnell.ocmjea.domain.House;
import com.mbirtchnell.ocmjea.services.HouseDesignService;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class HouseDesignController implements Serializable
{
	@EJB private HouseDesignService houseDesignService;
	private String houseDesignName;
	private House selectedHouseDesign;
	private ComponentCategory selectedComponentCategory;
	private List<House> houseDesigns;
	private List<ComponentCategory> componentCategories;
	private List<Component> components;
	private Component selectedComponent;

	@PostConstruct
	public void init()
	{
		if(getHouseDesigns() == null)
			setHouseDesigns(houseDesignService.getHouseDesigns());
		if(getComponentCategories() == null)
			setComponentCategories(houseDesignService.getComponentCategories());
	}

	public void getComponentsForCategory()
	{
		components = houseDesignService.getComponentsForComponentCategory(selectedComponentCategory, selectedHouseDesign);
	}

	public void addComponentToHouseDesign()
	{
		components = null;
		houseDesignService.addComponentToHouse(selectedHouseDesign, selectedComponent);
	}

	public String getHouseDesignName()
	{
		return houseDesignName;
	}

	public void setHouseDesignName(String houseDesignName)
	{
		this.houseDesignName = houseDesignName;
	}
	
	public House getSelectedHouseDesign()
	{
		return selectedHouseDesign;
	}

	public void setSelectedHouseDesign(House selectedHouseDesign)
	{
		this.selectedHouseDesign = selectedHouseDesign;
	}

	public ComponentCategory getSelectedComponentCategory()
	{
		return selectedComponentCategory;
	}

	public void setSelectedComponentCategory(ComponentCategory selectedComponentCategory)
	{
		this.selectedComponentCategory = selectedComponentCategory;
	}
	
	public List<House> getHouseDesigns()
	{
		return houseDesigns;
	}

	public void setHouseDesigns(List<House> houseDesigns)
	{
		this.houseDesigns = houseDesigns;
	}

	public List<ComponentCategory> getComponentCategories()
	{
		return componentCategories;
	}

	public void setComponentCategories(List<ComponentCategory> componentCategories)
	{
		this.componentCategories = componentCategories;
	}
	
	public List<Component> getComponents()
	{
		return components;
	}

	public void setComponents(List<Component> components)
	{
		this.components = components;
	}

	public Component getSelectedComponent()
	{
		return selectedComponent;
	}

	public void setSelectedComponent(Component selectedComponent)
	{
		this.selectedComponent = selectedComponent;
	}
}
