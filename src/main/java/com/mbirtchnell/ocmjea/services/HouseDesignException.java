package com.mbirtchnell.ocmjea.services;

@SuppressWarnings("serial")
public class HouseDesignException extends Exception
{
	public HouseDesignException()
	{
	}
	
	public HouseDesignException(InterruptedException e)
	{
		super(e);
	}
}
