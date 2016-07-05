package com.mbirtchnell.ocmjea.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mbirtchnell.ocmjea.domain.CompletedDesign;
import com.mbirtchnell.ocmjea.domain.Component;
import com.mbirtchnell.ocmjea.domain.ComponentCategory;
import com.mbirtchnell.ocmjea.domain.ComponentFactory;

@Stateless
public class HouseDesignService
{
	@PersistenceContext(unitName = "test")
	private EntityManager entityManager;

	public List<ComponentCategory> getComponentCategories()
	{
		return Arrays.asList(ComponentCategory.values());
	}

	public List<Component> getComponentsForComponentCategory(ComponentCategory selectedComponentCategory, CompletedDesign houseDesign)
	{
		System.out.println("Getting components for ComponentCategory " + selectedComponentCategory.getName());
		List<Component> components = new ArrayList<Component>();
		if("Door".equals(selectedComponentCategory.getName()))
		{
			Component frenchDoor = ComponentFactory.createComponent(selectedComponentCategory);
			frenchDoor.setName("French Door");
			frenchDoor.setDetails("A classic style.");
			components.add(frenchDoor);
			Component frontDoor = ComponentFactory.createComponent(selectedComponentCategory);
			frenchDoor.setName("Front Door");
			frenchDoor.setDetails("Standard type");
			components.add(frontDoor);
			Component slidingDoor = ComponentFactory.createComponent(selectedComponentCategory);
			frenchDoor.setName("Sliding Door");
			frenchDoor.setDetails("Floating type");
			components.add(slidingDoor);
			Component garageDoor = ComponentFactory.createComponent(selectedComponentCategory);
			frenchDoor.setName("Garage Door");
			frenchDoor.setDetails("Automatic type");
			components.add(garageDoor);
		}
		return components;
	}
}