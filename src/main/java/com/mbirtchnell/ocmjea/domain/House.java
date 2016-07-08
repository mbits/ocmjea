package com.mbirtchnell.ocmjea.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class House implements Prototypable<House>
{
	@Id private String id;
	@OneToOne private Foundation foundation;
	@OneToMany private List<Wall> walls;
	@OneToOne private Roof roof;
	private String name;
	
	public House()
	{
		this.id = IdGenerator.generateId(); 
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
	
	public Foundation getFoundation()
	{
		return foundation;
	}
	public void setFoundation(Foundation foundation)
	{
		this.foundation = foundation;
	}
	public List<Wall> getWalls()
	{
		return walls;
	}
	public void setWalls(List<Wall> walls)
	{
		this.walls = walls;
	}
	public Roof getRoof()
	{
		return roof;
	}
	public void setRoof(Roof roof)
	{
		this.roof = roof;
	}
	public String getSummary()
	{
		String summary = this.getName() + " + ";
		if(this.getFoundation() != null)
			summary += this.getFoundation().getName() + " + "; 
		if(this.getRoof() != null)
			summary += this.getRoof().getName() + " + ";
		if(this.getWalls() != null)
		{
			for(Wall wall : this.getWalls())
			{
				summary += wall.getName() + " + ";
				if(wall.getApertures() != null)
				{
					for(Aperture aperture : wall.getApertures())
					{
						summary += aperture.getName() + " + ";
					}
				}
			}
		}
		return summary;
	}
	
	public House clone(Class<? extends House> clazz)
	{
		House clone = new House();
		clone.setName(name);
		if(getFoundation() != null)
			clone.setFoundation((Foundation) getFoundation().clone(Foundation.class));
		if(getRoof() != null)
			clone.setRoof((Roof) getRoof().clone(Roof.class));
		if(getWalls() != null)
		{
			List<Wall> walls = getWalls();
			List<Wall> clonedWalls = new ArrayList<Wall>();
			for(Wall wall : walls)
			{
				clonedWalls.add((Wall) wall.clone(Wall.class));
			}
			clone.setWalls(clonedWalls);
		}
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
		House other = (House) obj;
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
