package com.mbirtchnell.ocmjea.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import com.mbirtchnell.ocmjea.domain.Aperture;
import com.mbirtchnell.ocmjea.domain.Component;
import com.mbirtchnell.ocmjea.domain.ComponentCategory;
import com.mbirtchnell.ocmjea.domain.ComponentFactory;
import com.mbirtchnell.ocmjea.domain.Foundation;
import com.mbirtchnell.ocmjea.domain.House;
import com.mbirtchnell.ocmjea.domain.Product;
import com.mbirtchnell.ocmjea.domain.Roof;
import com.mbirtchnell.ocmjea.domain.Wall;
import com.sun.istack.logging.Logger;

@Stateless
public class InventorySystemDAO
{
	private static final Logger log = Logger.getLogger(InventorySystemDAO.class);
	public List<ComponentCategory> getComponentCategories()
	{
		log.info("Getting Component Categories");
		return Arrays.asList(ComponentCategory.values());
	}

	public List<Component> getComponentsForComponentCategory(ComponentCategory selectedComponentCategory, Product product)
	{
		System.out.println("Getting components for ComponentCategory " + selectedComponentCategory.getName());
		List<Component> components = new ArrayList<Component>();
		switch(selectedComponentCategory)
		{
		case DOOR:
			Component frenchDoor = ComponentFactory.createComponent(selectedComponentCategory);
			frenchDoor.setName("French Door");
			frenchDoor.setDetail("A French door offers Slimline design, uninterrupted glass panels and a picture book outlook.");
			frenchDoor.setAvailability("Available");
			frenchDoor.setApplicability("Applicable");
			components.add(frenchDoor);
			Component frontDoor = ComponentFactory.createComponent(selectedComponentCategory);
			frontDoor.setName("Front Door");
			frontDoor.setDetail("First impressions are long lasting and your entry door sets the tone and character for the rest of your home.");
			frontDoor.setAvailability("Available");
			frontDoor.setApplicability("Applicable");
			components.add(frontDoor);
			Component slidingDoor = ComponentFactory.createComponent(selectedComponentCategory);
			slidingDoor.setName("Sliding Door");
			slidingDoor.setDetail("Capable of standard and multi-stack configurations, the Genesis sliding door offers.");
			slidingDoor.setAvailability("Not Available");
			slidingDoor.setApplicability("Not Applicable");
			components.add(slidingDoor);
			Component garageDoor = ComponentFactory.createComponent(selectedComponentCategory);
			garageDoor.setName("Garage Door");
			components.add(garageDoor);
			break;
		case WINDOW:
			Component frenchWindow = ComponentFactory.createComponent(selectedComponentCategory);
			frenchWindow.setName("French Window");
			frenchWindow.setDetail("A window is an opening in a wall, door, roof or vehicle that allows the passage of light.");
			frenchWindow.setAvailability("Available");
			frenchWindow.setApplicability("Not Applicable");
			components.add(frenchWindow);
			Component frontWindow = ComponentFactory.createComponent(selectedComponentCategory);
			frontWindow.setName("Bay Window");
			frontWindow.setDetail("Standard bay window is configured with a front that is parallel to the house and side wings.");
			frontWindow.setAvailability("Not Available");
			frontWindow.setApplicability("Applicable");
			components.add(frontWindow);
			Component smallWindow = ComponentFactory.createComponent(selectedComponentCategory);
			smallWindow.setName("Aluminium Window");
			smallWindow.setDetail("Modern aluminium window frames are typically separated by a thermal break made of a polyamide.");
			smallWindow.setAvailability("Available");
			smallWindow.setApplicability("Applicable");
			components.add(smallWindow);
		break;
		case FOUNDATION:
			Component waffle = ComponentFactory.createComponent(selectedComponentCategory);
			waffle.setName("Waffle Slab");
			waffle.setDetail("Waffle slabs need very firm soils and excellent drainage.");
			waffle.setAvailability("Available");
			waffle.setApplicability("Applicable");
			components.add(waffle);
			Component pileAndBeam = ComponentFactory.createComponent(selectedComponentCategory);
			pileAndBeam.setName("Pile & Beam");
			pileAndBeam.setDetail("Piled foundations consist of a number of piles connected by a ring of concrete called a ground beam.");
			pileAndBeam.setAvailability("Not Available");
			pileAndBeam.setApplicability("Applicable");
			components.add(pileAndBeam);
			Component mat = ComponentFactory.createComponent(selectedComponentCategory);
			mat.setName("Mat Foundation");
			mat.setDetail("An on-grade mat foundation is an above-ground type of foundation.");
			mat.setAvailability("Available");
			mat.setApplicability("Applicable");
			components.add(mat);
		break;
		case ROOF:
			Component tile = ComponentFactory.createComponent(selectedComponentCategory);
			tile.setName("Tile Roof");
			tile.setDetail("Terracotta and concrete roof tiles each offer a different aesthetic and surface finish");
			tile.setAvailability("Available");
			tile.setApplicability("Not Applicable");
			components.add(tile);
			Component metal = ComponentFactory.createComponent(selectedComponentCategory);
			metal.setName("Metal Roof");
			metal.setDetail("A metal roof is a roofing system made from metal pieces or tiles.");
			metal.setAvailability("Not Available");
			metal.setApplicability("Applicable");
			components.add(metal);
		break;
		case WALL:
			Component weatherboard = ComponentFactory.createComponent(selectedComponentCategory);
			weatherboard.setName("Weatherboard");
			weatherboard.setDetail("A pre-primed, site-painted weatherboard, available in a range of profiles from contemporary to traditional.");
			weatherboard.setAvailability("Available");
			weatherboard.setApplicability("Applicable");
			components.add(weatherboard);
			Component brickVeneer = ComponentFactory.createComponent(selectedComponentCategory);
			brickVeneer.setName("Brick Veneer");
			brickVeneer.setDetail("A brick veneer wall is constructed by having a non-structural external layer.");
			brickVeneer.setAvailability("Not Available");
			brickVeneer.setApplicability("Not Applicable");
			components.add(brickVeneer);
			Component doubleBrick = ComponentFactory.createComponent(selectedComponentCategory);
			doubleBrick.setName("Double Brick");
			doubleBrick.setDetail("In double brick, the two leaves of brick walls are separated by a cavity.");
			doubleBrick.setAvailability("Available");
			doubleBrick.setApplicability("Applicable");
			components.add(doubleBrick);
		break;
		}
		
		return components;
	}

