package com.mbirtchnell.ocmjea.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.mbirtchnell.ocmjea.domain.Component;
import com.mbirtchnell.ocmjea.domain.ComponentCategory;
import com.mbirtchnell.ocmjea.domain.House;
import com.mbirtchnell.ocmjea.domain.Product;
import com.mbirtchnell.ocmjea.services.HouseDesignService;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class HouseDesignController implements Serializable
{
	@EJB private HouseDesignService houseDesignService;
	private String houseDesignName;
	private Product currentHouseDesign;
	private List<Product> currentHouseDesigns = new ArrayList<Product>();
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
		currentHouseDesign = new Product();
		House house = new House();
		house.setName("New House");
		currentHouseDesign.setHouse(house);
		currentHouseDesigns.add(currentHouseDesign);
	}

	public void getComponentsForCategory()
	{
		List<Component> components = houseDesignService.getComponentsForComponentCategory(selectedComponentCategory, currentHouseDesign);
		setComponents(components);
	}

	public void addComponentToHouseDesign()
	{
		if(selectedComponent.isAvailable() && selectedComponent.isApplicable())
		{
			House house = currentHouseDesign.getHouse();
			if(house != null && selectedComponent != null)
				house.addToChildComponents(selectedComponent);
		}
		else
		{
			throw new IllegalStateException("Selected component cannot be added.");
		}
	}
	
	public Product getCompletedDesign()
	{
		return currentHouseDesign;
	}
	
	public void setCompletedDesign(Product completedDesign)
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

	public Product getCurrentHouseDesign()
	{
		return currentHouseDesign;
	}

	public void setCurrentHouseDesign(Product currentHouseDesign)
	{
		this.currentHouseDesign = currentHouseDesign;
	}

	public List<Product> getCurrentHouseDesigns()
	{
		return currentHouseDesigns;
	}

	public void setCurrentHouseDesigns(List<Product> currentHouseDesigns)
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
	
	public String outputProduct()
	{
		String output = "";
		House house = currentHouseDesign.getHouse();
		if(house != null)
			output += house.getName() + " = ";
		if(house != null && house.getChildComponents() != null)
		{
			for(Component child : house.getChildComponents())
			{
				output += child.getName() + " + ";
			}
		}
		
		return output;
	}
}
