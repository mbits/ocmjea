package com.mbirtchnell.ocmjea.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Component implements Prototypable<Component>
{
	@Id
	protected String id;
	private String name;
	private String detail;
	private String availability;
	private String applicability;
	
	public Component()
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
	
	public String getDetail()
	{
		return detail;
	}

	public void setDetail(String detail)
	{
		this.detail = detail;
	}

	public String getAvailability()
	{
		return availability;
	}

	public void setAvailability(String availability)
	{
		this.availability = availability;
	}

	public String getApplicability()
	{
		return applicability;
	}

	public void setApplicability(String applicability)
	{
		this.applicability = applicability;
	}

	public Component clone(Class<? extends Component> clazz)
	{
		Component clone = null;
		 
		try
		{
		   clone = clazz.newInstance();
		}
		catch (InstantiationException e)
		{
		   e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
		   e.printStackTrace();
		}
		
		clone.setName(this.name);
		clone.setDetail(this.detail);
		clone.setAvailability(this.availability);
		clone.setApplicability(this.applicability);
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
		Component other = (Component) obj;
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