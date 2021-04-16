package com.speedhome.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speedhome.model.Property;
import com.speedhome.service.PropertyServices;

@RestController
@RequestMapping("/propertyManagement")
public class PropertyManagementController {

	private static final Logger log = LoggerFactory.getLogger(PropertyManagementController.class);
	
	@Autowired
	private	PropertyServices propertyService;
	
	@PostMapping("/create")
	public String createProperty(@RequestBody Property property) {
		log.info("Starting proprty creation");
		log.info(property.toString());
		try{
			Property createdProperty = propertyService.createOrUpdate(property);
			return "Property created with id " + createdProperty.getId() + ".";
		} catch(Exception e) {
			return "Try again.";
		}
	}
	
	@PutMapping("/update")
	public String updateProperty(@RequestBody Property property) {
		log.info("Starting property creation");
		log.info(property.toString());
		try{
			Property createdProperty = propertyService.createOrUpdate(property);
			return "Id " + createdProperty.getId() +" property updated." ;
		} catch(Exception e) {
			return "Try again.";
		}
	}
	
	@PutMapping("/approve")
	public String approveProperty(@RequestBody Property property) {
		long id = property.getId() ;
		log.info("approving proprty id " +id );
		try{
			propertyService.approve(id);
			return "Property having id " + id + " is approved successfully"; 
		} catch(Exception e) {
			log.error(e.toString());
			return "Try again.";
		}
	}
	
	@GetMapping("/search/{keyword}")
	public List<Property> search(@PathVariable("keyword") String keyword){
		log.info("Searching...");
		return propertyService.search(keyword);
	}
}
