package com.mbirtchnell.ocmjea.domain;

public class ComponentFactory
{
	public static Component createComponent(ComponentCategory selectedComponentCategory)
	{
		Component component = null;
		switch(selectedComponentCategory)
		{
		case DOOR:
			component = new Door();
			break;
		case ROOF:
			component = new Roof();
			break;
		case FOUNDATION:
			component = new Foundation();
			break;
		case WALL:
			component = new Wall();
			break;
		case WINDOW:
			component = new Window();
			break;
		default:
			break;
		}
		return component;
	}

}
