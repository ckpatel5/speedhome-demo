package com.speedhome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.speedhome.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

	@Modifying
	@Query(value="update Property p set p.approve = true where p.id = :id",nativeQuery=true)
	int approve(Long id);
	
	@Query(value="select * from Property p where p.owner_name like %?1% or p.carpet_area like %?1% or p.property_number like %?1% or p.property_type like %?1% ", nativeQuery=true)
	List<Property> search(String keyword);
	
}
