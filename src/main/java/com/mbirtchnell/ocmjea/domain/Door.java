package com.mbirtchnell.ocmjea.domain;

import javax.persistence.Entity;

@Entity
public class Door extends Aperture
{
	@Override
	public Prototypable clone()
	{
		Door clone = new Door();
		clone.setName(getName());
		return clone;
	}
}
