package com.mbirtchnell.ocmjea.controllers;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.mbirtchnell.ocmjea.domain.ComponentCategory;

@FacesConverter(forClass=ComponentCategory.class)
public class ComponentCategoryConverter implements Converter 
{
	public Object getAsObject(FacesContext context, UIComponent uiComponent, String value)
	{
		HouseDesignController viewBean = context.getApplication().evaluateExpressionGet(context, "#{houseDesignController}", HouseDesignController.class);
		List<ComponentCategory> components = viewBean.getComponentCategories(); 
		
		ComponentCategory foundComponent = null;
		for(ComponentCategory component : components)
		{
			if(component.getName().equals(value))
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
		List<ComponentCategory> components = viewBean.getComponentCategories(); 
		
		String foundComponent = null;
		for(ComponentCategory component : components)
		{
			if(component.equals(obj))
			{
				foundComponent = component.getName();
				break;
			}
		}
		return foundComponent;
	}
}