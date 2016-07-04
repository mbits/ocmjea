package com.mbirtchnell.ocmjea;

import javax.inject.Named;

@Named
public class LoginBean
{
	public LoginBean()
	{
		System.out.println("LoginBean instantiated");
	}

	public String getMessage()
	{
		return "I'm alive!";
	}
}
