package com.mbirtchnell.ocmjea.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Wall extends Component
{
	@OneToMany List<Aperture> apertures;
	
	public List<Aperture> getApertures()
	{
		return apertures;
	}
	
	public void setApertures(List<Aperture> apertures)
	{
		this.apertures = apertures;
	}
}
