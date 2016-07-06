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
		return InventorySystem.getComponentsForComponentCategory(selectedComponentCategory, houseDesign);
	}

	public List<House> getHouseDesigns()
	{
		return InventorySystem.getHouseDesigns();
	}

	public void addComponentToHouse(House selectedHouseDesign, Component selectedComponent)
	{
		if(selectedComponent instanceof Foundation)
		{
			selectedHouseDesign.setFoundation((Foundation) selectedComponent.clone());
		}
		if(selectedComponent instanceof Roof)
		{
			selectedHouseDesign.setRoof((Roof) selectedComponent.clone());
		}
		if(selectedComponent instanceof Wall)
		{
			List<Wall> walls = selectedHouseDesign.getWalls();
			if(walls == null)
				walls = new ArrayList<Wall>();
			walls.add((Wall) selectedComponent.clone());
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
					apertures.add((Aperture) selectedComponent.clone());
					wall.setApertures(apertures);
				}
			}
		}
	}
}