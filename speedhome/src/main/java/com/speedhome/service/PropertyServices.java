package com.speedhome.service;

import java.util.List;

import com.speedhome.model.Property;

public interface PropertyServices {

	Property createOrUpdate(Property property);
	
	int approve(Long id); 
	
	List<Property> search(String keyword);
}

