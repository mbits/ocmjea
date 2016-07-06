package com.mbirtchnell.ocmjea.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mbirtchnell.ocmjea.domain.Aperture;
import com.mbirtchnell.ocmjea.domain.Component;
import com.mbirtchnell.ocmjea.domain.ComponentCategory;
import com.mbirtchnell.ocmjea.domain.ComponentFactory;
import com.mbirtchnell.ocmjea.domain.Foundation;
import com.mbirtchnell.ocmjea.domain.House;
import com.mbirtchnell.ocmjea.domain.Roof;
import com.mbirtchnell.ocmjea.domain.Wall;

@Stateless
public class HouseDesignService
{
	@PersistenceContext(unitName = "test")
	private EntityManager entityManager;

	public List<ComponentCategory> getComponentCategories()
	{
		return Arrays.asList(ComponentCategory.values());
	}

	public List<Component> getComponentsForComponentCategory(ComponentCategory selectedComponentCategory, House houseDesign)
	{
		System.out.println("Getting components for ComponentCategory " + selectedComponentCategory.getName());
		List<Component> components = new ArrayList<Component>();
		if("Door".equals(selectedComponentCategory.getName()))
		{
			Component frenchDoor = ComponentFactory.createComponent(selectedComponentCategory);
			frenchDoor.setName("French Door");
//			frenchDoor.setDetails("A classic style.");
//			frenchDoor.setApplicable(true);
//			frenchDoor.setAvailable(true);
			components.add(frenchDoor);
			Component frontDoor = ComponentFactory.createComponent(selectedComponentCategory);
			frontDoor.setName("Front Door");
//			frontDoor.setDetails("Standard type");
//			frontDoor.setApplicable(true);
//			frontDoor.setAvailable(true);
			components.add(frontDoor);
			Component slidingDoor = ComponentFactory.createComponent(selectedComponentCategory);
			slidingDoor.setName("Sliding Door");
//			slidingDoor.setDetails("Floating type");
//			slidingDoor.setApplicable(true);
//			slidingDoor.setAvailable(true);
			components.add(slidingDoor);
			Component garageDoor = ComponentFactory.createComponent(selectedComponentCategory);
			garageDoor.setName("Garage Door");
//			garageDoor.setDetails("Automatic type");
//			garageDoor.setApplicable(true);
//			garageDoor.setAvailable(true);
			components.add(garageDoor);
		}
		return components;
	}

	public List<House> getHouseDesigns()
	{
		List<House> houseDesigns = new ArrayList<House>();
		
		House houseOne = new House();
		houseOne.setName("Californian bungalow");
		houseDesigns.add(houseOne);
		House houseTwo = new House();
		houseTwo.setName("Brick clinker");
		houseDesigns.add(houseTwo);
		House houseThree = new House();
		houseThree.setName("Townhouse");
		houseDesigns.add(houseThree);
		House houseFour = new House();
		houseFour.setName("Family home");
		houseDesigns.add(houseFour);
		
		return houseDesigns;
	}

	public void addComponentToHouse(House selectedHouseDesign, Component selectedComponent)
	{
		if(selectedComponent instanceof Foundation)
		{
			selectedHouseDesign.setFoundation((Foundation) selectedComponent);
		}
		if(selectedComponent instanceof Roof)
		{
			selectedHouseDesign.setRoof((Roof) selectedComponent);
		}
		if(selectedComponent instanceof Wall)
		{
			List<Wall> walls = selectedHouseDesign.getWalls();
			if(walls == null)
				walls = new ArrayList<Wall>();
			walls.add((Wall) selectedComponent);
			selectedHouseDesign.setWalls(walls);
		}
		if(selectedComponent instanceof Aperture)
		{
			List<Wall> walls = selectedHouseDesign.getWalls();
			if(walls != null)
			{
				for(Wall wall : walls)
				{
					List<Aperture> apertures = wall.getApertures();
					if(apertures == null)
						apertures = new ArrayList<Aperture>();
					apertures.add((Aperture) selectedComponent);
				}
			}
		}
	}
}