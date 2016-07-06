package com.mbirtchnell.ocmjea.domain;

import javax.persistence.Entity;

@Entity
public class Window extends Aperture
{
	@Override
	public Prototypable clone()
	{
		Window clone = new Window();
		clone.setName(getName());
		return clone;
	}
}
