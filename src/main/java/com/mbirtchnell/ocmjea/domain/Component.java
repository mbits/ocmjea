package com.mbirtchnell.ocmjea.domain;

public abstract class Component
{
	private String name;
	private String details;
	private boolean isAvailable;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDetails()
	{
		return details;
	}
	public void setDetails(String details)
	{
		this.details = details;
	}
	public boolean isAvailable()
	{
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable)
	{
		this.isAvailable = isAvailable;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + (isAvailable ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if(details == null)
		{
			if(other.details != null)
				return false;
		}
		else if(!details.equals(other.details))
			return false;
		if(isAvailable != other.isAvailable)
			return false;
		if(name == null)
		{
			if(other.name != null)
				return false;
		}
		else if(!name.equals(other.name))
			return false;
		return true;
	}
}