	public List<Product> getProducts()
	{
		List<Product> houseDesigns = new ArrayList<Product>();
		
		House houseOne = new House();
		houseOne.setName("Californian bungalow");
		Product productOne = new Product();
		productOne.setHouse(houseOne);
		houseDesigns.add(productOne);
		House houseTwo = new House();
		houseTwo.setName("Brick clinker");
		Product productTwo = new Product();
		productTwo.setHouse(houseTwo);
		houseDesigns.add(productTwo);
		House houseThree = new House();
		houseThree.setName("Townhouse");
		Product productThree = new Product();
		productThree.setHouse(houseThree);
		houseDesigns.add(productThree);
		House houseFour = new House();
		houseFour.setName("Family home");
		Product productFour = new Product();
		productFour.setHouse(houseFour);
		houseDesigns.add(productFour);
		
		return houseDesigns;
	}

	public List<Component> getRequiredFeatures(Product product)
	{
		return new ArrayList<Component>();
	}

	public Product addComponentToProduct(Product product, Component component)
	{
		House selectedHouseDesign = product.getHouse();
		if(component instanceof Foundation)
		{
			selectedHouseDesign.setFoundation((Foundation) component.clone(Foundation.class));
		}
		if(component instanceof Roof)
		{
			selectedHouseDesign.setRoof((Roof) component.clone(Roof.class));
		}
		if(component instanceof Wall)
		{
			List<Wall> walls = selectedHouseDesign.getWalls();
			if(walls == null)
				walls = new ArrayList<Wall>();
			walls.add((Wall) component.clone(Wall.class));
			selectedHouseDesign.setWalls(walls);
		}
		if(component instanceof Aperture)
		{
			List<Wall> walls = selectedHouseDesign.getWalls();
			if(walls != null)
			{
				for(Wall wall : walls)
				{
					List<Aperture> apertures = wall.getApertures();
					if(apertures == null)
						apertures = new ArrayList<Aperture>();
					apertures.add((Aperture) component.clone(Aperture.class));
					wall.setApertures(apertures);
				}
			}
		}
		return product;
	}
}
