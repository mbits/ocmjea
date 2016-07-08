package com.mbirtchnell.ocmjea.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mbirtchnell.ocmjea.domain.CompletedDesign;
import com.mbirtchnell.ocmjea.domain.Component;
import com.mbirtchnell.ocmjea.domain.ComponentCategory;
import com.mbirtchnell.ocmjea.domain.Customer;
import com.mbirtchnell.ocmjea.domain.HouseDesignStatus;
import com.mbirtchnell.ocmjea.domain.Product;
import com.mbirtchnell.ocmjea.services.HouseDesignService;
import com.sun.istack.logging.Logger;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class HouseDesignController implements Serializable
{
	private static final Logger log = Logger.getLogger(HouseDesignController.class);
	@EJB private HouseDesignService houseDesignService;
	private String houseDesignName;
	private Product selectedHouseDesign;
	private ComponentCategory selectedComponentCategory;
	private List<ComponentCategory> componentCategories;
	private List<Component> components;
	private Component selectedComponent;
	private Future<Product> asyncResult;
	private String result;
	private boolean polling;
	private Customer currentCustomer;
	private CompletedDesign currentCompletedDesign;
	private static final String HOUSE_DESIGNS = "houseDesigns";

	@PostConstruct
	public void init()
	{
		log.info("Initializing");
		if(getHouseDesigns() == null)
			setHouseDesigns(houseDesignService.getHouseDesigns());
		setComponentCategories(houseDesignService.getComponentCategories());
		currentCustomer = new Customer();
	}

	public void getComponentsForCategory()
	{
		components = houseDesignService.getComponentsForComponentCategory(selectedComponentCategory, selectedHouseDesign);
	}

	public void addComponentToHouseDesign()
	{
		components = null;
		selectedHouseDesign = houseDesignService.addComponentToHouseDesign(selectedHouseDesign, selectedComponent);
	}

	public void completeHouseDesign()
	{
		polling = true;
		try 
		{
            asyncResult = houseDesignService.completeHouseDesign(selectedHouseDesign);
            if(asyncResult.isDone()) 
            {
                this.setResult(asyncResult.get().getGeneratedDownloadLink());
            } 
            else 
            {
                this.setResult("Generating house design...");
            }
        }
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		catch(ExecutionException e)
		{
			e.printStackTrace();
		}
	}

	public void acceptCompletedHouseDesign()
	{
		currentCompletedDesign = new CompletedDesign();
		currentCompletedDesign.setCustomer(currentCustomer);
		List<Product> products = new ArrayList<Product>();
		products.add(selectedHouseDesign);
		currentCompletedDesign.setProducts(products);
		List<CompletedDesign> completedDesigns = currentCustomer.getCompletedDesigns();
		if(completedDesigns == null)
			completedDesigns = new ArrayList<CompletedDesign>();
		completedDesigns.add(currentCompletedDesign);
	}

	public void pollCompletedHouseDesign() 
	{
        try 
        {
        	if(asyncResult == null)
        	{
        		this.setResult("");
        	}
        	else if(asyncResult.isDone()) 
            {
        		selectedHouseDesign.setStatus(HouseDesignStatus.COMPLETED);
                this.setResult(asyncResult.get().getGeneratedDownloadLink());
                polling = false;
            } 
            else 
            {
                this.setResult("Still processing house design...");
            }
        } 
        catch (InterruptedException ex) 
        {
        	ex.printStackTrace();
        } 
        catch (ExecutionException ex) 
        {
            ex.printStackTrace();
        }
    }

	public String getHouseDesignName()
	{
		return houseDesignName;
	}

	public void setHouseDesignName(String houseDesignName)
	{
		this.houseDesignName = houseDesignName;
	}
	
	public Product getSelectedHouseDesign()
	{
		return selectedHouseDesign;
	}

	public void setSelectedHouseDesign(Product selectedHouseDesign)
	{
		this.selectedHouseDesign = selectedHouseDesign;
	}

	public ComponentCategory getSelectedComponentCategory()
	{
		return selectedComponentCategory;
	}

	public void setSelectedComponentCategory(ComponentCategory selectedComponentCategory)
	{
		this.selectedComponentCategory = selectedComponentCategory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getHouseDesigns()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		List<Product> houseDesigns = (List<Product>) httpSession.getAttribute(HOUSE_DESIGNS);
		return houseDesigns;
	}

	public void setHouseDesigns(List<Product> houseDesigns)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		httpSession.setAttribute(HOUSE_DESIGNS, houseDesigns);
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

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public boolean isPolling()
	{
		return polling;
	}

	public void setPolling(boolean isPolling)
	{
		this.polling = isPolling;
	}
}
