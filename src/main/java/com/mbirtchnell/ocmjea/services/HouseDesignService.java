package com.mbirtchnell.ocmjea.services;

import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mbirtchnell.ocmjea.domain.Component;
import com.mbirtchnell.ocmjea.domain.ComponentCategory;
import com.mbirtchnell.ocmjea.domain.Product;
import com.mbirtchnell.ocmjea.integration.InventorySystemDAO;
import com.mbirtchnell.ocmjea.integration.ModellingSystemDAO;

@Stateless
public class HouseDesignService
{
	private static final Logger log = Logger.getLogger("HouseDesignService");
	@PersistenceContext(unitName = "test")
	private EntityManager entityManager;
	
	@EJB
	private InventorySystemDAO inventorySystemService;
	
	@EJB
	private ModellingSystemDAO modellingSystemService;
	
	@PostConstruct
	public void init()
	{
		log.info("Initializing...");
	}

	public List<ComponentCategory> getComponentCategories()
	{
		return inventorySystemService.getComponentCategories();
	}

	public List<Component> getComponentsForCategory(ComponentCategory componentCategory, Product houseDesign)
	{
		return inventorySystemService.getComponentsForCategory(componentCategory, houseDesign);
	}

	public List<Product> getHouseDesigns()
	{
		return inventorySystemService.getProducts();
	}

	public Product addComponentToHouseDesign(Product product, Component component)
	{
		return inventorySystemService.addComponentToProduct(product, component);
	}

	@Asynchronous
	public Future<Product> completeHouseDesign(Product product) throws InterruptedException
	{
		// Fill in required features
		List<Component> requiredFeatures = inventorySystemService.getRequiredFeatures(product);
		for(Component requiredComponent : requiredFeatures)
		{
			addComponentToHouseDesign(product, requiredComponent);
		}
		
		// Calculate cost
		product.calculateIndicativeCost();
		
		Product finishedProduct = null;
		finishedProduct = modellingSystemService.generateHouseDesign(product);
	
        return new AsyncResult<Product>(finishedProduct);
	}
}