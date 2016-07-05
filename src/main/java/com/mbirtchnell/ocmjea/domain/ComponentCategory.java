package com.mbirtchnell.ocmjea.domain;

public enum ComponentCategory
{
	DOOR("Door"), FOUNDATION("Foundation"), WALL("Wall"), WINDOW("Window"), ROOF("Roof");
	
	private final String name;

	private ComponentCategory(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
}
