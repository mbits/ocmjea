package com.mbirtchnell.ocmjea.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Wall implements Component
{
	@Id private String id;
	@OneToMany List<Aperture> apertures;
	private String name;
	
	public Wall()
	{
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public List<Aperture> getApertures()
	{
		return apertures;
	}
	public void setApertures(List<Aperture> apertures)
	{
		this.apertures = apertures;
	}
	
	@Override
	public Prototypable clone()
	{
		Wall clone = new Wall();
		clone.setName(getName());
		return clone;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Wall other = (Wall) obj;
		if(id == null)
		{
			if(other.id != null)
				return false;
		}
		else if(!id.equals(other.id))
			return false;
		return true;
	}
}
