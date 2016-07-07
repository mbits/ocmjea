package com.mbirtchnell.ocmjea.converters;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.mbirtchnell.ocmjea.controllers.ConsultationController;
import com.mbirtchnell.ocmjea.domain.Customer;

@FacesConverter(forClass=Customer.class)
public class CustomerConverter implements Converter 
{
	public Object getAsObject(FacesContext context, UIComponent uiComponent, String value)
	{
		ConsultationController viewBean = context.getApplication().evaluateExpressionGet(context, "#{consultationController}", ConsultationController.class);
		List<Customer> components = viewBean.getCustomers();
		
		Customer foundComponent = null;
		for(Customer component : components)
		{
			if(component.getEmail().equals(value))
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
		List<Customer> components = viewBean.getCustomers();
		
		String foundComponent = null;
		for(Customer component : components)
		{
			if(component.equals(obj))
			{
				foundComponent = component.getEmail();
				break;
			}
		}
		return foundComponent;
	}
}