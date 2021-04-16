package com.speedhome.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.speedhome.model.Property;
import com.speedhome.repository.PropertyRepository;
import com.speedhome.service.PropertyServices;

@Service
@Transactional
public class PropertyServicesImpl implements PropertyServices {

	@Autowired
	private PropertyRepository repository;
	
	@Override
	public Property createOrUpdate(Property property) {
		return repository.save(property);
	}

	@Override
	public int approve(Long id) {
		return repository.approve(id);
	}

	@Override
	public List<Property> search(String keyword) {
		return repository.search(keyword);
	}

}
