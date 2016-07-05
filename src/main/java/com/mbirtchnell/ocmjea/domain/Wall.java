package com.mbirtchnell.ocmjea.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Wall extends Component
{
	@Id @GeneratedValue private int id;
	@OneToMany List<Aperture> apertures;

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public List<Aperture> getApertures()
	{
		return apertures;
	}
	public void setApertures(List<Aperture> apertures)
	{
		this.apertures = apertures;
	}
}
