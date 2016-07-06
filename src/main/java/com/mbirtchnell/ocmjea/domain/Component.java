package com.mbirtchnell.ocmjea.domain;

public interface Component extends Prototypable
{
//	@Id @GeneratedValue private int id;
//	private String name;
//	private String details;
//	private boolean isAvailable;
//	private boolean isApplicable;
//	@ManyToOne private Component parent;
//	@OneToMany(mappedBy="parent") private List<Component> childComponents;

	public String getId();
//	{
//		return id;
//	}
//
	public void setId(String id);
//	{
//		this.id = id;
//	}
//	
	public String getName();
//	{
//		return name;
//	}
//
	public void setName(String name);
//	{
//		this.name = name;
//	}
//
//	public String getDetails()
//	{
//		return details;
//	}
//	
//	public void setDetails(String details)
//	{
//		this.details = details;
//	}
//	
//	public boolean isAvailable()
//	{
//		return isAvailable;
//	}
//	
//	public void setAvailable(boolean isAvailable)
//	{
//		this.isAvailable = isAvailable;
//	}
//
//	public boolean isApplicable() 
//	{
//		return isApplicable;
//	}
//
//	public void setApplicable(boolean isApplicable) 
//	{
//		this.isApplicable = isApplicable;
//	}
//
//	public Component getParent()
//	{
//		return parent;
//	}
//
//	public void setParent(Component parent)
//	{
//		this.parent = parent;
//	}
//
//	public List<Component> getChildComponents()
//	{
//		return childComponents;
//	}
//
//	public void setChildComponents(List<Component> childComponents)
//	{
//		this.childComponents = childComponents;
//	}
//	
//	public void addToChildComponents(Component component)
//	{
//		List<Component> childComponents = getChildComponents();
//		if(childComponents == null)
//			childComponents = new ArrayList<Component>();
//		childComponents.add(component);
//		setChildComponents(childComponents);
//	}
//
//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((details == null) ? 0 : details.hashCode());
//		result = prime * result + (isAvailable ? 1231 : 1237);
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj)
//	{
//		if(this == obj)
//			return true;
//		if(obj == null)
//			return false;
//		if(getClass() != obj.getClass())
//			return false;
//		Component other = (Component) obj;
//		if(details == null)
//		{
//			if(other.details != null)
//				return false;
//		}
//		else if(!details.equals(other.details))
//			return false;
//		if(isAvailable != other.isAvailable)
//			return false;
//		if(name == null)
//		{
//			if(other.name != null)
//				return false;
//		}
//		else if(!name.equals(other.name))
//			return false;
//		return true;
//	}
}
