package com.mbirtchnell.ocmjea.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FieldSalesRepresentative
{
	@Id @GeneratedValue private int id;
	@OneToMany private List<Consultation> consultations;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public List<Consultation> getConsultations()
	{
		return consultations;
	}
	public void setConsultations(List<Consultation> consultations)
	{
		this.consultations = consultations;
	}
}
