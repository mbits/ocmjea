package com.mbirtchnell.ocmjea.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class House extends Component
{
	@Id @GeneratedValue private int id;
	@OneToOne private Foundation foundation;
	@OneToMany private List<Wall> walls;
	@OneToOne private Roof roof;

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
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
}
