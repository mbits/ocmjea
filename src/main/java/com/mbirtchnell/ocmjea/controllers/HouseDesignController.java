package com.mbirtchnell.ocmjea.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.mbirtchnell.ocmjea.domain.CompletedDesign;
import com.mbirtchnell.ocmjea.domain.Component;
import com.mbirtchnell.ocmjea.domain.ComponentCategory;
import com.mbirtchnell.ocmjea.services.HouseDesignService;

@Named
@SessionScoped
public class HouseDesignController
{
	@EJB private HouseDesignService houseDesignService;
	private String houseDesignName;
	private CompletedDesign currentHouseDesign;
	private List<CompletedDesign> currentHouseDesigns = new ArrayList<CompletedDesign>();
	private ComponentCategory selectedComponentCategory;
	private List<ComponentCategory> componentCategories = new ArrayList<ComponentCategory>();
	private List<Component> components = new ArrayList<Component>();
	private Component selectedComponent;

	@PostConstruct
	public void init()
	{
		setComponentCategories(houseDesignService.getComponentCategories());
	}
	
	public void newHouseDesign()
	{
		currentHouseDesign = new CompletedDesign();
		currentHouseDesigns.add(currentHouseDesign);
	}

	public void getComponentsForCategory()
	{
		List<Component> components = houseDesignService.getComponentsForComponentCategory(selectedComponentCategory, currentHouseDesign);
		setComponents(components);
	}

	public void addComponentToHouseDesign()
	{
		
	}
	
	public CompletedDesign getCompletedDesign()
	{
		return currentHouseDesign;
	}
	
	public void setCompletedDesign(CompletedDesign completedDesign)
	{
		this.currentHouseDesign = completedDesign;
	}

	public String getHouseDesignName()
	{
		return houseDesignName;
	}

	public void setHouseDesignName(String houseDesignName)
	{
		this.houseDesignName = houseDesignName;
	}

	public CompletedDesign getCurrentHouseDesign()
	{
		return currentHouseDesign;
	}

	public void setCurrentHouseDesign(CompletedDesign currentHouseDesign)
	{
		this.currentHouseDesign = currentHouseDesign;
	}

	public List<CompletedDesign> getCurrentHouseDesigns()
	{
		return currentHouseDesigns;
	}

	public void setCurrentHouseDesigns(List<CompletedDesign> currentHouseDesigns)
	{
		this.currentHouseDesigns = currentHouseDesigns;
	}

	public ComponentCategory getSelectedComponentCategory()
	{
		return selectedComponentCategory;
	}

	public void setSelectedComponentCategory(ComponentCategory selectedComponentCategory)
	{
		this.selectedComponentCategory = selectedComponentCategory;
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
