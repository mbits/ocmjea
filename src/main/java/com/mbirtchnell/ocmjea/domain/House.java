package com.mbirtchnell.ocmjea.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class House
{
	@Id @GeneratedValue private int id;
	@OneToOne private Foundation foundation;
	@OneToMany private List<Wall> walls;
	@OneToOne private Roof roof;
	private String name;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
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
						summary += aperture.getName();
					}
				}
			}
		}
		return summary;
	}
}
