package com.mbirtchnell.ocmjea.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mbirtchnell.ocmjea.domain.Component;
import com.mbirtchnell.ocmjea.domain.ComponentCategory;
import com.mbirtchnell.ocmjea.domain.ComponentFactory;
import com.mbirtchnell.ocmjea.domain.Product;

@Stateless
public class HouseDesignService
{
	@PersistenceContext(unitName = "test")
	private EntityManager entityManager;

	public List<ComponentCategory> getComponentCategories()
	{
		return Arrays.asList(ComponentCategory.values());
	}

	public List<Component> getComponentsForComponentCategory(ComponentCategory selectedComponentCategory, Product houseDesign)
	{
		System.out.println("Getting components for ComponentCategory " + selectedComponentCategory.getName());
		List<Component> components = new ArrayList<Component>();
		if("Door".equals(selectedComponentCategory.getName()))
		{
			Component frenchDoor = ComponentFactory.createComponent(selectedComponentCategory);
			frenchDoor.setName("French Door");
			frenchDoor.setDetails("A classic style.");
			frenchDoor.setApplicable(true);
			frenchDoor.setAvailable(true);
			components.add(frenchDoor);
			Component frontDoor = ComponentFactory.createComponent(selectedComponentCategory);
			frontDoor.setName("Front Door");
			frontDoor.setDetails("Standard type");
			frontDoor.setApplicable(true);
			frontDoor.setAvailable(true);
			components.add(frontDoor);
			Component slidingDoor = ComponentFactory.createComponent(selectedComponentCategory);
			slidingDoor.setName("Sliding Door");
			slidingDoor.setDetails("Floating type");
			slidingDoor.setApplicable(true);
			slidingDoor.setAvailable(true);
			components.add(slidingDoor);
			Component garageDoor = ComponentFactory.createComponent(selectedComponentCategory);
			garageDoor.setName("Garage Door");
			garageDoor.setDetails("Automatic type");
			garageDoor.setApplicable(true);
			garageDoor.setAvailable(true);
			components.add(garageDoor);
		}
		return components;
	}
}