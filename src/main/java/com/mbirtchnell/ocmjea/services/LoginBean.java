package com.mbirtchnell.ocmjea.services;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean
{
	@EJB
	CustomerBean customerBean;
	
	public LoginBean()
	{
	}
	
	@PostConstruct
	public void init()
	{
		System.out.println("LoginBean instantiated");	
		customerBean.test();
	}

	public String getMessage()
	{
		return "Initialised";
	}
}
