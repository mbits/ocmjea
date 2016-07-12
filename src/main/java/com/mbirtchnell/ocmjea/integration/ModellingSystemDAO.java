package com.mbirtchnell.ocmjea.integration;

import java.util.logging.Logger;

import javax.ejb.Stateless;

import com.mbirtchnell.ocmjea.domain.Product;

@Stateless
public class ModellingSystemDAO
{
	private static final Logger log = Logger.getLogger("ModellingSystemDAO");
	public Product generateHouseDesign(Product product) throws InterruptedException
	{
		log.info("Generating House Design");
		// Call web service for modelling system broker
        Thread.sleep(5000);
        
        product.setGeneratedDownloadLink("http://localhost:8080/download.xhml");
        return product;
	}
}
