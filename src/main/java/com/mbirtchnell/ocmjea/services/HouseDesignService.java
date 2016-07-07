package com.mbirtchnell.ocmjea.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mbirtchnell.ocmjea.domain.Aperture;
import com.mbirtchnell.ocmjea.domain.Component;
import com.mbirtchnell.ocmjea.domain.ComponentCategory;
import com.mbirtchnell.ocmjea.domain.Foundation;
import com.mbirtchnell.ocmjea.domain.House;
import com.mbirtchnell.ocmjea.domain.Product;
import com.mbirtchnell.ocmjea.domain.Roof;
import com.mbirtchnell.ocmjea.domain.Wall;

@Stateless
public class HouseDesignService
{
	@PersistenceContext(unitName = "test")
	private EntityManager entityManager;
	
	@Inject
	private InventorySystemBroker inventorySystemBroker;
	
	@Inject
	private ModellingSystemBroker modellingSystemBroker;

	public List<ComponentCategory> getComponentCategories()
	{
		return inventorySystemBroker.getComponentCategories();
	}

	public List<Component> getComponentsForComponentCategory(ComponentCategory selectedComponentCategory, Product houseDesign)
	{
		return inventorySystemBroker.getComponentsForComponentCategory(selectedComponentCategory, houseDesign);
	}

	public List<Product> getHouseDesigns()
	{
		return inventorySystemBroker.getHouseDesigns();
	}

	public void addComponentToHouseDesign(Product product, Component component)
	{
		House selectedHouseDesign = product.getHouse();
		if(component instanceof Foundation)
		{
			selectedHouseDesign.setFoundation((Foundation) component.clone());
		}
		if(component instanceof Roof)
		{
			selectedHouseDesign.setRoof((Roof) component.clone());
		}
		if(component instanceof Wall)
		{
			List<Wall> walls = selectedHouseDesign.getWalls();
			if(walls == null)
				walls = new ArrayList<Wall>();
			walls.add((Wall) component.clone());
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
					apertures.add((Aperture) component.clone());
					wall.setApertures(apertures);
				}
			}
		}
	}

	@Asynchronous
	public Future<Product> completeHouseDesign(Product product) throws InterruptedException
	{
		// Fill in required features
		List<Component> requiredFeatures = inventorySystemBroker.getRequiredFeatures(product);
		for(Component requiredComponent : requiredFeatures)
		{
			addComponentToHouseDesign(product, requiredComponent);
		}
		
		// Calculate cost
		product.calculateIndicativeCost();
		
		Product finishedProduct = null;
		finishedProduct = modellingSystemBroker.generateHouseDesign(product);
	
        return new AsyncResult<Product>(finishedProduct);
	}
}