package com.mbirtchnell.ocmjea.converters;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.mbirtchnell.ocmjea.controllers.ConsultationController;
import com.mbirtchnell.ocmjea.domain.CompletedDesign;

@FacesConverter(forClass=CompletedDesign.class)
public class ProspectConverter implements Converter 
{
	public Object getAsObject(FacesContext context, UIComponent uiComponent, String value)
	{
		ConsultationController viewBean = context.getApplication().evaluateExpressionGet(context, "#{consultationController}", ConsultationController.class);
		List<CompletedDesign> components = viewBean.getProspects();
		
		CompletedDesign foundComponent = null;
		for(CompletedDesign component : components)
		{
			if(component.getCustomer().getEmail().equals(value))
			{
				foundComponent = component;
				break;
			}
		}
		return foundComponent;
	}

	public String getAsString(FacesContext context, UIComponent uiComponent, Object obj)
	{
		ConsultationController viewBean = context.getApplication().evaluateExpressionGet(context, "#{consultationController}", ConsultationController.class);
		List<CompletedDesign> components = viewBean.getProspects();
		
		String foundComponent = null;
		for(CompletedDesign component : components)
		{
			if(component.equals(obj))
			{
				foundComponent = component.getCustomer().getEmail();
				break;
			}
		}
		return foundComponent;
	}
}