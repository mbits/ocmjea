package com.mbirtchnell.ocmjea.services;

import com.mbirtchnell.ocmjea.domain.Product;

public class ModellingSystemBroker
{
	public Product generateHouseDesign(Product product) throws InterruptedException
	{
		// Call web service for modelling system broker
        Thread.sleep(5000);
        
        product.setGeneratedDownloadLink("http://localhost:8080/download.xhml");
        return product;
	}
}
