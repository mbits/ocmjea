package com.mbirtchnell.ocmjea.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.mbirtchnell.ocmjea.domain.CompletedDesign;
import com.mbirtchnell.ocmjea.domain.FieldSalesRepresentative;
import com.mbirtchnell.ocmjea.services.ConsultationService;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ConsultationController implements Serializable
{
	private String searchTerm;
	private List<CompletedDesign> prospects = new ArrayList<CompletedDesign>();
	private CompletedDesign selectedProspect;
	private boolean scheduled;
	private FieldSalesRepresentative fieldSalesRepresentative;
	
	@EJB
	private ConsultationService consultationService;
	
	@PostConstruct
	public void init()
	{
		consultationService.init();
	}
	
	public void search()
	{
		prospects = consultationService.searchByZipCode(searchTerm);
	}

	public FieldSalesRepresentative getFieldSalesRepresentative()
	{
		return this.fieldSalesRepresentative;
	}
	
	public void setFieldSalesRepresentative(FieldSalesRepresentative fieldSalesRepresentative)
	{
		this.fieldSalesRepresentative = fieldSalesRepresentative;
	}

	public String getSearchTerm()
	{
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm)
	{
		this.searchTerm = searchTerm;
	}

	public List<CompletedDesign> getProspects()
	{
		return prospects;
	}

	public void setProspects(List<CompletedDesign> prospects)
	{
		this.prospects = prospects;
	}

	public CompletedDesign getSelectedProspect()
	{
		return selectedProspect;
	}

	public void setSelectedProspect(CompletedDesign selectedProspect)
	{
		this.selectedProspect = selectedProspect;
	}
	
	public boolean isScheduled()
	{
		return scheduled;
	}

	public void setScheduled(boolean isScheduled)
	{
		this.scheduled = isScheduled;
	}
}
