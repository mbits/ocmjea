package com.mbirtchnell.ocmjea.services;

import java.util.ArrayList;
import java.util.List;

import com.mbirtchnell.ocmjea.domain.Component;
import com.mbirtchnell.ocmjea.domain.ComponentCategory;
import com.mbirtchnell.ocmjea.domain.ComponentFactory;
import com.mbirtchnell.ocmjea.domain.House;

public class InventorySystem
{
	public static List<Component> getComponentsForComponentCategory(ComponentCategory selectedComponentCategory, House houseDesign)
	{
		System.out.println("Getting components for ComponentCategory " + selectedComponentCategory.getName());
		List<Component> components = new ArrayList<Component>();
		switch(selectedComponentCategory)
		{
		case DOOR:
			Component frenchDoor = ComponentFactory.createComponent(selectedComponentCategory);
			frenchDoor.setName("French Door");
			components.add(frenchDoor);
			Component frontDoor = ComponentFactory.createComponent(selectedComponentCategory);
			frontDoor.setName("Front Door");
			components.add(frontDoor);
			Component slidingDoor = ComponentFactory.createComponent(selectedComponentCategory);
			slidingDoor.setName("Sliding Door");
			components.add(slidingDoor);
			Component garageDoor = ComponentFactory.createComponent(selectedComponentCategory);
			garageDoor.setName("Garage Door");
			components.add(garageDoor);
			break;
		case WINDOW:
			Component frenchWindow = ComponentFactory.createComponent(selectedComponentCategory);
			frenchWindow.setName("French Window");
			components.add(frenchWindow);
			Component frontWindow = ComponentFactory.createComponent(selectedComponentCategory);
			frontWindow.setName("Front Window");
			components.add(frontWindow);
			Component smallWindow = ComponentFactory.createComponent(selectedComponentCategory);
			smallWindow.setName("Small Window");
			components.add(smallWindow);
		break;
		case FOUNDATION:
			Component waffle = ComponentFactory.createComponent(selectedComponentCategory);
			waffle.setName("Waffle Foundation");
			components.add(waffle);
			Component pileAndBeam = ComponentFactory.createComponent(selectedComponentCategory);
			pileAndBeam.setName("Pile Foundation");
			components.add(pileAndBeam);
			Component mat = ComponentFactory.createComponent(selectedComponentCategory);
			mat.setName("Mat Foundation");
			components.add(mat);
		break;
		case ROOF:
			Component tile = ComponentFactory.createComponent(selectedComponentCategory);
			tile.setName("Tile Roof");
			components.add(tile);
			Component metal = ComponentFactory.createComponent(selectedComponentCategory);
			metal.setName("Metal Roof");
			components.add(metal);
		break;
		case WALL:
			Component weatherboard = ComponentFactory.createComponent(selectedComponentCategory);
			weatherboard.setName("Weatherboard Wall");
			components.add(weatherboard);
			Component brickVeneer = ComponentFactory.createComponent(selectedComponentCategory);
			brickVeneer.setName("Brick Veneer Wall");
			components.add(brickVeneer);
			Component doubleBrick = ComponentFactory.createComponent(selectedComponentCategory);
			doubleBrick.setName("Double Brick");
			components.add(doubleBrick);
		break;
		}
		
		return components;
	}

	public static List<House> getHouseDesigns()
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
}
