package com.mbirtchnell.ocmjea.converters;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.mbirtchnell.ocmjea.controllers.HouseDesignController;
import com.mbirtchnell.ocmjea.domain.House;

@FacesConverter(forClass=House.class)
public class HouseConverter implements Converter 
{
	public Object getAsObject(FacesContext context, UIComponent uiComponent, String value)
	{
		HouseDesignController viewBean = context.getApplication().evaluateExpressionGet(context, "#{houseDesignController}", HouseDesignController.class);
		List<House> components = viewBean.getHouseDesigns(); 
		
		House foundComponent = null;
		for(House component : components)
		{
			if(component.getId().equals(value))
			{
				foundComponent = component;
				break;
			}
		}
		return foundComponent;
	}

	public String getAsString(FacesContext context, UIComponent uiComponent, Object obj)
	{
		HouseDesignController viewBean = context.getApplication().evaluateExpressionGet(context, "#{houseDesignController}", HouseDesignController.class);
		List<House> components = viewBean.getHouseDesigns(); 
		
		String foundComponent = null;
		for(House component : components)
		{
			if(component.equals(obj))
			{
				foundComponent = component.getId();
				break;
			}
		}
		return foundComponent;
	}
}